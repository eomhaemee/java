const route = require('express').Router();

require('../mongo/mongodb');
const User = require('../model/user');

route.post("/signup",function (request,response) {
  let id = request.body.id;
  let password = request.body.password;
  let name = request.body.name;

  const user = new User({
    id : id,
    password : password,
    name : name
  }); // 스키마 형태와 똑같이 만들어줘야 한다.

  user.save();
  response.type('application/json');
  response.send({
    result : true
  });

});
route.post("/signin",function (request,response) {

  let id = request.body.id;
  let password = request.body.password;

  // SELECT * WHERE ID = ? 조건으로 찾음
  User.findOne({id : id, password : password }, function (err,user) {
    response.type('application/json');
    if( err ){
      response.send({
        error : err
      });
    }
    else {
      if ( id == user.id && password == user.password ) {
        response.send({
          result : true,
          user : user
        });
      }
      else {
        response.send({
          result : false
        });
      }
    }

  });
});
exports.router = route;
