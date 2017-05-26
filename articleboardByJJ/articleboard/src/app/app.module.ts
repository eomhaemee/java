import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';

import { AppComponent } from './app.component';
import {ArticleComponent} from "./article/article.component";
import {AppRoutingModule} from "./app.routes";
import {ArticleService} from "./article/article.service";
import {DetailComponent} from "./article/detail.component";
import {WriteComponent} from './article/write.component'
import {UpdateComponent} from "./article/update.component";
import {UserService} from "./user/user.service";
import {SignupComponent} from "./user/signup.component";
import {SigninComponent} from "./user/signin.component";
import { FileSelectDirective, FileDropDirective } from 'ng2-file-upload';

@NgModule({
  declarations: [
    AppComponent,
    ArticleComponent,
    DetailComponent,
    WriteComponent,
    UpdateComponent,
    SignupComponent,
    SigninComponent,
    FileSelectDirective
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    AppRoutingModule
  ],
  providers: [ArticleService,UserService],
  bootstrap: [AppComponent]
})
export class AppModule { }
