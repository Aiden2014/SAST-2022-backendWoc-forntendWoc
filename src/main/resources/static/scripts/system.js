
function finish(){
    var load=document.getElementById('load');
    load.style.display="none";
}

const add=()=>{
    const username=document.getElementById("usernametext").value;
    const password=document.getElementById("passwordtext").value;
    const email=document.getElementById("emailtext").value;
    if(username===""||password===""||email===""){
        alert("输入未完整")
    }else{
        fetch("http://localhost:8080/user/register", {
            method: 'POST',
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded',
                'token':localStorage.getItem('token') 
            },
            body: "userName="+username+"&password="+password+"&email="+email
        })
        .then(response => {
            return response.text();
        })
        .then(data => {
            const dataObj = JSON.parse(data);
            alert(dataObj.message);
            if(dataObj.status !== 200){
                throw new Response(dataObj.message,{status: dataObj.status})
            }
        })
        .catch(error => {
            console.error('错误:', error);
        });
    }
}

const del=()=>{
    const username=document.getElementById("usernametext").value;
    if(username===""){
        alert("输入未完整")
    }else{
        fetch("http://localhost:8080/admin/del_user", {
            method: 'POST',
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded',
                'token':localStorage.getItem('token') 
            },
            body: "userName="+username
        })
        .then(response => {
            return response.text();
        })
        .then(data => {
            const dataObj = JSON.parse(data);
            alert(dataObj.message);
            if(dataObj.status !== 200){
                throw new Response(dataObj.message,{status: dataObj.status})
            }
        })
        .catch(error => {
            console.error('错误:', error);
        });
    }
}

const change=()=>{
    const username=document.getElementById("usernametext").value;
    const password=document.getElementById("passwordtext").value;
    const email=document.getElementById("emailtext").value;
    if(username===""||password===""||email===""){
        alert("输入未完整")
    }else{
        fetch("http://localhost:8080/admin/change", {
            method: 'POST',
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded',
                'token':localStorage.getItem('token') 
            },
            body: "userName="+username+"&password="+password+"&email="+email
        })
        .then(response => {
            return response.text();
        })
        .then(data => {
            const dataObj = JSON.parse(data);
            alert(dataObj.message);
            if(dataObj.status !== 200){
                throw new Response(dataObj.message,{status: dataObj.status})
            }
        })
        .catch(error => {
            console.error('错误:', error);
        });
    }
}

const search = ()=>{
    const username=document.getElementById("usernametext").value;
    if(username===""){
        alert("输入未完整")
    }else{
        fetch("http://localhost:8080/admin/find_user_info?userName="+username, {
            method: 'GET',
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded',
                'token':localStorage.getItem('token') 
            },
        })
        .then(response => {
            return response.text();
        })
        .then(data => {
            const dataObj = JSON.parse(data);
            alert(dataObj.message);
            if(dataObj.status === 200){
                document.getElementById("passwordtext").value = dataObj.data.password;
                document.getElementById("emailtext").value = dataObj.data.email;
            }else{
                throw new Response(dataObj.message,{status: dataObj.status})
            }
        })
        .catch(error => {
            console.error('错误:', error);
        });
    }
}
