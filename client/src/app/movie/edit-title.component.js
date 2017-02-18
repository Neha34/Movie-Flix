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
var EditTitleComponent = (function () {
    function EditTitleComponent(route, videoService, router, userService) {
        var _this = this;
        this.route = route;
        this.videoService = videoService;
        this.router = router;
        this.userService = userService;
        this.radio_val = "";
        this.video = {};
        this.success = false;
        this.username = "";
        if (userService.isAdmin() == "no") {
            this.router.navigate(['/login']);
        }
        else {
            this.username = userService.isAdmin();
            this.route.params.subscribe(function (params) {
                videoService.getVideoById(params['videoId'])
                    .subscribe(function (video) { return _this.video = video; }, function (error) { return console.log(error); });
            });
        }
    }
    EditTitleComponent.prototype.updateVideo = function (videoId, inputTitle, year, rated, inputReleased, inputRuntime, genre, inputDirector, inputWriter, inputActor, inputPlot, language, country, inputAward, image, inputMetascore, inputRating, inputVotes, inputId, rad_type) {
        var _this = this;
        this.video = {
            "videoId": videoId,
            "title": inputTitle,
            "year": year,
            "rated": rated,
            "released": inputReleased,
            "runtime": inputRuntime,
            "genre": genre,
            "director": inputDirector,
            "writer": inputWriter,
            "actors": inputActor,
            "plot": inputPlot,
            "language": language,
            "country": country,
            "awards": inputAward,
            "poster": image,
            "metaScore": inputMetascore,
            "imdbRating": inputRating,
            "imdbVotes": inputVotes,
            "imdbId": inputId,
            "type": rad_type
        };
        this.videoService.updateVideo(this.video, inputTitle)
            .subscribe(function (video) {
            _this.video = video;
            _this.success = true;
        }, function (error) { return console.log(error); });
    };
    EditTitleComponent.prototype.clickRadio = function (element) {
        this.radio_val = element.value;
    };
    EditTitleComponent.prototype.createRange = function (num) {
        var items = [];
        for (var i = 1940; i <= num; i++) {
            items.push(i);
        }
        return items;
    };
    EditTitleComponent = __decorate([
        core_1.Component({
            selector: 'editForm',
            templateUrl: 'edit-title.component.html'
        }), 
        __metadata('design:paramtypes', [router_1.ActivatedRoute, video_service_1.VideoService, router_1.Router, user_service_1.UserService])
    ], EditTitleComponent);
    return EditTitleComponent;
}());
exports.EditTitleComponent = EditTitleComponent;
//# sourceMappingURL=edit-title.component.js.map