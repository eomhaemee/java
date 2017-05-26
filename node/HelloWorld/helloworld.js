/**
 * Created by Admin on 2017-04-28.
 */
var http = require('http');
var fs = require('fs');
var url = require('url');
var ejs = require('ejs');
var server = http.createServer(function(request,response){
    //response.writeHead(200,{'Content-Type':'text/html'}); //상태코드: 200
    //response.end('<h1>Hello World!</h1>>');//end() body부분을 만들어 실행시켜 보냄
   
    //읽은 결과를 function에 줌 err:파일 읽다가 문제발생시 err에 담김, data: 읽은 파일의 내용을 stream으로 담김
    var pathName = url.parse(request.url).pathname; //url 은 사용자가 요청한 url을 쪼개줌
    console.log('pathName ' + pathName); //http://localhost:3000/ehm  브라우저 실행시 pathName=> ' /ehm '
    if ( pathName == '/' ) {
        fs.readFile('helloworld.html', function (err, data) {
     /*       console.log('err: ' + err);
            console.log(data);
            console.log(data.toString());
*/
            response.writeHead(200, {'Content-Type': 'text/html'});
            response.end(data);
        });
    }else if ( pathName == '/login' ) {
        fs.readFile('login.html', function (err, data) {
            response.writeHead(200, {'Content-Type': 'text/html'});
            response.end(data);
        });
    }else if(pathName == '/my') {
        // ejs 는 data가 넘어가는 부분 이 있으므로 'utf8' charset도 써줘야함
        fs.readFile('ejs/my_page.ejs', 'utf8', function (err, data) {
            response.writeHead(200, {'Content-Type': 'text/html'});
            response.end(ejs.render(data, { //ejs 파일을 보낼떄는 render를 사용함
                title: 'My page',
                name: 'Eom hae mee'
            }));
        });
    }else if(pathName == '/articles'){
            fs.readFile('ejs/articles.ejs','utf8', function (err, data) {
                response.writeHead(200, {'Content-Type': 'text/html'});
                response.end(ejs.render(data,{
                    title: 'My page',
                    list : [
                        {number:1, subject:'Hello!'},
                        {number:2, subject:'Node.js!'},
                        {number:3, subject:'Hello, ejs!'}
                    ]
                }));
            });
    } else{
        response.writeHead(404,{'Content-Type': 'text/html'});
        response.end('<h1>Page Not Found!</h1>');
    }



}); //response이 들어오면 create함
server.listen(3000,function(){
    console.log('Server running at http://localhost:3000');
});// 서버를 띄운후 콘솔에 띄움
