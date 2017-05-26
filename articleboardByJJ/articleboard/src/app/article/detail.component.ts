/**
 * Created by Admin on 2017-05-17.
 */
import { Component } from '@angular/core';
import {ArticleService} from "./article.service";
import {Article} from "./article";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector : 'detail',
  templateUrl : '../article/detail.component.html'
})

export class DetailComponent {

  article : Article = {
    _id:"",
    subject:"",
    writer:"",
    content : "",
    readCount : 0,
    originalname: "",
  filename : ""
  }

  //ActivatedRoute 파라미터를 받아오기.
  constructor(private route :ActivatedRoute, private articleService :ArticleService,private router:Router) { }
  deleteOneArticle(id:string) {
    this.articleService.deleteOneArticle(id).subscribe(response => {
      if ( response ){
        this.router.navigate(['']);
      }
    })
  }

  // 컴포넌트가 초기화 되었을 때 html을 먼저 수행시킨다.
  ngOnInit(){
    this.route.params.subscribe(params => {
      let id = params['id'];
      this.articleService.getOneArticle(id).subscribe(article => this.article = article);
    });
  }
}
