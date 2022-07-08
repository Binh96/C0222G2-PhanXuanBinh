
function getForm(){
    let valueSelectType = $('#selectType').val();
    if(valueSelectType === '1'){
        $('#room-facility').show();
        $('#villa-facility').hide();
        $('#house-facility').hide();
    }
    if(valueSelectType === '2'){
        $('#house-facility').show();
        $('#room-facility').hide();
        $('#villa-facility').hide();
    }
    if(valueSelectType === '3'){
        $('#villa-facility').show();
        $('#house-facility').show();
        $('#room-facility').hide();
    }
}

function checkEdit(){
    let valueSelectType = $('#selectType').val();
    if(valueSelectType === '1'){
        $('#room-facility').show();
        $('#villa-facility').hide();
        $('#house-facility').hide();
    }
    if(valueSelectType === '2'){
        $('#facilityFree').val(" ");
        $('#house-facility').show();
        $('#room-facility').hide();
        $('#villa-facility').hide();
    }
    if(valueSelectType === '3'){
        $('#facilityFree').val(" ");
        $('#villa-facility').show();
        $('#house-facility').show();
        $('#room-facility').hide();
    }
}

function getEmployee(id){
    console.log(id);
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        type: "GET",
        url: "http://localhost:8080/furama/restemployee/edit/"+id,
        success: function(data){
            readValueEmployee(data, id);
        }
    })
}

function getAttachForContractDetail(number){
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        type: "GET",
        url: "http://localhost:8080/furama/contractrest/get_attach_forcontractdetail",
        success: function(data){
            let content="";
            for(let i=0; i<data.length; i++){
                content+= `<option value="${data[i].id}" class="form-control">${data[i].name}</option>`;
            }
            document.getElementById('attachSelect'+number).innerHTML = content;
        }
    })
}

function createContractDetail(id){
    let contractId = id;
    let attachFacilities = $('#attachSelect'+id).val();
    console.log(attachFacilities);
    let contractDetail =  {
        'contract' : {
            'id': contractId
        },
        'attachFacility' : {
            'id' : attachFacilities
        }
    };
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        type: "POST",
        url: "http://localhost:8080/furama/contractrest/create_contract_detail",
        data: JSON.stringify(contractDetail),
        success: function(){
            console.log('success');
        }
    })
}

function getContract(){

}


function getAttach(id){
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        type: "GET",
        url: "http://localhost:8080/furama/contractrest/find/"+id,
        success: function(data){
            let content = "";
            if(data.length===0){
                content+=`No data`;
                document.getElementById("attachInfor"+id).innerHTML= content;
            }else{
                for(let i=0; i<data.length; i++){
                    content+=`<tr>
                              <td>${i+1}</td>
                              <td>${data[i].attachFacility.name}</td>
                           </tr>`;
                }
                document.getElementById("attachList"+id).innerHTML = content;
            }
        }
    })
}






function readValueEmployee(employee){
    $('#nameEdit'+employee.id).val(employee.name);
    $('#idCardEdit' +employee.id).val(employee.idCard);
    $('#dobEdit' +employee.id).val(employee.dateOfBirth);
    $('#phoneNumberEdit' +employee.id).val(employee.phoneNumber);
    $('#emailEdit' +employee.id).val(employee.email);
    $('#addressEdit' +employee.id).val(employee.address);
    $('#salaryEdit' +employee.id).val(employee.salary);
    $('#selectPositionEdit'+employee.id).val(employee.position.id);
    $('#selectEducationEdit'+employee.id).val(employee.educationDegree.id);
    $('#selectDivisionEdit'+employee.id).val(employee.division.id);
}

function editEmployee(id){
    let name = $('#nameEdit'+id).val();
    let idCard = $('#idCardEdit' +id).val();
    let dob = $('#dobEdit' +id).val();
    let phoneNumber = $('#phoneNumberEdit' +id).val();
    let email = $('#emailEdit' +id).val();
    let address =$('#addressEdit' +id).val();
    let salary = $('#salaryEdit' +id).val();
    let position =$('#selectPositionEdit'+id).val();
    let education = $('#selectEducationEdit'+id).val();
    let division = $('#selectDivisionEdit'+id).val();
    let employee = {
        'id' : id,
        'name' : name,
        'idCard': idCard,
        'dateOfBirth': dob,
        'phoneNumber': phoneNumber,
        'email': email,
        'address': address,
        'salary': salary,
        'position':{
            'id': position
        },
        'educationDegree':{
            'id': education
        },
        'division':{
            'id': division
        }
    }
}
