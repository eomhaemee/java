/**
 * Created by Admin on 2017-05-17.
 */

import {Component} from '@angular/core';
import {ArticleService} from '../article/article.service';
import {ActivatedRoute, Router} from "@angular/router";
import {Article} from "./article";


@Component({
  selector : 'update',
  templateUrl : './update.component.html'
})

export class UpdateComponent{

  article : Article = {
    _id:"",
    subject:"",
    writer:"",
    content : "",
    readCount : 0,
    originalname: "",
   filename : ""
  }
  constructor(private articleService : ArticleService, private route:ActivatedRoute, private router:Router){}
  updateArticle(updateForm){
    let id = updateForm.form.value._id;
    console.log(id);
    this.articleService.updateOneArticle(id,updateForm.form.value).subscribe(response=>{
      if(response){
        this.router.navigate(['']);
      }
    })

  }
  ngOnInit(){
    this.route.params.subscribe(params=>{
      let id = params['id'];
      this.articleService.getOneArticle(id).subscribe(article=> this.article=article);

    })
  }
}
