// Bài 9: Kiểm tra xem 3 số thực (a,b,c) nhập vào có phải là cạnh của một tam giác. 
// Điều kiện để a,b,c là cạnh của một tam giác

let a = parseFloat(prompt("Nhập cạnh a:"));
let b = parseFloat(prompt("Nhập cạnh b:"));
let c = parseFloat(prompt("Nhập cạnh c:"));

if(a > 0 && b > 0 && c > 0){
    if((a+b)>c && (b+c)>a &&(a+c>b)){
        alert("a, b, c là các cạnh của tam giác");
    }
    else {
        alert("a, b, c không phải là cạnh của tam giác");
    }
}

else {
    alert("a, b, c không phải là cạnh của tam giác");
}

// Bài 10: Viết chương trình tính giá điện.
let electricIndex = parseFloat(prompt("Nhập chỉ số điện: "));
let total = 0; 
if(electricIndex <= 100){
    total= electricIndex * 600;
    alert("Tiền điện phải trả: "+ " "+ total+"đ");
}
else if(electricIndex>100 && electricIndex < 300){
    total= electricIndex * 1000;
    alert("Tiền điện phải trả: "+ " "+ total+"đ");
}

else{
    total= electricIndex * 1200;
    alert("Tiền điện phải trả: "+ " "+ total+"đ");
}

// Bài 11: Viết chương trình tính thuế thu nhập cá nhân.
let personalSalary = parseFloat(prompt("Nhập số thu nhập cá nhân:"));
let tax;
// - Bậc 7: Thu nhập tính thuế trên 80 triệu đồng, thuế suất 35%.
if(personalSalary > 80000000){
    tax = personalSalary * (35/100);
    alert("Thuế thu nhập cá nhân phải nộp: " + " " + tax);
}
// - Bậc 6: Thu nhập tính thuế trên 52 triệu đồng đến 80 triệu đồng, thuế suất 30%.
else if(personalSalary > 52000000 && personalSalary <=80000000){
    tax = personalSalary * (30/100);
    alert("Thuế thu nhập cá nhân phải nộp: " + " " + tax);
}
// - Bậc 5: Thu nhập tính thuế trên 32 triệu đồng đến 52 triệu đồng, thuế suất 25%
else if(personalSalary >= 32000000 && personalSalary <= 52000000){
    tax = personalSalary * (25/100);
    alert("Thuế thu nhập cá nhân phải nộp: " + " " + tax);
}
// - Bậc 4: Thu nhập tính thuế trên 18 triệu đồng đến 32 triệu đồng, thuế suất 20%.
else if(personalSalary >=18000000 && personalSalary >=32000000){
    tax = personalSalary * (20/100);
    alert("Thuế thu nhập cá nhân phải nộp: " + " " + tax);
}
// - Bậc 3: Thu nhập tính thuế trên 10 triệu đồng đến 18 triệu đồng, thuế suất 15%.
else if(personalSalary >10000000 && personalSalary >=18000000){
    tax = personalSalary * (15/100);
    alert("Thuế thu nhập cá nhân phải nộp: " + " " + tax);
}
// - Bậc 2: Thu nhập tính thuế trên 05 triệu đồng đến 10 triệu đồng, thuế suất 10%.
else if(personalSalary >5000000 && personalSalary >=10000000){
    tax = personalSalary * (10/100);
    alert("Thuế thu nhập cá nhân phải nộp: " + " " + tax);
}
// - Bậc 1: Thu nhập tính thuế đến 05 triệu đồng, thuế suất 5%.
else{
    tax = personalSalary * (5/100);
    alert("Thuế thu nhập cá nhân phải nộp: " + " " + tax);
}
// Bài 12: Viết chương trình tính lãi ngân hàng (lãi mẹ đẻ lãi con) 
// khi biết số tiền ban đầu, số tháng cho vay và lãi xuất hàng tháng.
// let loanAmount = parseFloat(prompt("Số tiền vay: "));
// let loanMonth = parseFloat(prompt("Số tháng cho vay"));
// let monthlyProfit = 0.2;



