/**
 * Created by Admin on 2017-05-18.
 */

// 현재 떠있는 서버에서 라우터 모델만 가져와서 라우팅을 할수 있게 만든다.
const route = require('express').Router();

// MongoDB 연결
require('../mongo/mongodb');
// Model(VO) 가져오기
const Article = require('../model/article');
// upload를 하기위해 가져오기
const upload = require('../util/upload');

// 파일만 처리
route.post("/upload",upload.single('file'),function (request,response) {

  response.type('application/json');
  response.send({
    result : true,
    originalname : request.file.originalname,
    filename : request.file.filename
  });

});

route.post("/",function (request,response) {

  // INSERT INTO
  let newArticle = new Article({
    subject : request.body.subject,
    content : request.body.content,
    writer : request.body.writer,
    readCount : 0,
    originalname : request.body.originalname,
    filename :  request.body.filename
  });

    newArticle.save();

    response.type('application/json');
    response.send({
      result : true
    });

});
route.delete("/:id",function(request,response){

  let id = request.params.id;
  // DELETE FROM ARTICLE WHERE ID = ?
  Article.findByIdAndRemove(id,function (err,result) {
    console.log(result);
    response.type("application/json");
    response.send({
      result : true
    });
  });


});
route.put("/:id",function (request,response) {

  let id = request.params.id;

  Article.findById(id,function (err,oneArticle) {
    oneArticle.subject = request.body.subject;
    oneArticle.content = request.body.content;
    oneArticle.writer = request.body.writer;

    oneArticle.save();

    response.type("application/json");
    response.send({
      result: true
    });

  });

});

route.get("/:id",function (request,response) {

  let id = request.params.id;

  //SELECT * FROM ARTICLE WHERE ID = ? pk가지고 찾음
  Article.findById(id,function (err,oneArticle) {
    response.type("application/json");
    response.send(oneArticle);
  });

});

// 우리가 만든 라우터를 바깥으로 보내준다.
exports.router = route;
