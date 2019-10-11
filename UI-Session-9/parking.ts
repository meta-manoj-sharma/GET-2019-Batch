var vehicleType;
var currencyType;
var password;
function nextGender(){
   let name:string = (<HTMLInputElement>document.getElementById("in")).value;
   let regexpName = /^[a-z A-Z]+$/;
   if(regexpName.test(name)){
      document.getElementById("lbl").innerHTML="Hi "+ name + "!" +" Enter Your Gender";
      let divField = document.getElementById("field"); //Get the element
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
      let child = document.getElementById("in");
      child.setAttribute("type", "hidden");
   }else{
      alert("Name can't be blank and only charactors are allowed!");
   }
   
}
function nextMail(){
    
   document.getElementById("lbl").innerHTML="Enter Your Email ";
   (<HTMLInputElement>document.getElementById("in")).type = "email";
   (<HTMLInputElement>document.getElementById("in")).value="";
   (<HTMLInputElement>document.getElementById("in")).onblur = nextPass;
   let divField = document.getElementById("field");
   let child1 = document.getElementById("genderM");
   let child2 = document.getElementById("genderF");
   let child3 = document.getElementById("Male");
   let child4 = document.getElementById("Female");
   divField.removeChild(child1);
   divField.removeChild(child2);
   divField.removeChild(child3);
   divField.removeChild(child4);
}

function nextPass(){
   let email = (<HTMLInputElement>document.getElementById("in")).value;
   let regexpEmail = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
   if(regexpEmail.test(email)){
      document.getElementById("lbl").innerHTML="Enter Your Password !";
      (<HTMLInputElement>document.getElementById("in")).type = "password";
      (<HTMLInputElement>document.getElementById("in")).value="";
      document.getElementById("in").onblur = nextConPass;
   }else{
      alert("Email should be in Proper Format!");
   }
}

function nextConPass(){
    password = (<HTMLInputElement>document.getElementById("in")).value;
    let regexpPassword = /^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\S+$).{8,}$/;
    if(regexpPassword.test( password)){
      document.getElementById("lbl").innerHTML="Please Confirm Your Password !";
      (<HTMLInputElement>document.getElementById("in")).type = "password";
      (<HTMLInputElement>document.getElementById("in")).value="";
      document.getElementById("in").onblur = nextContact;
   }else{
      alert("Please enter strong password in proper format!");
   } 
}

function nextContact(){
   let repass = (<HTMLInputElement>document.getElementById("in")).value;
   if(password != repass){
     alert("Passwords Don't Match!");
   }else{
      document.getElementById("lbl").innerHTML="Enter Your Contact Number!";
      (<HTMLInputElement>document.getElementById("in")).type = "number";
      (<HTMLInputElement>document.getElementById("in")).value="";
      document.getElementById("in").onblur = nextVehicleNumber;
  }
}

function nextVehicleNumber(){
   let contact = (<HTMLInputElement>document.getElementById("in")).value;
   if (contact.length > 8 && contact.length <= 11) {
      document.body.style.background = "gray";
      document.getElementById("lbl").innerHTML="Enter your vehicle number!";
      (<HTMLInputElement>document.getElementById("in")).type = "number";
      (<HTMLInputElement>document.getElementById("in")).value="";
      document.getElementById("in").onblur = nextEmpId;
   }
   else{
      alert("contact number length should be between 8 to 11");
   }
}
function nextEmpId(){
   let vehicleNumber = (<HTMLInputElement>document.getElementById("in")).value;
   if (vehicleNumber.length <= 4) {
      document.getElementById("lbl").innerHTML = "Enter Your Employee Id!";
      (<HTMLInputElement>document.getElementById("in")).type = "id";
      (<HTMLInputElement>document.getElementById("in")).value="";
      document.getElementById("in").onblur = nextVehicleType;
   }
   else{
      alert("Vehicle number length should be less than or equal to 4");
   }
}

