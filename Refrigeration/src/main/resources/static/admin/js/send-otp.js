function sendOtp() {
    fetch("/admin/sendOtp",{
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        }
    }).then(r =>r.json())
        .then((data)=>{
            alert(data.msg)
        })
}