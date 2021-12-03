function deleteCate(){
    var x= event.srcElement.id;
    var id = document.getElementById(x).id;
    if (confirm("Do you want to delete?")){
        fetch("/category/delete?id=" + id, {
            method: 'GET'
        })
            .then(r =>r.json())
            .then((data)=>{
                /*if(data.code === "00"){
                    alert("Delete successfully")
                } else {
                    alert("Delete fail")
                }*/
                location.reload();
            })
    }
}