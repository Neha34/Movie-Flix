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
var SignupComponent = (function () {
    function SignupComponent(route, userService, router) {
        this.route = route;
        this.userService = userService;
        this.router = router;
        this.user = {};
    }
    SignupComponent.prototype.onSignup = function (first_name, last_name, user_name, email, password, confirm) {
        var _this = this;
        if (confirm == password) {
            this.user = {
                "emailId": email,
                "password": password,
                "userRole": "user",
                "firstName": first_name,
                "lastName": last_name,
                "userName": user_name
            };
            this.userService.createUser(this.user)
                .subscribe(function (user) {
                _this.user = user;
                _this.router.navigate(['/login']);
            }, function (error) { return console.log(error); });
        }
    };
    SignupComponent = __decorate([
        core_1.Component({
            templateUrl: 'sign-up.component.html'
        }), 
        __metadata('design:paramtypes', [router_1.ActivatedRoute, user_service_1.UserService, router_1.Router])
    ], SignupComponent);
    return SignupComponent;
}());
exports.SignupComponent = SignupComponent;
//# sourceMappingURL=sign-up.component.js.map