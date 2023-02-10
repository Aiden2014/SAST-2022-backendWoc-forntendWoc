
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
        var xhr=new XMLHttpRequest();
        xhr.open("GET","http://localhost:8080/user/register?userName="+username+"&password="+password+"&email="+email,true);
        xhr.send();
        xhr.onreadystatechange = function() {
            if (xhr.readyState === 4 && xhr.status === 200) {
                //GET完毕时才运行
                if(xhr.responseText==="fail"){
                    alert("添加失败，已经和别人重名");
                }else{
                    alert("添加成功");
                }
            }
        }
    }
}

const del=()=>{
    const username=document.getElementById("usernametext").value;
    if(username===""){
        alert("输入未完整")
    }else{
        var xhr=new XMLHttpRequest();
        xhr.open("GET","http://localhost:8080/admin/del_user?userName="+username,true);
        xhr.send();
        xhr.onreadystatechange = function() {
            if (xhr.readyState === 4 && xhr.status === 200) {
                //GET完毕时才运行
                if(xhr.responseText==="fail"){
                    alert("删除失败，查无此人");
                }else{
                    alert("删除成功");
                }
            }
        }
    }
}

const change=()=>{
    const username=document.getElementById("usernametext").value;
    const password=document.getElementById("passwordtext").value;
    const email=document.getElementById("emailtext").value;
    if(username===""||password===""||email===""){
        alert("输入未完整")
    }else{
        var xhr=new XMLHttpRequest();
        xhr.open("GET","http://localhost:8080/admin/change?userName="+username+"&password="+password+"&email="+email,true);
        xhr.send();
        xhr.onreadystatechange = function() {
            if (xhr.readyState === 4 && xhr.status === 200) {
                //GET完毕时才运行
                if(xhr.responseText==="fail"){
                    alert("查无此人");
                }else{
                    alert("修改成功");
                }
            }
        }
    }
}

const search = ()=>{
    const username=document.getElementById("usernametext").value;
    if(username===""){
        alert("输入未完整")
    }else{
        var xhr=new XMLHttpRequest();
        xhr.open("GET","http://localhost:8080/admin/find_user_info?userName="+username,true);
        xhr.send();
        xhr.onreadystatechange = function() {
            if (xhr.readyState === 4 && xhr.status === 200) {
                //GET完毕时才运行
                if(xhr.responseText===""){
                    alert("查无此人");
                }else{
                    var obj = JSON.parse(xhr.responseText);
                    document.getElementById("passwordtext").value=obj.password;
                    document.getElementById("emailtext").value=obj.email;
                }
            }
        }
    }
}
