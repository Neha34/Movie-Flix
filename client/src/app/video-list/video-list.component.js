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
var router_1 = require('@angular/router');
var user_service_1 = require('../Service/user.service');
var video_service_1 = require('../Service/video.service');
var VideoListComponent = (function () {
    function VideoListComponent(videoService, userService, router) {
        var _this = this;
        this.videoService = videoService;
        this.userService = userService;
        this.router = router;
        this.videoList = [];
        this.user = {};
        this.username = "";
        this.rating = {};
        var cookieValue = this.userService.getCookie();
        if (cookieValue === undefined) {
            this.router.navigate(['/login']);
        }
        else {
            var myRes = atob(cookieValue).split('??');
            this.userService.getUser(atob(myRes[0]), atob(myRes[1]))
                .subscribe(function (user) {
                _this.user = user;
                if (_this.user == true) {
                    _this.username = atob(myRes[0]);
                    _this.showAll();
                }
                else {
                    _this.router.navigate(['/login']);
                }
            }, function (error) { return console.log(error); });
        }
    }
    VideoListComponent.prototype.createRange = function (num) {
        var items = [];
        for (var i = 1940; i <= num; i++) {
            items.push(i);
        }
        return items;
    };
    VideoListComponent.prototype.showAll = function () {
        var _this = this;
        this.videoService.getVideos()
            .subscribe(function (videos) { return _this.videoList = videos; }, function (error) { return console.log(error); });
    };
    VideoListComponent.prototype.showMovies = function () {
        var _this = this;
        this.videoService.getMovies()
            .subscribe(function (videos) { return _this.videoList = videos; }, function (error) { return console.log(error); });
    };
    VideoListComponent.prototype.showSeries = function () {
        var _this = this;
        this.videoService.getSeries()
            .subscribe(function (videos) { return _this.videoList = videos; }, function (error) { return console.log(error); });
    };
    VideoListComponent.prototype.showTopMovies = function () {
        var _this = this;
        this.videoService.getTopMovies()
            .subscribe(function (videos) { return _this.videoList = videos; }, function (error) { return console.log(error); });
    };
    VideoListComponent.prototype.showTopSeries = function () {
        var _this = this;
        this.videoService.getTopSeries()
            .subscribe(function (videos) { return _this.videoList = videos; }, function (error) { return console.log(error); });
    };
    VideoListComponent.prototype.onSearch = function (searchtext) {
        var _this = this;
        this.videoService.getSearchTitle(searchtext)
            .subscribe(function (videos) { return _this.videoList = videos; }, function (error) { return console.log(error); });
    };
    VideoListComponent.prototype.onFilter = function (type, year, genre, sort) {
        var _this = this;
        this.videoService.getByFilter(type, year, genre, sort)
            .subscribe(function (videos) { return _this.videoList = videos; }, function (error) { return console.log(error); });
    };
    VideoListComponent = __decorate([
        core_1.Component({
            templateUrl: 'video-list.component.html'
        }), 
        __metadata('design:paramtypes', [video_service_1.VideoService, user_service_1.UserService, router_1.Router])
    ], VideoListComponent);
    return VideoListComponent;
}());
exports.VideoListComponent = VideoListComponent;
//# sourceMappingURL=video-list.component.js.map