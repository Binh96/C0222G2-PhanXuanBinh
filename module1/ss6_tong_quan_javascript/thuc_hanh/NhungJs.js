
        
function clickButton(){
    alert("Xin chào!");
}

    // Cách 2 sử dụng phương thức addEventlistenner()

var demo = document.getElementById("demo");
    demo = document.addEventListener("click", clickButton);

    