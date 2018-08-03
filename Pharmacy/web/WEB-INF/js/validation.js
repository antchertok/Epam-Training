function validateSignIn(){

            var erLogin = document.getElementById("loginIn"),
                erPassword = document.getElementById("passwordIn");
            erLogin.innerHTML= "";
            erPassword.innerHTML= "";

            var login=document.forms["LoginForm"]["login"].value;
            var password=document.forms["LoginForm"]["password"].value;

            if (!login){
                erLogin.innerHTML="*please fill this field";
                return false;
            }
            if (!password){
                erPassword.innerHTML="*please fill this field";
                return false;
            }
            if (login.length < 5){
                erLogin.innerHTML="*login must contain at least 5 symbols";
                return false;
            }
            if (password.length < 5){
                erPassword.innerHTML="*too short password";
                return false;
            }
        }

function validateSignUp(){

            var erNewLogin = document.getElementById("loginUp"),
                erNewPassword = document.getElementById("passwordUp"),
                erMail = document.getElementById("mailUp"),
                erFirstName = document.getElementById("firstNameUp"),
                erLastName = document.getElementById("lastNameUp");
            erNewLogin.innerHTML= "";
            erNewPassword.innerHTML= "";
            erMail.innerHTML = "";
            erFirstName.innerHTML = "";
            erLastName.innerHTML = "";

            var login=document.forms["SignUpForm"]["login"].value,
                password=document.forms["SignUpForm"]["password"].value,
                firstName=document.forms["SignUpForm"]["firstName"].value,
                lastName=document.forms["SignUpForm"]["lastName"].value,
                mail=document.forms["SignUpForm"]["email"].value;

            if (!login){
                erNewLogin.innerHTML="*please fill this field";
                return false;
            }
            if (!password){
                erNewPassword.innerHTML="*please fill this field";
                return false;
            }
            if(!firstName){
                erFirstName.innerHTML="*please fill this field";
                return false;
            }
            if(!lastName){
                erLastName.innerHTML="*please fill this field";
                return false;
            }
            if(!mail){
                erMail.innerHTML="*please fill this field";
                return false;
            }
            if (login.length < 5){
                erLogin.innerHTML="*login must contain at least 5 symbols";
                return false;
            }
            if (password.length < 5){
                erPassword.innerHTML="*too short password";
                return false;
            }
        }