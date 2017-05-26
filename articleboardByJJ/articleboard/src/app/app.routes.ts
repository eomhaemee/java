import { Routes, RouterModule } from '@angular/router';
import { ModuleWithProviders } from '@angular/core';
import { ArticleComponent } from './article/article.component'
import {DetailComponent} from "./article/detail.component";
import {WriteComponent} from'./article/write.component'
import {UpdateComponent} from "./article/update.component";
import {SignupComponent} from "./user/signup.component";
import {SigninComponent} from "./user/signin.component";

export const ROUTES : Routes = [
  {path: '', component: ArticleComponent},
  {path: 'article/:id', component: DetailComponent },
  {path: 'write', component: WriteComponent},
  {path : 'update/:id' , component: UpdateComponent},
  {path: 'user/signup', component: SignupComponent},
  {path: 'user/signin', component: SigninComponent}
];

export const AppRoutingModule : ModuleWithProviders = RouterModule.forRoot(ROUTES);
