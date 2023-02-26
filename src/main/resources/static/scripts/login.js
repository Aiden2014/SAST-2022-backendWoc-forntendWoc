function finish(){
    var load=document.getElementById('load');
    load.style.display="none";
}

const submit = () =>{
    const username=document.getElementById("username").value;
    const password=document.getElementById("password").value;
    if(username===""||password===""){
        alert("输入未完整");
    }else{
        fetch("http://localhost:8080/user/login", {
            method: 'POST',
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded'
            },
            body: "userName="+username+"&password="+password
        })
        .then(response => {
            return response.text();
        })
        .then(data => {
            const dataObj = JSON.parse(data);
            if(dataObj.status === 200){
                var token = dataObj.data.token;
                localStorage.setItem('token', token);
                window.location.href="system.html";
                alert("欢迎回来，"+username);
            }else{
                alert(dataObj.message);
                throw new Response(dataObj.message,{status: dataObj.status})
            }
        })
        .catch(error => {
            console.error('错误:', error);
        });
    }
}