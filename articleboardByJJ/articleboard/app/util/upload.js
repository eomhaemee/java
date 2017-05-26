/**
 * Created by Admin on 2017-05-19.
 */
// 업로드를 하기위해 만든다.
const multer = require('multer');

const storage = multer.diskStorage({
  destination : function (request, file, cb) {
    cb(null,__dirname+'/../upload');
  },
  filename : function (request, file, cb) {
    let datetimestamp = Date.now();

    console.log('DateTimeStamp : ' + datetimestamp);

    let originalFileName = file.originalname; // 파일명 가지고오기
    console.log("OriginalFileName : " + originalFileName);
    console.log("File.fieldName :" + file.fieldname);

    originalFileName = originalFileName.split('.');
    let originalName = originalFileName[0];
    let extName = originalFileName[originalFileName.length-1];

    cb(null,originalName + '-' + datetimestamp + '.' +  extName);
  }

});

// multer에 storage라는 속성에 바로 위에서 만든 const storage를 넣어준다
const upload = multer({
  storage : storage
});

module.exports = upload;


