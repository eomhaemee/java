var number = 10;
var string = "10";
var bool = true;
//let변수 
// 선언방법  1) type명시 - let 변수명: type= 값;  
//          2) type을 명시 하지 않으면- 최초 설정된 값에 따라 변수의 type이 설정
//          3) 여러가지 type을 | 로 연결하여 선언가능
var nameStr = "";
nameStr = 0;
nameStr = true;
//          4) any 로 선언하면 어떤 type이든 가능
var age = "";
age = 10;
age = true;
age = function () { };
//1. var 와 다르게 동일한 이름으로 재선언금지
//let bool = 30;
//2. var 는 function scope이지만 let은 {} scope
var numberTwo = 30;
if (true) {
    var numberTwo_1 = 50;
}
console.log(numberTwo);
console.log(number);
console.log(string);
console.log(bool);
