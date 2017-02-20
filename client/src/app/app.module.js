"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};
var core_1 = require('@angular/core');
var forms_1 = require('@angular/forms');
var http_1 = require('@angular/http');
var router_1 = require('@angular/router');
var platform_browser_1 = require('@angular/platform-browser');
var app_component_1 = require('./app.component');
var home_component_1 = require('./home/home.component');
var sign_up_component_1 = require('./sign-up/sign-up.component');
var login_component_1 = require('./login/login.component');
var contact_component_1 = require('./contact/contact.component');
var not_found_component_1 = require('./not-found/not-found.component');
var video_list_component_1 = require('./video-list/video-list.component');
var add_title_component_1 = require('./movie/add-title.component');
var remove_title_component_1 = require('./movie/remove-title.component');
var video_detail_component_1 = require('./video-detail/video-detail.component');
var user_service_1 = require('./Service/user.service');
var video_service_1 = require("./Service/video.service");
var edit_title_component_1 = require("./movie/edit-title.component");
var appRoutes = [
    { path: 'home', component: home_component_1.HomeComponent },
    { path: 'signup', component: sign_up_component_1.SignupComponent },
    { path: 'login', component: login_component_1.LoginComponent },
    { path: 'contact', component: contact_component_1.ContactComponent },
    { path: 'add_title', component: add_title_component_1.AddTitleComponent },
    { path: 'edit_title', component: remove_title_component_1.RemoveTitleComponent },
    { path: 'edit_title/:videoId', component: edit_title_component_1.EditTitleComponent },
    { path: 'video_list', component: video_list_component_1.VideoListComponent },
    { path: 'video_list/:movieId', component: video_detail_component_1.VideoDetailComponent },
    { path: '', redirectTo: 'home', pathMatch: 'full' },
    { path: '**', component: not_found_component_1.NotFoundComponent }
];
var AppModule = (function () {
    function AppModule() {
    }
    AppModule = __decorate([
        core_1.NgModule({
            imports: [platform_browser_1.BrowserModule, forms_1.FormsModule, http_1.HttpModule, router_1.RouterModule.forRoot(appRoutes)],
            declarations: [app_component_1.AppComponent, not_found_component_1.NotFoundComponent, home_component_1.HomeComponent, sign_up_component_1.SignupComponent, login_component_1.LoginComponent, contact_component_1.ContactComponent,
                add_title_component_1.AddTitleComponent, remove_title_component_1.RemoveTitleComponent, video_list_component_1.VideoListComponent, video_detail_component_1.VideoDetailComponent, edit_title_component_1.EditTitleComponent],
            providers: [user_service_1.UserService, video_service_1.VideoService],
            bootstrap: [app_component_1.AppComponent]
        }), 
        __metadata('design:paramtypes', [])
    ], AppModule);
    return AppModule;
}());
exports.AppModule = AppModule;
//# sourceMappingURL=app.module.js.map