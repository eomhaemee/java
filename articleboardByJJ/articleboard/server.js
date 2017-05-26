const express = require('express');
const fs = require('fs');
const ejs = require('ejs');
const bodyParser = require('body-parser');

const app = express();

app.use('/download',express.static(__dirname+'/app/upload'));
app.use(bodyParser.urlencoded({extended:false}));

// form data를 받아오기 위해서 필요하다.
app.use(bodyParser.json());

// module.exports = route;
app.use(require('./app/routes/index'));


app.listen(3000,function () {
  console.log('Server running at http://localhost:3000');
});
