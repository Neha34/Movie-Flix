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
var UserService = (function () {
    function UserService(http) {
        this.http = http;
    }
    UserService.prototype.createUser = function (user) {
        var headers = new http_1.Headers({ 'Content-Type': 'application/json' });
        var options = new http_1.RequestOptions({ headers: headers });
        return this.http.post('http://localhost:8080/flix/api/users', user, options)
            .map(function (response) { return response.json(); })
            .catch(function (error) { return Observable_1.Observable.throw(error.statusText); });
    };
    UserService.prototype.getUser = function (email, password) {
        return this.http.get("http://localhost:8080/flix/api/users/" + email + "/" + password)
            .map(function (response) { return response.json(); })
            .catch(function (error) { return Observable_1.Observable.throw(error.statusText); });
    };
    UserService.prototype.isAdmin = function () {
        var cookieValue = this.getCookie();
        if (cookieValue === undefined) {
            return "no";
        }
        else {
            var myRes = atob(cookieValue).split('??');
            if (atob(myRes[0]) == 'admin' && atob(myRes[1]) == 'admin')
                return atob(myRes[0]);
        }
        return "no";
    };
    UserService.prototype.getCookie = function () {
        var x = document.cookie.split(';');
        var i = 0;
        var cookieValue = "";
        for (; i < x.length; i++) {
            if (x[i].split('=')[0].trim() == 'sessionID') {
                cookieValue = x[i].split('=')[1];
                break;
            }
        }
        return cookieValue;
    };
    UserService = __decorate([
        core_1.Injectable(), 
        __metadata('design:paramtypes', [http_1.Http])
    ], UserService);
    return UserService;
}());
exports.UserService = UserService;
//# sourceMappingURL=user.service.js.map