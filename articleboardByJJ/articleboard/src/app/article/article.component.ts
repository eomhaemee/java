import { Component } from '@angular/core'
import {Article} from "./article";
import {ArticleService} from "./article.service";


@Component({
  selector : 'article-list',
  templateUrl : '../article/article.component.html'
})
export class ArticleComponent{

  articles: Article[];

  constructor(private articleService:ArticleService) { }

  ngOnInit(){
    // articles라는 응답이 오면 이안에 있는(this) articles에 응답받은 articles를 넣어준다
    this.articleService.getAllArticles().subscribe(articles => this.articles = articles);
  }
}
