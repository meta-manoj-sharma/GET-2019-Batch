var vehicleType;
var password;
function nextGender(){
    var name = document.getElementById("in").value;
    var regexp = /[a-z A-Z]/;
    if(regexp.test(name)){
      document.getElementById("lbl").innerHTML="Hi "+ name + "!" +" Enter Your Gender";

  
      var divField = document.getElementById("field"); //Get the element
  
      var genderField = document.createElement("INPUT");
      genderField.setAttribute("type", "radio");
      genderField.setAttribute("value", "Male");
      genderField.setAttribute("name", "gender");
      genderField.setAttribute("id", "genderM");
      genderField.setAttribute("onclick", "nextMail()");
      divField.appendChild(genderField);
      var genderField = document.createElement("Label");
      genderField.setAttribute("id", "Male")
      divField.appendChild(genderField);
      genderField.innerHTML = "Male";
  
  
      var genderField = document.createElement("INPUT");
      genderField.setAttribute("type", "radio");
      genderField.setAttribute("value", "Female");
      genderField.setAttribute("id", "genderF");
      genderField.setAttribute("name", "gender");
      genderField.setAttribute("onclick", "nextMail()");
      divField.appendChild(genderField);
      var genderField = document.createElement("Label");
      genderField.setAttribute("id", "Female")
      divField.appendChild(genderField);
      genderField.innerHTML = "Female";
  
      var child = document.getElementById("in");
      child.setAttribute("type", "hidden");
    }else{
        alert("Name can't be blank!");
    }
   
}
function nextMail(){
    
    document.getElementById("lbl").innerHTML="Enter Your Email ";
    document.getElementById("in").type = "email";
    document.getElementById("in").value="";
    document.getElementById("in").onblur = nextPass;
    var divField = document.getElementById("field");
    var child1 = document.getElementById("genderM");
    var child2 = document.getElementById("genderF");
    var child3 = document.getElementById("Male");
    var child4 = document.getElementById("Female");
    divField.removeChild(child1);
    divField.removeChild(child2);
    divField.removeChild(child3);
    divField.removeChild(child4);


}

function nextPass(){
    var email = document.getElementById("in").value;
    var regexp = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    if(regexp.test(email)){
       document.getElementById("lbl").innerHTML="Enter Your Password !";
       document.getElementById("in").type = "password";
       document.getElementById("in").value="";
       document.getElementById("in").onblur = nextConPass;
    }else{
        alert("Email should be in Proper Format!");
    }
}

function nextConPass(){
    password = document.getElementById("in").value;
    var regexp = /^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\S+$).{8,}$/;
    if(regexp.test( password)){
      document.getElementById("lbl").innerHTML="Please Confirm Your Password !";
      document.getElementById("in").type = "password";
      document.getElementById("in").value="";
      document.getElementById("in").onblur = nextContact;
   }else{
       alert("Please enter strong password in proper format!");
   }
   
}

