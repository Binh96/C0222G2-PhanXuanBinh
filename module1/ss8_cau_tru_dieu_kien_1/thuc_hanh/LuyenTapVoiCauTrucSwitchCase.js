

// Bài 1: Viết lại cấu trúc if sau thành cấu trúc switch

let browser = prompt("Enter your browser:");
switch(browser){
    case 'Edge': 
        alert("You've got the Edge!");
        break;
    case 'Chorme':
    case 'Firefox':
    case 'Safari':
    case 'Opera':
        alert('Okay we support these browsers too');
        break;
    default: 
        alert("We hope this page looks ok!");
}

//  Bài 2: Viết lại cấu trúc if sau thành cấu trúc switch
let a = parseInt(prompt('Enter a number'));
switch(a){
    case 0:
        alert(0);
        break;
    case 1:
        alert(1);
        break;  
    case 2:
    case 3:
        alert('2,3');
        break;  
}

//  Bài 3: Sử dụng cấu trúc if…else, nhập vào một số, kiểm tra giá trị của số nhập vào
let value = parseInt(prompt('Type a number', 0));

switch(value > 0 ? 1 : (value < 0 ? -1 : 0)){
    case 0:
        alert(0);
        break;
    case 1:
        alert(1);
        break;
    case -1:
        alert(-1);
        break;
}