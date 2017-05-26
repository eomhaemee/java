"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
//export : java 의 public, 생략하면 private으로 생성
var Car = (function () {
    /**
     * 생성자
     */
    function Car() {
    }
    //getter,setter
    Car.prototype.getTiresCount = function () {
        return this.tiresCount;
    };
    Car.prototype.getHandleType = function () {
        return this.handleType;
    };
    Car.prototype.setTiresCount = function (tiresCount) {
        this.tiresCount = tiresCount;
    };
    Car.prototype.setHandleType = function (handleType) {
        this.handleType = handleType;
    };
    return Car;
}());
exports.Car = Car;
var car = new Car();
car.setHandleType("good Handle");
car.setTiresCount(4);
console.log(car.getHandleType());
console.log(car.getTiresCount());
