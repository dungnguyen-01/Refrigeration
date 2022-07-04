function updateCate(event){
    var id= event.id;
    var x= event.srcElement;
    /*var id = document.getElementById(x);*/


    let name = prompt("Please enter your product' name:","");
    if (name == null || name === "") {
        alert("User cancelled the prompt.");
    } else {
        let request={
            "id":id,
            "name":name
        }

        fetch("/admin/category/edit", {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(request)
        })
            .then(r =>r.json())
            .then((data)=>{
                if(data.code === "00"){
                    alert("Update successfully")
                } else {
                    alert("Update fail")
                }
                location.reload();
            })
    }

}