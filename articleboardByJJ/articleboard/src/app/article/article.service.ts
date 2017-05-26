
import {Injectable} from '@angular/core';
import {Http, Headers} from '@angular/http';
import {Article} from './article';
import 'rxjs/add/operator/map';
import {Observable} from "rxjs/Observable";


@Injectable()
export class ArticleService {
  //생성자에다가 private를 붙이면 멤버변수로 역할을 하게된다.
  constructor(private http:Http) {}

  getAllArticles () : Observable<Article[]>{
    return this.http.get("http://localhost:3000/articles")
      .map(response => <Article[]> response.json());
  }
  getOneArticle(id : string) : Observable<Article> {
    return this.http.get("http://localhost:3000/article/"+id)
      .map(response => <Article> response.json());
  }
  insertNewArticle(newArticle : Article) : Observable<boolean> {
    const header = new Headers();
    header.append("Content-Type","application/x-www-form-urlencoded");

    return this.http.post("http://localhost:3000/article",
      `subject=${newArticle.subject}&content=${newArticle.content}&writer=${newArticle.writer}
      &originalname=${newArticle.originalname}&filename=${newArticle.filename}`,
      {headers : header}).map(response => <boolean> response.json().result);
  }
  deleteOneArticle(id : string) : Observable<boolean> {
    return this.http.delete("http://localhost:3000/article/" + id).map(response => <boolean> response.json().result);
  }
  updateOneArticle(id: string, updateArticle : Article) : Observable<boolean> {
    const header = new Headers();
    header.append("Content-Type","application/x-www-form-urlencoded");

    return this.http.put("http://localhost:3000/article/" + id,
      `subject=${updateArticle.subject}&content=${updateArticle.content}&writer=${updateArticle.writer}`,{headers:header})
      .map(response => <boolean> response.json().result);
  }
}
