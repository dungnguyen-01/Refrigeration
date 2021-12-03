function changePass(){
    var pass= document.getElementById("pass").value;
    var otp = document.getElementById("otp").value;
    var rePass = document.getElementById("rePass").value;
    let request={
        "pass" :pass,
        "otp" : otp,
        "repass":rePass
    }
    fetch("/admin/change-pass",{
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(request)
    }).then(r =>r.json())
        .then((data)=>{
            alert(data.msg);
            window.location ="http://localhost:8080/admin/forgot";
        })
}