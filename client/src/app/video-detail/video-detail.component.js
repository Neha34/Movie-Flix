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
var video_service_1 = require('../Service/video.service');
var user_service_1 = require("../Service/user.service");
var VideoDetailComponent = (function () {
    function VideoDetailComponent(route, videoService, userService, router) {
        var _this = this;
        this.route = route;
        this.videoService = videoService;
        this.userService = userService;
        this.router = router;
        this.videoList = [];
        this.video = {};
        this.commentList = [];
        this.rating = {};
        this.comment = "";
        this.userId = [];
        this.user = {};
        this.username = "";
        this.showUser = false;
        this.showAdmin = false;
        var cookieValue = this.userService.getCookie();
        if (cookieValue === undefined)
            this.router.navigate(['/login']);
        else {
            var myRes = atob(cookieValue).split('??');
            if (atob(myRes[0]) == "admin")
                this.showAdmin = true;
            else
                this.showUser = true;
            this.userService.getUser(atob(myRes[0]), atob(myRes[1]))
                .subscribe(function (user) {
                _this.user = user;
                if (_this.user == true)
                    _this.username = atob(myRes[0]);
                else
                    _this.router.navigate(['/login']);
            }, function (error) { return console.log(error); });
        }
    }
    VideoDetailComponent.prototype.ngOnInit = function () {
        var _this = this;
        this.route.params.subscribe(function (params) {
            _this.videoService.getVideoById(params['movieId'])
                .subscribe(function (video) { return _this.video = video; }, function (error) { return console.log(error); });
            _this.videoService.getCommentsById(params['movieId'])
                .subscribe(function (comments) { return _this.commentList = comments; }, function (error) { return console.log(error); });
            _this.videoService.getRatingById(params['movieId'])
                .subscribe(function (rating) { return _this.rating = rating; }, function (error) { return console.log(error); });
        });
    };
    VideoDetailComponent.prototype.addComment = function (comment_str, movieId) {
        this.videoService.addComment(movieId, comment_str)
            .subscribe(function (error) { return console.log(error); });
    };
    VideoDetailComponent.prototype.rate = function (star, movieId) {
        this.videoService.rate(movieId, star)
            .subscribe(function (error) { return console.log(error); });
    };
    VideoDetailComponent = __decorate([
        core_1.Component({
            templateUrl: 'video-detail.component.html'
        }), 
        __metadata('design:paramtypes', [router_1.ActivatedRoute, video_service_1.VideoService, user_service_1.UserService, router_1.Router])
    ], VideoDetailComponent);
    return VideoDetailComponent;
}());
exports.VideoDetailComponent = VideoDetailComponent;
//# sourceMappingURL=video-detail.component.js.map