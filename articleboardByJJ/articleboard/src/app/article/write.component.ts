import {Component} from '@angular/core';
import {ArticleService} from "./article.service";
import {Router} from  '@angular/router'
import {FileUploader} from 'ng2-file-upload';

@Component({
  selector : 'write',
  templateUrl : '../article/write.component.html'
})

export class WriteComponent{

  uploader : FileUploader = new FileUploader({
    url : 'http://localhost:3000/article/upload'
  });

  fileInfo = {
    originalname : '',
    filename : ''
  };
  // redirect!
  // Router
  constructor(private articleService : ArticleService, private router:Router) {
    this.uploader.onCompleteItem= (item,response,status,header) => {
      this.fileInfo = JSON.parse(response);
    };
  }

  writeArticle(writeForm){

    writeForm.form.value.originalname = this.fileInfo.originalname;
    writeForm.form.value.filename = this.fileInfo.filename;

    this.articleService.insertNewArticle(writeForm.form.value).subscribe(response => {
      if( response ){
        // Response.SendRedirect("/");
        this.router.navigate(['']);
      }
    });

  }


}
