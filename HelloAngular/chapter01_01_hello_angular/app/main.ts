/**
 * Created by Admin on 2017-05-12.
 */
import {Component,NgModule} from '@angular/core'; //@angular/core/bundles 아래 모든것을 가져옴
import {BrowserModule} from '@angular/platform-browser';
import {platformBrowserDynamic} from '@angular/platform-browser-dynamic'; /*app브라우저에 보여주기 위한 모듈*/

/*컴포넌트 만들기( 컴포넌트 decoratiotor 와 class가 있어야함 (html,css,javascipt)*/
@Component({  //컴포넌트 decoratiotor
    selector: 'my-app',
    template : `<h1>Hello Angular</h1>
                <sub-component></sub-component>`
})
class AppComponent {

}
@Component({
    selector:"sub-component",
    template:'<h3>Hello Component</h3>'
})
class AppComponent2{

}

/*모듈: 컴포넌트의 집합*/
@NgModule({
    declarations:[AppComponent,AppComponent2],
    imports:[BrowserModule],
    bootstrap:[AppComponent]  /*젤먼저 보여줄 component를 보여줌*/
})
class AppModule{
}
platformBrowserDynamic().bootstrapModule(AppModule);