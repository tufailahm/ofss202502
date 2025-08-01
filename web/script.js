function validate() {
    var username = document.getElementById('username');
    var password = document.getElementById('password').value;
    var role = document.getElementById('role').value

    if (username.value.length == 0) {
        alert("Please enter your username");
        //username.style.borderColor = "red"; 
        username.className = "error";
        return false;
    }
    else if (password.length == 0) {
        alert("Please enter your password");
        return false;
    }
    //   else if (role == ""){
    else if (role.length == 0) {
        alert("Please enter your role")
        return false;
    }
    //hands on - check role -- one role should be selected
    // Please select your role.

    // document.cookie = "uname" + username.value;
    setCookie(username.value);
    return true;
}

function setCookie(value) {
    var dt = new Date();
    dt.setDate(dt.getDate() + 3);
    document.cookie = "uname=" + escape(value) + "; expires=" + dt.toGMTString();
}
function getCookie(name) {
    if (document.cookie.length > 0) {
        ind = document.cookie.indexOf(name);
        if (ind != -1) {
            ind = ind + name.length + 1;
            ind1 = document.cookie.indexOf(";", ind);
            if (ind1 == -1) ind1 = document.cookie.length;
            return unescape(document.cookie.substring(ind, ind1));
        }
    }
    return "";
}

function checkCookie() {
    document.getElementById('username').value = getCookie('uname');
}


