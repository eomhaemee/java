//export : java 의 public, 생략하면 private으로 생성
export class Car{
    //멤버변수
    private tiresCount : number;
    private handleType : string;
    /**
     * 생성자
     */
    constructor(){
        
    }
    //getter,setter
    getTiresCount(): number{
        return this.tiresCount;
    }
    getHandleType(): string{
        return this.handleType;
    }
    setTiresCount(tiresCount : number) : void{
        this.tiresCount =tiresCount;
    }
    setHandleType(handleType: string) : void{
        this.handleType = handleType;
    }
}

const car: Car = new Car();
car.setHandleType("good Handle");
car.setTiresCount(4);

console.log(car.getHandleType());
console.log(car.getTiresCount());