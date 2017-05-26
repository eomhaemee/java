/**
 * Created by Admin on 2017-04-28.
 */
var express = require('express');
var morgan = require('morgan');
var app = express();

//app.use(morgan('combined'));
app.use(morgan('HTTP[:http-version] / METHOD[:method] / REFERRER[:referrer]'));

app.use(express.static(__dirname + '/static'));
app.get('/',function(requset,response){
    response.type('text/html');
    response.send('<h1>index page</h1>>');
});

/*app.user('/article',require('./route/article').router);*/
/*

var express = require('express');

var app = express();

app.get('/article/:id',function(request,response){
    var id = request.params.id;

    var items = [
        {name:'eom hae mee', job:'학생'},
        {name:'osk', job:'회사원'}
    ];
    response.type('text/html');
    response.send('<h1>'+items[id].name + '</h1>');

});
*/

/*

app.get('/',function(request,response){
    response.type('text/html');
    response.send('<h1> Welcome to index page </h1>');

});

app.get('/bye',function(request,response){
    response.type('text/html');
    response.send('<h1> bye~ </h1>');

});
*/


/*app.use(function(request,response){
    var name = request.query.name;
    var job = request.query.job;
    response.type('text/html');
    response.send('<h1>' + name + ','+ job+'</h1>');

});*/
app.use(function(request,response){
    response.type('text/html');
    response.sendStatus(404)
});
app.use(function(err,request,response,next){
    console(err);
    response.type('text/html');
    response.sendStatus(500);

});
app.listen(3000,function(){
    console.log('Server runing at http://localhost:3000');
});
