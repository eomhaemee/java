//function명 뒤에 return타입을 명시 =>:type 
function getAddResult() {
    return 10 + 50;
}
;
//arg도 type을 명시할수 있음
function getAddResultTwoNumber(one, two) {
    return one + two;
}
;
var result1 = getAddResult();
var result2 = getAddResultTwoNumber(10, 50);
