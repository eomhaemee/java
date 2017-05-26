//function명 뒤에 return타입을 명시 =>:type 
function getAddResult(): number{
    return 10 + 50;
};
//arg도 type을 명시할수 있음
function getAddResultTwoNumber(one: number,two: number): number{
    return one  + two;
};
let result:number = getAddResult();
let result2:number = getAddResultTwoNumber(10,50);
console.log(result);