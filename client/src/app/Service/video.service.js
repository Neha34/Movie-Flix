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
var http_1 = require('@angular/http');
var Observable_1 = require('rxjs/Observable');
require('rxjs/add/operator/catch');
require('rxjs/add/operator/map');
require('rxjs/add/observable/throw');
var VideoService = (function () {
    function VideoService(http) {
        this.http = http;
    }
    VideoService.prototype.createVideo = function (video) {
        var headers = new http_1.Headers({ 'Content-Type': 'application/json' });
        var options = new http_1.RequestOptions({ headers: headers });
        return this.http.post('http://localhost:8080/movieflix/api/videos', video, options)
            .map(function (response) { return response.json(); })
            .catch(function (error) { return Observable_1.Observable.throw(error.statusText); });
    };
    VideoService.prototype.getVideos = function () {
        return this.http.get('http://localhost:8080/flix/api/vedios')
            .map(function (response) { return response.json(); })
            .catch(function (error) { return Observable_1.Observable.throw(error.statusText); });
    };
    VideoService.prototype.getMovies = function () {
        return this.http.get('http://localhost:8080/flix/api/vedios/type=movie/year=0/genre=null/sort=year')
            .map(function (response) { return response.json(); })
            .catch(function (error) { return Observable_1.Observable.throw(error.statusText); });
    };
    VideoService.prototype.getSeries = function () {
        return this.http.get('http://localhost:8080/flix/api/vedios/type=series/year=0/genre=null/sort=year')
            .map(function (response) { return response.json(); })
            .catch(function (error) { return Observable_1.Observable.throw(error.statusText); });
    };
    VideoService.prototype.getTopMovies = function () {
        return this.http.get('http://localhost:8080/flix/api/vedios/top=movie')
            .map(function (response) { return response.json(); })
            .catch(function (error) { return Observable_1.Observable.throw(error.statusText); });
    };
    VideoService.prototype.getTopSeries = function () {
        return this.http.get('http://localhost:8080/flix/api/vedios/top=series')
            .map(function (response) { return response.json(); })
            .catch(function (error) { return Observable_1.Observable.throw(error.statusText); });
    };
    VideoService.prototype.getVideoById = function (videoId) {
        return this.http.get("http://localhost:8080/flix/api/vedios/" + videoId)
            .map(function (response) { return response.json(); })
            .catch(function (error) { return Observable_1.Observable.throw(error.statusText); });
    };
    VideoService.prototype.getCommentsById = function (videoId) {
        return this.http.get("http://localhost:8080/flix/api/comments/" + videoId)
            .map(function (response) { return response.json(); })
            .catch(function (error) { return Observable_1.Observable.throw(error.statusText); });
    };
    VideoService.prototype.getRatingById = function (videoId) {
        return this.http.get("http://localhost:8080/flix/api/ratings/" + videoId + "/rating={rate}")
            .map(function (response) { return response.json(); })
            .catch(function (error) { return Observable_1.Observable.throw(error.statusText); });
    };
    VideoService.prototype.getSearchTitle = function (title) {
        return this.http.get("http://localhost:8080/flix/api/vedios/search=" + title)
            .map(function (response) { return response.json(); })
            .catch(function (error) { return Observable_1.Observable.throw(error.statusText); });
    };
    VideoService.prototype.getByFilter = function (type, year, genre, sort) {
        return this.http.get("http://localhost:8080/flix/api/vedios/type=" + type + "/year=" + year + "/genre=" + genre + "/sort=" + sort)
            .map(function (response) { return response.json(); })
            .catch(function (error) { return Observable_1.Observable.throw(error.statusText); });
    };
    VideoService.prototype.deleteTitle = function (title) {
        return this.http.delete("http://localhost:8080/flix/api/vedios/" + title)
            .map(function (response) { return response.json(); })
            .catch(function (error) { return Observable_1.Observable.throw(error.statusText); });
    };
    VideoService.prototype.getVideoByTitle = function (title) {
        return this.http.get("http://localhost:8080/flix/api/vedios/" + title)
            .map(function (response) { return response.json(); })
            .catch(function (error) { return Observable_1.Observable.throw(error.statusText); });
    };
    VideoService.prototype.updateVideo = function (video, title) {
        var headers = new http_1.Headers({ 'Content-Type': 'application/json' });
        var options = new http_1.RequestOptions({ headers: headers });
        return this.http.put("http://localhost:8080/flix/api/vedios/" + title, video, options)
            .map(function (response) { return response.json(); })
            .catch(function (error) { return Observable_1.Observable.throw(error.statusText); });
    };
    VideoService.prototype.addComment = function (videoId, comment) {
        var headers = new http_1.Headers({ 'Content-Type': 'application/json' });
        var options = new http_1.RequestOptions({ headers: headers });
        return this.http.post("http://localhost:8080/flix/api/comments/" + videoId + "/comment=" + comment, options)
            .map(function (response) { return response.json(); })
            .catch(function (error) { return Observable_1.Observable.throw(error.statusText); });
    };
    VideoService.prototype.rate = function (videoId, star) {
        var headers = new http_1.Headers({ 'Content-Type': 'application/json' });
        var options = new http_1.RequestOptions({ headers: headers });
        return this.http.post("http://localhost:8080/flix/api/ratings/" + videoId + "/rating=" + star, options)
            .map(function (response) { return response.json(); })
            .catch(function (error) { return Observable_1.Observable.throw(error.statusText); });
    };
    VideoService = __decorate([
        core_1.Injectable(), 
        __metadata('design:paramtypes', [http_1.Http])
    ], VideoService);
    return VideoService;
}());
exports.VideoService = VideoService;
//# sourceMappingURL=video.service.js.map