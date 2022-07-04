function deleteCate(){
    var x= event.srcElement.id;
    var id = document.getElementById(x).id;
    if (confirm("Do you want to delete?")){
        fetch("/category/delete?id=" + id, {
            method: 'GET'
        })
            .then(r =>r.json())
            .then((data)=>{
                location.reload();
            })
    }
}

function deleteProduct(){
    var x= event.srcElement.id;
    var id = document.getElementById(x).id;
    if (confirm("Do you want to delete?")){
        fetch("/product/delete?id=" + id, {
            method: 'GET'
        })
            .then(r =>r.json())
            .then((data)=>{
                location.reload();
            })
    }
}