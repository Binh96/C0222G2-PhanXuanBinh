// Bài 1: Chuyển từ độ C sang độ F.
let cDegree = parseFloat(prompt('Nhập độ C:'));
let fDegree= cDegree * (9/5) + 32;
alert("Độ F: " + fDegree);

// Bài 2: Chuyển từ mét sang feet:
let meter = parseFloat(prompt('Nhập meter:'));
let feet= meter * 3.2808;
alert("feet: " + feet);

// Bài 3: Tính diện tích hình vuông khi biết cạnh a.
let a = parseFloat(prompt('Nhập cạnh a:'));
let s=0;
if(a<0){
    alert("Sai điều kiện");
}
else{
    s = a *a;
    alert("Diện tích hình vuông"+" "+ s);
}

// Bài 4: Tính diện tích hình  chữ nhật khi biết 02 cạnh a, b.
let A = parseFloat(prompt('Nhập cạnh A:'));
let B = parseFloat(prompt('Nhập cạnh B:'));
let S=0;
if(A==B){
    alert("Độ dài hai cạnh sai!");
}
else{
    S = A * B;
    alert("Diện tích hình chữ nhật: " + " "+ S);
}

// Bài 5: Tính diện tích tam giác vuông khi biết 02 cạnh kề a, b.
// Còn thiếu cách nhận biết tam giác vuông
let triangleA= parseInt(prompt("Nhập cạnh a: "));
let triangleB= parseInt(prompt("Nhập cạnh b: "));
let triangleC= parseInt(prompt("Nhập cạnh c:"));
let sTriangle= (1/2)*triangleA*triangleB;
alert("Diện tích tâm giác vuông: " +" "+ sTriangle);

// Bài 6: Giải phương trình bậc 1.
let numberA= parseInt(prompt("Nhập a: "));
let numberB= parseInt(prompt("Nhập b: "));
let value;

if(numberA == 0){
    if(numberB == 0){
        alert("Phương trình có vô số nghiệm");
    }
    else
        alert("Phương trình vô nghiệm")
}
else{
    value = -numberB/numberA;
    alert("Phương trình có nghiệm: "+ " " + value);
}

// Bài 7: Giải phương trình bậc 2.
let numberC= parseInt(prompt("Nhập C: "));
let numberD= parseInt(prompt("Nhập D: "));
let numberE= parseInt(prompt("Nhập E: "));
let x1,x2,value3;
let delta= numberD*numberD - 4*numberC*numberE;

if(numberC==0){
    // numberC = 0 thì phương trình trở về bậc một 
    if(numberD == 0){
        if(numberE == 0){
            alert("Phương trình vô số nghiệm");
        }
        else
            alert("Phương trình vô nghiệm")
    }
    else{
        value3=-numberE/numberD;
        alert("phương trình có nghiêm duy nhất" + value3);
    }
}
else{
    if(delta > 0){
        x1 = (-numberD + Math.sqrt(delta))/(2*numberC);
        x2 = (-numberD - Math.sqrt(delta))/(2*numberC);
        alert("Nghiệm thứ nhất: " + " " + x1 + " " + "Nghiệm thứ hai: "+ " " + x2);
    }
    else if(delta==0){
        value3= -numberD/(2*numberC);
        alert("Phương trình có nghiệm kép x1,x2: "+ " "+ value3);
    }
    else
        alert("Phương trình vô nghiệm");
}

// Bài 8: Kiểm tra xem một số nhập vào có phải là tuổi của một người không. 
// Một số nguyên là tuổi của một người khi nhỏ 120 và lơn hơn 0.
let age = parseFloat(prompt("Nhập: "));

if(Number.isInteger(age)){
    if(age>0 && age<120){
        alert(age + " " + "là tuổi của một người");
    }
    else
        alert(age + " " + "không phải là tuổi của một người");
}
else
    alert(age + " " + "không phải là tuổi của một người");