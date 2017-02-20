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
var AddTitleComponent = (function () {
    function AddTitleComponent(route, videoService, router, userService) {
        this.route = route;
        this.videoService = videoService;
        this.router = router;
        this.userService = userService;
        this.video = {};
        this.success = false;
        this.username = "";
        this.radio_val = "";
        if (userService.isAdmin() == "no") {
            this.router.navigate(['/login']);
        }
        else {
            this.username = userService.isAdmin();
        }
    }
    AddTitleComponent.prototype.clickRadio = function (element) {
        this.radio_val = element.value;
    };
    AddTitleComponent.prototype.createRange = function (num) {
        var items = [];
        for (var i = 1940; i <= num; i++) {
            items.push(i);
        }
        return items;
    };
    AddTitleComponent.prototype.addVideo = function (inputTitle, year, rated, inputReleased, inputRuntime, inputGenre, inputDirector, inputWriter, inputActor, inputPlot, language, country, inputAward, image, inputMetascore, inputRating, inputVotes, inputId) {
        var _this = this;
        this.video = {
            "title": inputTitle,
            "year": year,
            "rated": rated,
            "released": inputReleased,
            "runtime": inputRuntime,
            "genre": inputGenre,
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
            "type": this.radio_val
        };
        this.videoService.createVideo(this.video)
            .subscribe(function (video) {
            _this.video = video;
            _this.success = true;
        }, function (error) { return console.log(error); });
    };
    AddTitleComponent = __decorate([
        core_1.Component({
            templateUrl: 'add-title.component.html'
        }), 
        __metadata('design:paramtypes', [router_1.ActivatedRoute, video_service_1.VideoService, router_1.Router, user_service_1.UserService])
    ], AddTitleComponent);
    return AddTitleComponent;
}());
exports.AddTitleComponent = AddTitleComponent;
//# sourceMappingURL=add-title.component.js.map