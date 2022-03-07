

const $ = document.querySelector.bind(document);
const $$ = document.querySelectorAll.bind(document);

const inputElementOne= $('#num1');
const inputElementTwo= $('#num2');


const btns = $$('button');

for(let i=0; i< btns.length; i++){
    btns[i].onclick = function(){
        let num1 = parseFloat(inputElementOne.value);
        let num2 = parseFloat(inputElementTwo.value);
        const value = btns[i].value;
        let result;
        if(value == 'sub'){
            console.log(result = num1 - num2)
        }
        else if(value == 'div'){
            console.log(result = num1 / num2)
        }
        else if(value == 'mul'){
            console.log(result = num1 * num2)
        }
        else{
            console.log(result = num1 + num2)
        }
    }
}
