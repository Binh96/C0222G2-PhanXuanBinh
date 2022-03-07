
let userName = prompt("Enter user name:");

if(userName == 'Admin'){
    alert('Welcome');
}

else if(userName == null){
    alert('Canceled');
}

else {
    alert("I don't know you");
}

let passWord = prompt("Enter password");
    if(passWord == 'TheMaster'){
        alert('Welcome');
    }
    else if(passWord == null){
        alert('Canceled');
    }
    else 
        alert('Wrong password');
