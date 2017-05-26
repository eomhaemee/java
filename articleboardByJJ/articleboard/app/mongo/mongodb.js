/**
 * Created by Admin on 2017-05-18.
 */
const mongoose = require('mongoose');


module.exports = function () {

  function mongoDBConnection() {
    mongoose.connect('mongodb://192.168.99.100:32768/ARTICLE',function (err) {
      console.log("MongoDB 연결");
      if( err ){
        console.log(err);
      }
    });
  }
  function mongoDBDisconnectid() {
    mongoose.connection.on('disconnected',mongoDBConnection);
  }

  mongoDBConnection();
  mongoDBDisconnectid();
}();// function을 만들자마자 실행
