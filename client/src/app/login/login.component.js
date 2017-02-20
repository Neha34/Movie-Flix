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
var LoginComponent = (function () {
    function LoginComponent(route, userService, router) {
        this.route = route;
        this.userService = userService;
        this.router = router;
        this.user = {};
        this.invalid = false;
    }
    LoginComponent.prototype.login = function (email, password) {
        var _this = this;
        var key = btoa(btoa(email) + '??' + btoa(password));
        document.cookie = "sessionID=" + key + ';';
        this.userService.getUser(email, password)
            .subscribe(function (user) {
            _this.user = user;
            if (email == "admin" && password == "admin")
                _this.router.navigate(['/add_title']);
            else if (_this.user == true)
                _this.router.navigate(['/video_list']);
            else
                _this.invalid = true;
        }, function (error) { return console.log(error); });
    };
    LoginComponent = __decorate([
        core_1.Component({
            templateUrl: 'login.component.html'
        }), 
        __metadata('design:paramtypes', [router_1.ActivatedRoute, user_service_1.UserService, router_1.Router])
    ], LoginComponent);
    return LoginComponent;
}());
exports.LoginComponent = LoginComponent;
//# sourceMappingURL=login.component.js.map