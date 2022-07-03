


function gotoListBlog(){
    location.href="/blog.html";
}

function gotoHome(){
    location.href="/index.html";
}

function gotoAddNewPost(){
    $(".blog-container").css("display", "none");
    $(".new-post").css("display", "block");
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

function listPost(){
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        type: "GET",
        url: "http://localhost:8080/blog/post",
        success: function(data){
            console.log(data);
            let content="";
            for(let i=0; i<data.content.length; i++){
                content+=`<div class="row">
                <div class="col-3">
                    <img src="${data.content[i].img}" alt="" class="img-post">
                </div>
                <div class="col-9">
                    <h1 class="heading-post text-white">${data.content[i].heading}</h1>
                    <p class="desc-post text-white">${data.content[i].description}</p>
                    <a href="#" class="link-post text-white text-decoration-none">Continue</a>
                </div>
            </div>`
            }
            document.getElementById('post-list').innerHTML = content;
        }
    })
}

$('#blog-container').load(listPost());

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
    $(".blog-container").css("display", "block");
    $(".new-post").css("display", "none");
}