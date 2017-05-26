"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
Object.defineProperty(exports, "__esModule", { value: true });
/**
 * Created by Admin on 2017-05-12.
 */
var core_1 = require("@angular/core"); //@angular/core/bundles 아래 모든것을 가져옴
var platform_browser_1 = require("@angular/platform-browser");
var platform_browser_dynamic_1 = require("@angular/platform-browser-dynamic"); /*app브라우저에 보여주기 위한 모듈*/
/*컴포넌트 만들기( 컴포넌트 decoratiotor 와 class가 있어야함 (html,css,javascipt)*/
var AppComponent = (function () {
    function AppComponent() {
    }
    return AppComponent;
}());
AppComponent = __decorate([
    core_1.Component({
        selector: 'my-app',
        template: "<h1>Hello Angular</h1>\n                <sub-component></sub-component>"
    })
], AppComponent);
var AppComponent2 = (function () {
    function AppComponent2() {
    }
    return AppComponent2;
}());
AppComponent2 = __decorate([
    core_1.Component({
        selector: "sub-component",
        template: '<h3>Hello Component</h3>'
    })
], AppComponent2);
/*모듈: 컴포넌트의 집합*/
var AppModule = (function () {
    function AppModule() {
    }
    return AppModule;
}());
AppModule = __decorate([
    core_1.NgModule({
        declarations: [AppComponent, AppComponent2],
        imports: [platform_browser_1.BrowserModule],
        bootstrap: [AppComponent] /*젤먼저 보여줄 component를 보여줌*/
    })
], AppModule);
platform_browser_dynamic_1.platformBrowserDynamic().bootstrapModule(AppModule);
//# sourceMappingURL=main.js.map