function nextContact(){
  var repass = document.getElementById("in").value;
  if(password != repass){
     alert("Passwords Don't Match!");
  }else{
     document.getElementById("lbl").innerHTML="Enter Your Contact Number!";
     document.getElementById("in").type = "tel";
     document.getElementById("in").value="";
     document.getElementById("in").onblur = nextVehicleNumber;
  }
 }

 function nextVehicleNumber(){
    document.body.style.background = "gray";
     document.getElementById("lbl").innerHTML="Enter your vehicle number!";
     document.getElementById("in").type = "number";
     document.getElementById("in").value="";
     document.getElementById("in").onblur = nextEmpId;
 }
 function nextEmpId(){
    
    document.getElementById("lbl").innerHTML = "Enter Your Employee Id!";
    document.getElementById("in").type = "id";
    document.getElementById("in").value="";
    document.getElementById("in").onblur = nextVehicleType;
}

 function nextVehicleType(){
     document.getElementById("lbl").innerHTML="What's Your Vehicle Type [cycle/motorcycle/fourwheeler] ?";
     document.getElementById("in").type = "text";
     document.getElementById("in").value="";
     document.getElementById("in").onblur = nextPriceType;
 }
 function nextPriceType(){
    vehicleType = document.getElementById("in").value;
    document.getElementById("lbl").innerHTML = "Enter Currency type you prefer[INR/USD/YEN] ?";
    document.getElementById("in").type = "text";
    document.getElementById("in").value="";
    document.getElementById("in").onblur = nextPlanType;
}
 

 function nextPlanType(){
     document.body.style.background = "DarkSeaGreen";
     currencyType = document.getElementById("in").value;
     if("cycle" == vehicleType && "INR" == currencyType){
        document.getElementById("lbl").innerHTML="Choose Your Pass[5 Daily/100 Monthly/500 Yearly]!";
     }else if("motorcycle" == vehicleType && "INR" == currencyType){
        document.getElementById("lbl").innerHTML="Choose Your Pass[10 Daily/200 Monthly/1000 Yearly]!";
     }else if("fourwheeler" == vehicleType && "INR" == currencyType){
        document.getElementById("lbl").innerHTML="Choose Your Pass[20 Daily/500 Monthly/3500 Yearly]!";
     }
     else if("cycle" == vehicleType && "USD" == currencyType){
        document.getElementById("lbl").innerHTML="Choose Your Pass[0.069 $ Daily/1.39$  Monthly/6.95$ Yearly]!";
     }else if("motorcycle" == vehicleType && "USD" == currencyType){
        document.getElementById("lbl").innerHTML="Choose Your Pass[0.14 $ Daily/2.78$ Monthly/13.88$ Yearly]!";
     }else if("fourwheeler" == vehicleType && "USD" == currencyType){
        document.getElementById("lbl").innerHTML="Choose Your Pass[0.28 $ Daily/6.94$ Monthly/48.60$ Yearly]!";
     }
     else if("cycle" == vehicleType && "YEN" == currencyType){
        document.getElementById("lbl").innerHTML="Choose Your Pass[7.35 ¥  Daily/147.08 ¥ Monthly/735.42 ¥ Yearly]!";
     }else if("motorcycle" == vehicleType && "YEN" == currencyType){
        document.getElementById("lbl").innerHTML="Choose Your Pass[14.69 ¥ Daily/293.89 ¥ Monthly/1469.45 ¥ Yearly]!";
     }else if("fourwheeler" == vehicleType && "YEN" == currencyType){
        document.getElementById("lbl").innerHTML="Choose Your Pass[29.39 ¥ Daily/734.72 ¥ Monthly/5143.07 ¥ Yearly]!";
     }
     else{
        alert("Select proper vehicle type or currency type");
     }
     document.getElementById("in").type = "number";
     document.getElementById("in").value="";
     document.getElementById("in").onblur = nextConfirmation;
 }

 function nextConfirmation(){
     var pass = document.getElementById("in").value;

     if("cycle" == vehicleType && "INR" == currencyType && (pass == 5 || pass == 100 || pass == 500)){
        document.getElementById("field").innerHTML=" Your pass price is " + pass +" INR !!!!!";
        document.getElementById("field").style.animation = "end 4s";
        document.body.style.background = "RosyBrown";
     }else if("motorcycle" == vehicleType && "INR" == currencyType && (pass == 10 || pass == 200 || pass == 1000)){
        document.getElementById("field").innerHTML=" Your pass price is " + pass +" INR !!!!!";
        document.getElementById("field").style.animation = "end 4s";
        document.body.style.background = "RosyBrown";
     }else if("fourwheeler" == vehicleType && "INR" == currencyType && (pass == 20 || pass == 500 || pass == 3500)){
        document.getElementById("field").innerHTML=" Your pass price is " + pass +" INR !!!!!";
        document.getElementById("field").style.animation = "end 4s";
        document.body.style.background = "RosyBrown";
     }
     else if("cycle" == vehicleType && "USD" == currencyType && (pass == 0.069 || pass == 1.39 || pass == 6.95)){
        document.getElementById("field").innerHTML=" Your pass price is " + pass +" USD !!!!!";
        document.getElementById("field").style.animation = "end 4s";
        document.body.style.background = "RosyBrown";
     }else if("motorcycle" == vehicleType && "USD" == currencyType && (pass == 0.14 || pass == 2.78 || pass == 13.88)){
        document.getElementById("field").innerHTML=" Your pass price is " + pass +" USD !!!!!";
        document.getElementById("field").style.animation = "end 4s";
        document.body.style.background = "RosyBrown";
     }else if("fourwheeler" == vehicleType && "USD" == currencyType && (pass == 0.28 || pass == 6.94 || pass == 48.60)){
        document.getElementById("field").innerHTML=" Your pass price is " + pass +" USD !!!!!";
        document.getElementById("field").style.animation = "end 4s";
        document.body.style.background = "RosyBrown";
     }
     else if("cycle" == vehicleType && "YEN" == currencyType &&(pass == 7.35 || pass == 147.08 || pass == 735.42)){
        document.getElementById("field").innerHTML=" Your pass price is " + pass +" YEN !!!!!";
        document.getElementById("field").style.animation = "end 4s";
        document.body.style.background = "RosyBrown";
     }else if("motorcycle" == vehicleType && "YEN" == currencyType && (pass == 14.69 || pass == 293.89 || pass == 1469.45)){
        document.getElementById("field").innerHTML=" Your pass price is " + pass +" YEN !!!!!";
        document.getElementById("field").style.animation = "end 4s";
        document.body.style.background = "RosyBrown";
     }else if("fourwheeler" == vehicleType && "YEN" == currencyType && (pass == 29.39 || pass == 734.72 || pass == 5143.07)){
        document.getElementById("field").innerHTML=" Your pass price is " + pass +" YEN !!!!!";
        document.getElementById("field").style.animation = "end 4s";
        document.body.style.background = "RosyBrown";
     }
     else{
        alert("Please give valid pass price");
     }
 }