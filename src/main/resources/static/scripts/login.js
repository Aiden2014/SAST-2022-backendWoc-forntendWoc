
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
        var xhr=new XMLHttpRequest();
        xhr.open("POST","http://localhost:8080/user/login",true);
        xhr.setRequestHeader('content-type','application/x-www-form-urlencoded');
        xhr.onreadystatechange = function() {
            if (xhr.readyState === 4 && xhr.status === 200) {
                //POST完毕时才运行
                if(xhr.responseText!="false"){
                    alert("欢迎回来，"+username);
                    window.location.href="admin.html";
                }else{
                    alert("输入的用户名或密码有误，请重新输入");
                }
            }
          }
        xhr.send("userName="+username+"&password="+password);
    }
}



/*  const submit = () =>{
    const username=document.getElementById("username").value;
    const password=document.getElementById("password").value;
    if(username===""||password===""){
        alert("输入未完整");
    }else{
        var data = "?userName="+username+"&password="+password;
        const options={
            method:'POST',
            headers:{'content-type': 'application/x-www-form-urlencoded'},
            data:data,
            url:'http://localhost:8080/user/login'
        };
        axios(options);
    }
} 
 */