
function getForm(){
    let valueSelectType = $('#selectType').val();
    let content = "";
    if(valueSelectType === '1'){
        $('#room-facility').show();
    }
    // if(valueSelectType === '2'){
    //     content += `<div class="col-4 mb-3">
    //                         <label for="">Number of floor:</label>
    //                         <input type="text" class="form-control" id="numberOfFloor">
    //                     </div>
    //                     <div class="col-4 mb-3">
    //                         <label for="">Description:</label>
    //                         <input type="text" class="form-control" id="description">
    //                     </div>
    //                     <div class="col-4 mb-3">
    //                         <label for="">Standard room:</label>
    //                         <input type="text" class="form-control" id="standardRoom">
    //                     </div>`;
    // }
    // if(valueSelectType === '3'){
    //     content += `<div class="row">
    //                     <div class="col-4 mb-3">
    //                         <label for="">Description:</label>
    //                         <input type="text" class="form-control" id="description">
    //                     </div>
    //                     <div class="col-4 mb-3">
    //                         <label for="">Standard room:</label>
    //                         <input type="text" class="form-control" id="standardRoom">
    //                     </div>
    //                     <div class="col-4 mb-3">
    //                         <label for="">Area:</label>
    //                         <input type="text" class="form-control" id="area">
    //                     </div>
    //                     <div class="col-4 mb-3">
    //                         <label for="">Pool area:</label>
    //                         <input type="text" class="form-control" id="poolArea">
    //                     </div>
    //                 </div>`;
    // }
}

// function createNewService(){
//     let typeService = $('#selectType').val();
//     let name = $('#name').val();
//     let cost =$('#cost').val();
//     let rentType =$('#rentType').val();
//     let maxPeople =$('#maxPeople').val();
//     let facilityFree =$('#facilityFree').val();
//     let numberOfFloor =$('#numberOfFloor').val();
//     let description =$('#description').val();
//     let standardRoom =$('#standardRoom').val();
//     let area =$('#area').val();
//     let poolArea =$('#poolArea').val();
//     let facility = {
//         'name' : 'name',
//         'cost':'cost',
//         'area':'area',
//         'maxPeople':'maxPeople',
//         'rentType':{
//             'id': 'rentType'
//         },
//         'facilityType':{
//             'id': 'typeService'
//         },
//         'standardRoom':'standardRoom',
//         'description':'description',
//         'poolArea':'poolArea',
//         'numberOfFloor':'numberOfFloor',
//         'facilityFree':'facilityFree'
//     }
//     console.log(facility);
// }
//
// $('#btn-create').click(function (){
//     createNewService();
// });