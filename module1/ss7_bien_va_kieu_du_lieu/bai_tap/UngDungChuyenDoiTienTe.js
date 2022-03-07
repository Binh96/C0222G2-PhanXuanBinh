

let $ = document.querySelector.bind(document);
let $$ = document.querySelectorAll.bind(document);

const opt= $$('.currency-opt'); 
const buttonElement= $('.btn');

buttonElement.onclick = function (){
    let selectElement = $('#fromCurrency').value;
    let toCurrency = $('#toCurrency').value;
    let moneyValue= $('#price').value;
    let convert=0;
    // console.log(moneyValue,selectElement,toCurrency);

    if((selectElement=='Việt Nam') && (toCurrency== 'USD')){
        convert = moneyValue / 23000;
    }
    else if((selectElement=='Việt Nam') && (toCurrency== 'EU')){
        convert = moneyValue / 24939;
    }
    else if((selectElement=='Mỹ') && (toCurrency== 'VND')){
        convert = moneyValue * 23000;
    }
    else if((selectElement=='Mỹ') && (toCurrency== 'EU')){
        convert = moneyValue * 1.092;
    }
    else if((selectElement=='Euro') && (toCurrency== 'VND')){
        convert = moneyValue * 23000;
    }
    else {
        convert = moneyValue / 1.092 ;
    }


    $('#tag').innerHTML= convert;
}