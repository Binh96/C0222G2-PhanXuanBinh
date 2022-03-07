

//  Biến và toán tử, kiểu dữ liệu

//  Bài 1: nhập điểm và tính điểm trung bình và tổng của những điểm vừa nhập 

let physical = prompt("Nhập điểm môn lý");
let chemistry = prompt("Nhập điểm môn hóa");
let biology = prompt("Nhập điểm môn sinh học");

    //  chuyển dữ liệu nhập vào sang Number
let parsePhysical = parseInt(physical);
let parseChemistry = parseInt(chemistry);
let parseBiology = parseInt(biology);

let avr = (parsePhysical + parseChemistry + parseBiology)/3;

alert(avr);

// Bài 2: nhập độ C và chuyển sang độ F 

let celcius = prompt("Nhập độ C");

    // chuyển celcius sang kiểu Number
let parseCelcius = parseFloat(celcius);

let fahrenheit = (9/5) * parseCelcius + 32;

console.log(fahrenheit);


//  Bài 3: Tính diện tích hình tròn

let circle;
let r = prompt("Nhap ban kinh:");
let parseR= parseInt(r); 
let pi= 3.1415;

console.log(circle= r*pi);

// Bài 4: Tính chu vi hình tròn

let circle2;
let r2 = prompt("Nhap ban kinh:");
let parseR2= parseInt(r2); 
let pi2= 3.1415;

console.log(circle2= 2*parseR2*pi2);