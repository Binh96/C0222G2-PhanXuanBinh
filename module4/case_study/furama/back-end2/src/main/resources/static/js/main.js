
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
    let quantity = $('#quantity'+id).val();
    let contractDetail =  {
        'contract' : {
            'id': contractId
        },
        'attachFacility' : {
            'id' : attachFacilities
        },
        'quantity': quantity
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
            alert("You're create success");
        }
    })
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

function getCustomer(){
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        type: "GET",
        url: "http://localhost:8080/furama/customerrest/getcustomer",
        success: function(data){
            let content="<option value='' class='form-control'>--Select Customer--</option>";
            for(let i=0; i<data.length; i++){
                content += `<option value="${data[i].id}">${data[i].name}</option>`;
            }
            document.getElementById("selectCustomer").innerHTML = content;
        }
    });
}

function getListEmployee(){
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        type: "GET",
        url: "http://localhost:8080/furama/restemployee/getemployee",
        success: function(data){
            let content="<option value='' class='form-control'>--Select Employee--</option>";
            for(let i=0; i<data.length; i++){
                content += `<option value="${data[i].id}">${data[i].name}</option>`;
            }
            document.getElementById("selectEmployee").innerHTML = content;
        }
    })
}

function getAttachForContract(){
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        type: "GET",
        url: "http://localhost:8080/furama/serviceRest/getfacility",
        success: function(data){
            let content="<option value='' class='form-control'>--Select Type--</option>";
            for(let i=0; i<data.length; i++){
                content += `<option value="${data[i].id}" id="serviceType">${data[i].name}</option>`;
            }
            document.getElementById("selectService").innerHTML = content;
        }
    })
}

function getAttachFacility(){
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        type: "GET",
        url: "http://localhost:8080/furama/contractrest/get_attach_forcontractdetail",
        success: function(data){
            let content="<option value='' class='form-control'>--Select Attach--</option>";
            for(let i=0; i<data.length; i++){
                content+= `<option value="${data[i].id}" class="form-control">${data[i].name}</option>`;
            }
            document.getElementById('attachForContract').innerHTML = content;
        }
    })
}

function getTotalPay(){
    let result = $("#selectService").val();
    let quantity = $("#quantity").val();
    console.log(result);
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        type: "GET",
        url: "http://localhost:8080/furama/serviceRest/getfacility",
        success: function(data){
            for(let i=0; i<data.length; i++){
                if(data[i].id === parseInt(result)){
                    $('#total').val(  parseInt(data[i].cost) + parseInt(quantity) - parseInt( $('#deposit').val()));
                }
            }
        }
    })
}

function createContract(){
    let dayStart= $('#startDate').val();
    let dayEnd= $('#endDate').val();
    let customerId= $('#selectCustomer').val();
    let employeeId= $('#selectEmployee').val();
    let deposit= $('#deposit').val();
    let facilityId= $('#selectService').val();
    let contract = {
        'startDate': dayStart,
        'endDate': dayEnd,
        'deposit': deposit,
        'employee':{
            'id': employeeId
        },
        'customer':{
            'id': customerId
        },
        'facility':{
           'id': facilityId
        }
    }

    let attachForContract = $('#attachForContract').val();
    let quantity = $('#quantity').val();
    let contractDetail = {
        'attachFacility' : {
            'id': attachForContract
        },
        'quantity': quantity
    };

    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        type: "POST",
        url: "http://localhost:8080/furama/contractrest/create_contract",
        data: {contract, contractDetail}
    })
}

function loadInformation(){
    getCustomer();
    getListEmployee();
    getAttachForContract();
    getAttachFacility();
}

function displayTotal(){

}