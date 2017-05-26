/**
 * Created by Admin on 2017-05-10.
 */
const http = require('http');
const socketio = require('socket.io');
const fs = require('fs');
const express = require('express');
const app = express();

app.use(express.static(__dirname + '/public'));

/*
// http 서버를 생성합니다.
const server = http.createServer(function(request, response) {
    fs.readFile("client.html", function(error, data) {
        response.writeHead(200, {"Content-Type": "text/html"});
        response.end(data);
    });

}).listen(3000, function() {
     console.log("Server running at http://localhost:3000");
});
*/

//httpServer를 express서버로 생성
const server = http.createServer(app);
server.listen(3000,function(){
    console.log('Server running at http://localhost:3000');
});

const users=[];

//listen : 서버가 이때 만들어지는데 소켓은 http서버가 필요함
const io = socketio.listen(server);

//socket 방금연결된 브라우져
io.sockets.on('connection',function(socket){

    console.log(io.sockets.in("chat").sockets);


    socket.on('join', function(name) {
        users.push({'name': name, 'id' : socket.id});
       
        //접속한 브라우져객체를 방에 넣는다 접속한 브라우저 객체를 대화 풀에 접속시킨다
        //chat 이라는 방에 넣음
        socket.join("chat");
        socket.emit("getMyId",socket.id);
        //모두에게 user정보를 보여주자
        io.sockets.in("chat").emit("displayAllUsers",users);

    });
    console.log(' 브라우저가 연결되었습니다. ' + socket.id);

    //on: 이벤트를 등록함 data 호출시 전달된 parameger
    socket.on("broadcast", function(data) {
        console.log("Client send data : " + data);
        // emit: on으로 등록되어 있는 이벤트를 호출하여 data를 전달
        //1. 하나의 클라이언트에만 (접속되어 있는 나에게만) 등록된 receive 이벤트를 수행합니다.
        //socket.emit('receive', data);
        // 2. 방에 있는 모든 브라우져에게 receive 이벤트를 수행시킴
        
        //전체에게 보내기
        if (data.receiver =='all') {
            io.sockets.in("chat").emit('receive',data);
        } 
        else{
        //귓속말
            io.sockets.in("chat").sockets[data.receiver].emit('receive', data);
            socket.emit('receive', data); //나한테도 보내기
        }

    });
    socket.on("disconnect",function(){
        console.log("연결이 끊어졌어요 : " ,+ socket.id);
        
        //메모리 관리를 위한 작업
        for( let i in users){
            if(users[i].id = socket.id){
                io.sockets.in("chat").emit('receive',{
                     "name": "시스템",
                     "chat" :users[i].name  + "님이 퇴장했습니다.",
                     "receiver" : "all",
                     "sender" : ""
                 });
                users.splice(i,1);
                break;
            }
        }
        io.sockets.in("chat").emit("displayAllUsers",users);
    });
    
    //접속한 사람들에게 새로운 글이 등록됨을 알람하자
    socket.on('newPost',function(newPostUrl){
        io.sockets.in("chat").emit("popupNews",newPostUrl);
    });
});

app.use(function(req,res){
    fs.readFile('client.html','utf-8',function(err,data){
       res.type('text/html');
       res.send(data);
    });
});