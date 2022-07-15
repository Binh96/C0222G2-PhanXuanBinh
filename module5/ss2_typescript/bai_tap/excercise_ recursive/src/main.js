function fibonacci(i) {
    if (i == 1 || i == 2) {
        return 1;
    }
    return fibonacci(i - 1) + fibonacci(i - 2);
}
var n = 10;
var sum = 0;
for (var i = 1; i < n; i++) {
    console.log(fibonacci(i));
    sum += fibonacci(i);
}
console.log("T\u1ED5ng: ".concat(sum));
