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
var RemoveTitleComponent = (function () {
    function RemoveTitleComponent(route, videoService, router, userService) {
        this.route = route;
        this.videoService = videoService;
        this.router = router;
        this.userService = userService;
        this.videoList = [];
        this.video = [];
        this.username = "";
        if (userService.isAdmin() == "no") {
            this.router.navigate(['/login']);
        }
        else {
            this.username = userService.isAdmin();
            this.showAll();
        }
    }
    RemoveTitleComponent.prototype.showAll = function () {
        var _this = this;
        this.videoService.getVideos()
            .subscribe(function (videos) { return _this.videoList = videos; }, function (error) { return console.log(error); });
    };
    RemoveTitleComponent.prototype.delete = function (title) {
        var _this = this;
        if (confirm("Are you sure you want to delete the title - " + title + " ?") == true) {
            this.videoService.deleteTitle(title)
                .subscribe(function (videos) { return _this.videoList = videos; }, function (error) { return console.log(error); });
        }
    };
    RemoveTitleComponent.prototype.edit = function (title) {
        var _this = this;
        this.videoService.getVideoByTitle(title)
            .subscribe(function (video) {
            _this.video = video;
            _this.router.navigate(['/add_title'], video);
        }, function (error) { return console.log(error); });
    };
    RemoveTitleComponent = __decorate([
        core_1.Component({
            templateUrl: 'remove-title.component.html'
        }), 
        __metadata('design:paramtypes', [router_1.ActivatedRoute, video_service_1.VideoService, router_1.Router, user_service_1.UserService])
    ], RemoveTitleComponent);
    return RemoveTitleComponent;
}());
exports.RemoveTitleComponent = RemoveTitleComponent;
//# sourceMappingURL=remove-title.component.js.map