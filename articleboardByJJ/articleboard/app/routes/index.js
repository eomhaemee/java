/**
 * Created by Admin on 2017-05-18.
 */
const route = require('express').Router();

// MongoDB 연결
require('../mongo/mongodb');
// Model(VO) 가져오기 - 스키마를 만들어주면 자동으로 컬랙션이 생긴다(MongoDB에서 직접 생성하지 않아도 된다.)
const Article = require('../model/article');

route.use(function (req, res, next) {
  // 여기에 접속할수 있는것은 angular : localhost:4200 뿐이다
  res.setHeader('Access-Control-Allow-Origin', 'http://localhost:4200');
  res.setHeader('Access-Control-Allow-Methods', 'GET, POST, OPTIONS, PUT, PATCH, DELETE');
  res.setHeader('Access-Control-Allow-Headers', 'X-Requested-With,content-type');
  res.setHeader('Access-Control-Allow-Credentials', 'true');
  next();
});

route.get("/articles",function (request,response) {
  /*
   SELECT * FROM ARTICLES // 오라클
   */
  Article.find( {},function (err,article) {
    response.type('application/json'); // json타입으로 return 시켜라
    response.send(article);
  });
});
// 추가되는 url이 필요할때 exports.router = route;
route.use("/article",require('./article').router);
route.use("/user",require('./user').router);
module.exports = route;
