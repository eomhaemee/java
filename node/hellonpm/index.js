
const express = require('express');
const fs = require('fs');
const ejs = require('ejs');
const bodyParser = require('body-parser');
const path = require('path');
// 서버를 생성함
const app = express();


app.use(express.static(__dirname+'/static'));

app.use('/node_modules',express.static(path.join(__dirname,'node_modules')));

app.use(bodyParser.urlencoded({extended: false}));

let index = 0 ;

//items.push()로 data넣음
//객체 리터럴 만들어 입력
//const item= {}; // 객체 리터럴 생성하여 
//item.subject = "주제"; // data입력
const items = [
    {subject: 'Min Chang Jang', memo: '강사' , id : index++},
    {subject: 'Gil Dong Hong', memo: '수강생', id : index++}
];

app.get('/', function(request, response) {
    fs.readFile('welcome.ejs','utf8', function(err, data) {
        response.writeHead(200, {'Content-Type': 'text/html'});
        response.end(ejs.render(data,{
            items : items
        }));
        //response.send(data);
    });
});

app.get('/new', function(request, response) {
        fs.readFile('add.ejs', function(err, data) {
        response.type('text/html');
        response.send(data);
    });
});
//insert
app.post('/new', function(request, response) {
    fs.readFile('add.ejs','utf8', function(err, data) {

        let subject = request.body.subject;
        let memo = request.body.memo;

        const item= {}; // 객체 리터럴 생성하여
        item.subject = subject; // data입력
        item.memo = memo;
        item.id = index++;
        items.push(item);

        console.log(items);
        response.redirect('/');

    });
});
//detail
app.get('/memo/:id', function(request, response) {
    let id = request.params.id;

    console.log('디테일 id: ' + id);
    console.log('memo: ' + items[id].memo );
    console.log('subject: '+ items[id].subject);
    console.log('=============');

    fs.readFile('welcome.ejs','utf8', function(err, data) {
        response.writeHead(200, {'Content-Type': 'text/html'});
        response.end(ejs.render(data,{
            items : items,
            item : items[id]
        }));
    });
});

//delete
app.delete('/memo/:id', function(request, response) {
    let id = request.params.id;
//    배열.splice(인덱스,1); 인덱스의 삭제할 요소
    items.splice(id,1);
    remakeItems(id);
    //응답을 주고 어디로 갈지는 client에서 처리
    response.send(true);

    //response.redirect('/');

});

//update
app.post('/memo/update/:id', function(request, response) {
    let id = request.params.id;
    let subject = request.body.subject;
    let memo = request.body.memo;

    items[id].subject=subject;
    items[id].memo=memo;

    console.log('update id: ' + id);
    console.log('subject: ' + subject );
    console.log('memo: '+ memo);
    response.redirect('/');

});


// 404 Page
app.use(function(request, response) {
    response.type('text/html');
    response.sendStatus(404);
});

app.listen(3000, function() {
    console.log('Server running at http://localhost:3000')
});


function remakeItems(removeIndex) {
    for(let i in items){
        if( i >= removeIndex ) {
            items[i].id--;
        }
    }
    index--;
}