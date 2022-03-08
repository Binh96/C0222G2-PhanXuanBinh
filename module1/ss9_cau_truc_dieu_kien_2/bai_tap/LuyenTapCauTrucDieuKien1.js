

// Bài 1: nhập 2 số a,b và kiểm tra a có chia hết cho b hay không

let A = parseFloat(prompt("Nhập A "), "");
let B = parseFloat(prompt("Nhập B "), "");
if(A%B ==0){
    alert("A chia hết cho B");
}
else
    alert("A không chia hết cho B");

// Bài 2: Nhập tuổi và in ra kết quả nếu tuổi học sinh đó không đủ điều kiện vào học lớp 10.

let age= parseInt(prompt("Nhập tuổi: "), "");

if(age < 16){
    alert("Tuổi học sinh không đủ điều kiện vào học lớp 10!")
}

// Bài 3: Nhập một số nguyên bất kỳ và in kết quả ra màn hình để nói cho người dùng biết số đó là lớn hay nhỏ hơn 0

let number  = parseInt(prompt("Nhập số nguyên bất kì: "));

if(number > 0){
    alert("Số vừa nhập lớn hơn 0");
}
else 
    alert("Số vừa nhập nhỏ hơn 0");

// Bài 4: Nhập 3 số nguyên và tìm giá trị lớn nhất của ba số nguyên đó

let a = parseInt(prompt("Nhập a:"));
let b = parseInt(prompt("Nhập b:"));
let c = parseInt(prompt("Nhập c:"));

if (a>b&&a>c){
    alert("a có giá trị lớn nhất");
}
else if (b>a && b > c){
    alert("b có giá trị lớn nhất");
}

else
    alert("c có giá trị lớn nhất");

// Bài 5: Xếp hạng học lực của học sinh dựa trên các điểm bài kiểm tra, điểm thi giữa kỳ, điểm thi cuối kỳ
let testPoint= parseFloat(prompt("Nhập điểm kiểm tra"));
let midExamPoint= parseFloat(prompt("Nhập điểm thi giữa kì:"))
let finalExamPoint= parseFloat(prompt("Nhập điểm thi cuối kì:"))
let total = (testPoint + (midExamPoint*2) + (finalExamPoint*3))/5;

if(total >= 8.5){
    alert("Học lực Giỏi");
}
else if(total < 8.5 && total > 6){
    alert("Học lực Khá");
}
else if(total <6 && total > 3.5){
    alert("Học lực Trung Bình");
}

else
    alert("Học lực yếu");

// Bài 6: Tính hoa hồng nhận được tuỳ theo mức doanh số bán hàng

let tipMoney= parseFloat(prompt("Nhập doanh số hàng bán được: "));
let totalTipMoney;
if(tipMoney < 300){
    alert(totalTipMoney= tipMoney * (3/100))
}
else if(tipMoney > 300 && tipMoney <= 500){
    alert(totalTipMoney= tipMoney*(4/100));
}
else
    alert(totalTipMoney= tipMoney*(6/100));

// Bài 7: Tính cước điện thoại cho một hộ gia đình với các thông số đã cho
// Phí thuê bao bắt buộc là 25 nghìn.
// 600 đồng cho mỗi gọi của 50 phút đầu tiên.
// 400 đồng cho mỗi phút gọi của 150 phút tiếp theo.
// 200 đồng cho bất kỳ mỗi phút nào sau 200 phút đầu tiên.
let prices=25;
let minutesValue= parseInt(prompt("Số phút đã sử dụng:"));
let lastPrices=0, fee=0;
if(minutesValue > 200){
    fee = (minutesValue - 200) * 200 + 150 * 400 + 50 * 600;
}
else if(minutesValue > 50){
    fee = (minutesValue - 50) * 400 + 50 *600;
}
else{
    fee = minutesValue * 600;
}

lastPrices = 0.01*fee + prices;

alert("Số tiền bạn phải nộp: "+ lastPrices);