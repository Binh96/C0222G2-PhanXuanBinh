function fibonacci(i: number): number{
    if(i==1 || i==2){
        return 1;
    }
    return fibonacci(i-1)+fibonacci(i-2);
}

let n: number = 10;
let sum =0;

for(let i= 1; i< n; i++){
    console.log(fibonacci(i));
    sum+=fibonacci(i);
}

console.log(`Tổng: ${sum}`);