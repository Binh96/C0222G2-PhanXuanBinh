

// Bài 1: Khai báo các biến thuộc các kiểu khác nhau, gán giá trị cho chúng và in ra tài liệu HTML

let i = 10;             // kiểu số nguyên
let f = 20.5;           // kiểu float  
let b = true;           // kiểu boolean
let s = 'Hà Nội'        // kiểu string

document.write('s = ' + s);

//   Bài 2:  Viết một đoạn mã Javascript, khai báo biến width chứa giá trị độ rộng của hình chữ nhật, 
//             biến height chứa giá trị chiều cao của hình chữ nhật.
//             In ra màn hình diện tích của hình chữ nhật đó.
document.write('<br>');
let width= 30;
let height= 20;

let area = width * height;

document.write("area= " + area);

    // Bài 3:           Dùng hàm prompt() để nhập 2 số từ bàn phím, lưu vào 2 biến là a và b. 
    //                  Kiểm tra xem a có phải là bội số của b hay không (tức là a có chia hết cho b hay không). 
    //                  Hiển thị kết quả ra màn hình bằng cách sử dụng hàm alert().

let a = prompt('Nhap so a:');
let z = prompt('Nhap so b: ');
    if(a%z == 0){
        console.log(a,z);
        alert('a la boi so cua b');
    }
    else
        alert('a khong phai la boi so cua b');