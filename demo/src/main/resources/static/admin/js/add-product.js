function addProduct(){

    var name= document.getElementById("name").value;
    var price = document.getElementById("price").value;
    var qty = document.getElementById("qty").value;
    var cateId =document.getElementById("cateId").value;
    var description = document.getElementById("description").value;
    var imageF = document.getElementById("imageF").value;

    let request={
        "name" :name,
        "price" : price,
        "qty":qty,
        "cateId":cateId,
        "description":description,
        "image":imageF
    }
    fetch("/admin/add",{
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
            /*'Content-Type': 'multipart/form-data'*/
        },
        body: JSON.stringify(request)
    }).then(r =>r.json())
        .then((data)=>{
            alert(data.msg);
            window.location ="http://localhost:8080/admin/product";
        })
}