function nextVehicleType(){
   document.getElementById("lbl").innerHTML="What's Your Vehicle Type [cycle/motorcycle/fourwheeler] ?";
   (<HTMLInputElement>document.getElementById("in")).type = "text";
   (<HTMLInputElement>document.getElementById("in")).value="";
   document.getElementById("in").onblur = nextPriceType;
}
 function nextPriceType(){
   vehicleType = (<HTMLInputElement>document.getElementById("in")).value;
   if(vehicleType == "cycle" || vehicleType == "motorcycle" || vehicleType == "fourwheeler"){
      document.getElementById("lbl").innerHTML = "Enter Currency type you prefer[INR/USD/YEN] ?";
      (<HTMLInputElement>document.getElementById("in")).type = "text";
      (<HTMLInputElement>document.getElementById("in")).value="";
      document.getElementById("in").onblur = nextPlanType;
   }
   else{
      alert("Enter valid vehicle type in small case letter")
   }
}
 

 function nextPlanType(){
   document.body.style.background = "DarkSeaGreen";
    currencyType = (<HTMLInputElement>document.getElementById("in")).value;
   var check = false;
   if("cycle" == vehicleType && "INR" == currencyType){
     document.getElementById("lbl").innerHTML="Choose Your Pass[5 Daily/100 Monthly/500 Yearly]!";
     check = true;
   }else if("motorcycle" == vehicleType && "INR" == currencyType){
      document.getElementById("lbl").innerHTML="Choose Your Pass[10 Daily/200 Monthly/1000 Yearly]!";
      check = true;
   }else if("fourwheeler" == vehicleType && "INR" == currencyType){
      document.getElementById("lbl").innerHTML="Choose Your Pass[20 Daily/500 Monthly/3500 Yearly]!";
      check = true;
   }
   else if("cycle" == vehicleType && "USD" == currencyType){
      document.getElementById("lbl").innerHTML="Choose Your Pass[0.069 $ Daily/1.39$  Monthly/6.95$ Yearly]!";
      check = true;
   }else if("motorcycle" == vehicleType && "USD" == currencyType){
      document.getElementById("lbl").innerHTML="Choose Your Pass[0.14 $ Daily/2.78$ Monthly/13.88$ Yearly]!";
      check = true;
   }else if("fourwheeler" == vehicleType && "USD" == currencyType){
      document.getElementById("lbl").innerHTML="Choose Your Pass[0.28 $ Daily/6.94$ Monthly/48.60$ Yearly]!";
      check = true;
   }
   else if("cycle" == vehicleType && "YEN" == currencyType){
      document.getElementById("lbl").innerHTML="Choose Your Pass[7.35 ¥  Daily/147.08 ¥ Monthly/735.42 ¥ Yearly]!";
      check = true;
   }else if("motorcycle" == vehicleType && "YEN" == currencyType){
      document.getElementById("lbl").innerHTML="Choose Your Pass[14.69 ¥ Daily/293.89 ¥ Monthly/1469.45 ¥ Yearly]!";
      check = true;
   }else if("fourwheeler" == vehicleType && "YEN" == currencyType){
      document.getElementById("lbl").innerHTML="Choose Your Pass[29.39 ¥ Daily/734.72 ¥ Monthly/5143.07 ¥ Yearly]!";
      check = true;
   }
   if(check == true){
      (<HTMLInputElement>document.getElementById("in")).type = "number";
      (<HTMLInputElement>document.getElementById("in")).value="";
      document.getElementById("in").onblur = nextConfirmation;
   }
   else{
     alert("Select proper currency type Only in capital letters");
   }
 }

 function nextConfirmation(){
   var pass = (<HTMLInputElement>document.getElementById("in")).value;

   if("cycle" == vehicleType && "INR" == currencyType && (pass == '5' || pass == '100' || pass == '500')){
      document.getElementById("field").innerHTML=" Your pass price is " + pass +" INR !!!!!";
      document.getElementById("field").style.animation = "end 4s";
      document.body.style.background = "RosyBrown";
   }else if("motorcycle" == vehicleType && "INR" == currencyType && (pass == '10' || pass == '200' || pass == '1000')){
      document.getElementById("field").innerHTML=" Your pass price is " + pass +" INR !!!!!";
      document.getElementById("field").style.animation = "end 4s";
      document.body.style.background = "RosyBrown";
   }else if("fourwheeler" == vehicleType && "INR" == currencyType && (pass == '20' || pass == '500' || pass == '3500')){
      document.getElementById("field").innerHTML=" Your pass price is " + pass +" INR !!!!!";
      document.getElementById("field").style.animation = "end 4s";
      document.body.style.background = "RosyBrown";
   }
   else if("cycle" == vehicleType && "USD" == currencyType && (pass == '0.069' || pass == '1.39' || pass == '6.95')){
      document.getElementById("field").innerHTML=" Your pass price is " + pass +" USD !!!!!";
      document.getElementById("field").style.animation = "end 4s";
      document.body.style.background = "RosyBrown";
   }else if("motorcycle" == vehicleType && "USD" == currencyType && (pass == '0.14' || pass == '2.78' || pass == '13.88')){
      document.getElementById("field").innerHTML=" Your pass price is " + pass +" USD !!!!!";
      document.getElementById("field").style.animation = "end 4s";
      document.body.style.background = "RosyBrown";
   }else if("fourwheeler" == vehicleType && "USD" == currencyType && (pass == '0.28' || pass == '6.94' || pass == '48.60')){
      document.getElementById("field").innerHTML=" Your pass price is " + pass +" USD !!!!!";
      document.getElementById("field").style.animation = "end 4s";
      document.body.style.background = "RosyBrown";
   }
   else if("cycle" == vehicleType && "YEN" == currencyType &&(pass == '7.35' || pass == '147.08' || pass == '735.42')){
      document.getElementById("field").innerHTML=" Your pass price is " + pass +" YEN !!!!!";
      document.getElementById("field").style.animation = "end 4s";
      document.body.style.background = "RosyBrown";
   }else if("motorcycle" == vehicleType && "YEN" == currencyType && (pass == '14.69' || pass == '293.89' || pass == '1469.45')){
      document.getElementById("field").innerHTML=" Your pass price is " + pass +" YEN !!!!!";
      document.getElementById("field").style.animation = "end 4s";
      document.body.style.background = "RosyBrown";
   }else if("fourwheeler" == vehicleType && "YEN" == currencyType && (pass == '29.39' || pass == '734.72' || pass == '5143.07')){
      document.getElementById("field").innerHTML=" Your pass price is " + pass +" YEN !!!!!";
      document.getElementById("field").style.animation = "end 4s";
      document.body.style.background = "RosyBrown";
   }
   else{
      alert("Please give valid pass price");
   }
 }