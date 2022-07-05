
function gotoListBlog(){
    location.href="/blog.html";
}

function gotoHome(){
    location.href="/index.html";
}

function gotoAddNewPost(){
    $(".blog-container").hide();
    $(".new-post").show();
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        type: "GET",
        url: "http://localhost:8080/category/getCategory",
        success: function(data){
            category(data);
        }
    })
}

function listPost(curPage, size){
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        type: "GET",
        url: "http://localhost:8080/blog/post?page=" + curPage + "&size=" + size,
        success: function(data){
            if(size > data.totalElements){
                console.log("Error");
            }
            else{
                let content="";
                for(let i=0; i<data.content.length; i++){
                    content+=`<div class="row my-5">
                    <div class="col-3">
                        <img src="${data.content[i].img}" alt="" class="img-post">
                    </div>
                    <div class="col-9 py-3">
                        <a class="heading-post text-white">${data.content[i].heading}</a>
                        <p class="desc-post text-white">${data.content[i].description}</p>
                        <a href="#" class="link-post text-white">Continue</a>
                    </div>
                </div>`
                }
                document.getElementById('post-list').innerHTML = content;
            }
            
        }
    })
}

$('#blog-container').load(listPost(0, 2));

function category(category){
    let categoryList = "";
    for(let i=0; i<category.length; i++){   
        categoryList += `<option value='${i+1}'>${category[i].name}</option>`;
    }
    document.getElementById('category').innerHTML = categoryList;
}

function createPost(){
    let heading = $('#heading').val();
    let desc = $('#desc').val();
    let img = $('#img').val();
    let author = $('#author').val();
    let content = $('#content').val();
    let category = $('#category').val();
    let post ={
        heading: heading,
        description: desc,
        img: img,
        author: author,
        content: content,
        category: {
            id: category
        }
    }

    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        type: "POST",
        url: "http://localhost:8080/blog/create",
        data: JSON.stringify(post)
    });
    $(".blog-container").show();
    $(".new-post").hide();
}

let size = 2;
$('#buttonLoadMore').click(
    function(){
        size += 2;
        listPost(0, size);
    }
);
