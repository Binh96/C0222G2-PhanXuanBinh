function getStudent(id){
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        type: "GET",
        url: "http://localhost:8080/exam/examRest/edit/"+id,
        success: function(data){
            document.getElementById("nameInput"+id).innerHTML=`<input type="hidden" class="form-control" id="studentId" value="${data.id}">
                        <label for="">Name service:</label>
                        <input type="text" class="form-control" id="name" value="${data.name}">`;
        }
    })
}

function editStudent(id){
    let name = $('#name').val();
    let student = {
        'id': id,
        'name': name
    };
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        type: "PUT",
        url: "http://localhost:8080/exam/examRest/edit",
        data: JSON.stringify(student),
        success: function(){
            alert("Sửa thành công");
            window.location.reload();
        }
    })
}

function deleteStudent(id){
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        type: "GET",
        url: "http://localhost:8080/exam/examRest/delete?id="+id,
        success: function(){
            alert("Xóa thành công");
            window.location.reload();
        }
    })
}
