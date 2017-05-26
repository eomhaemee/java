/**
 * Created by Admin on 2017-04-28.
 */
var http = require('http');
var express = require('express');

var app = express();

app.use(function(request,response){
    var name = request.query.name;
    var job = request.query.job;
    response.type('text/html');
    response.send('<h1>' + name + ','+ job+'</h1>');

});
app.listen(3000,function(){
    console.log('Server runing at http://localhost:3000');
});
/*

var server = http.createServer(function(request,response){
    response.writeHead(200,{'Content-Type' : 'text/html'});
    response.end('<h1>Hello World!</h1>');
});


server.listen(3000,function(){
    console.log('Server runing at http://localhost:3000');
});
 */
