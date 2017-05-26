const http  = require('http');
const express = require('express');
const fs = require('fs');
const socketio = require('socket.io');
const path=require('path');
const app = express();

app.use('/node_modules',express.static(path.join(__dirname,'node_modules')));

const server = http.createServer(app);
server.listen(3000,function(){
    console.log('Server running at http://localhost:3000');
});

const io = socketio.listen(server);

io.sockets.on('connection',function(socket){
    socket.join('mychat');
    socket.on('chattingStart',function(data){
        io.sockets.in('mychat').emit('chatting',data);
    });
});

app.use(function(req,res){
    fs.readFile('client.html','utf-8',function(err,data){
        res.type('text/html');
        res.send(data);
    });
});