
// function to show second form and hide first form
function show() {
  document.getElementById('firstForm').innerHTML = '';
  alert("Employee ID - E001/01");
  document.getElementById('secondForm').style.display = 'block';
  (<HTMLInputElement>document.getElementById('employee')).value = 'E001/01';
}   



// fuction to show currency of cycle pass for different currency value 
function showCurrencyCycle() {
  let money:string;
  let x:string = (<HTMLInputElement>document.getElementById('currencyCycle')).value;
  if (x == "inr") {
    document.getElementById('cyclePassINR').style.display = 'block';
    document.getElementById('cyclePassUSD').style.display = 'none';
    document.getElementById('cyclePassYEN').style.display = 'none';
  }
  else if (x == "usd") {
    document.getElementById('cyclePassUSD').style.display = 'block';
    document.getElementById('cyclePassINR').style.display = 'none';
    document.getElementById('cyclePassYEN').style.display = 'none';
  }
  else {
    document.getElementById('cyclePassYEN').style.display = 'block';
    document.getElementById('cyclePassINR').style.display = 'none';
    document.getElementById('cyclePassUSD').style.display = 'none';
  }
}

// fuction to show currency of motor cycle pass for different currency value 
function showCurrencyMotorCycle() {
    let x:string = (<HTMLInputElement>document.getElementById('currencyMotorCycle')).value;

  if (x == "inr") {
    document.getElementById('motorCyclePassINR').style.display = 'block';
    document.getElementById('motorCyclePassUSD').style.display = 'none';
    document.getElementById('motorCyclePassYEN').style.display = 'none';
  }
  else if (x == "usd") {
    document.getElementById('motorCyclePassUSD').style.display = 'block';
    document.getElementById('motorCyclePassINR').style.display = 'none';
    document.getElementById('motorCyclePassYEN').style.display = 'none';
  }
  else {
    document.getElementById('motorCyclePassYEN').style.display = 'block';
    document.getElementById('motorCyclePassINR').style.display = 'none';
    document.getElementById('motorCyclePassUSD').style.display = 'none';
  }
}

// fuction to show currency of four wheeler pass for different currency value
function showCurrencyFourWheeler() {
    let x:string = (<HTMLInputElement>document.getElementById('currencyFourWheeler')).value;
  if (x == "inr") {
    document.getElementById('fourWheelerPassINR').style.display = 'block';
    document.getElementById('fourWheelerPassUSD').style.display = 'none';
    document.getElementById('fourWheelerPassYEN').style.display = 'none';
  }
  else if (x == "usd") {
    document.getElementById('fourWheelerPassUSD').style.display = 'block';
    document.getElementById('fourWheelerPassINR').style.display = 'none';
    document.getElementById('fourWheelerPassYEN').style.display = 'none';
  }
  else {
    document.getElementById('fourWheelerPassYEN').style.display = 'block';
    document.getElementById('fourWheelerPassINR').style.display = 'none';
    document.getElementById('fourWheelerPassUSD').style.display = 'none';
  }
}   

let x:string;
// function to show passes for differnt vehicle and their price
function showPass() {
  x = (<HTMLInputElement>document.getElementById('opted')).value;
  document.getElementById('secondForm').innerHTML = '';
  if (x == "cycle") {
    document.getElementById('cyclePass').style.display = 'block';
  }
  else if (x == "motor") {
    document.getElementById('motorCyclePass').style.display = 'block';
  }
  else {
    document.getElementById('fourWheelerPass').style.display = 'block';
  }
}   


//fuction to check java script validation on for 
function checkForm() {
  let name:string = document.forms["employee"]["name"].value;
  let email:string = document.forms["employee"]["email"].value;
  let passwordObtained:string = document.forms["employee"]["password"].value;
  let contact:string = document.forms["employee"]["contact"].value;
  let confirmPassword:string = document.forms["employee"]["confirm"].value;
  let letterNumber = /^[a-zA-Z]+ [a-zA-Z]+$/;
  let passwordCheck = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}$/;
  let mailFormat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
  if (name.length < 2) {
    alert("Name length less than 2 ");
    return false;
  }
  else if (!name.match(letterNumber)) {
    alert("Please enter valid name with surname containing only valid characters");
    return false;
  }
  else if (!email.match(mailFormat)) {
    window.alert("Please enter a valid e-mail address.");
    return false;
  }
  else if (!passwordObtained.match(passwordCheck)) {
    window.alert("Password should contain atleast one lowercase,one uppercase and one number and minimum length 8");
    return false;
  }
  else if (contact.length <= 8 || contact.length >= 11) {
    alert("Contact length should be greater than 8 and not more than 10");
    return false;
  }
  else if (confirmPassword != passwordObtained) {
    alert("Please enter the same password in confirm password field");
    return false;
  }
  else {
    show();
  }
}	

// function to show pass ticket genreated for the vehicle
function showTicket() {
  if (x == "cycle") {
    let money:string = (<HTMLInputElement>document.querySelector('input[name = "cyclePass"]:checked')).value;
    document.getElementById('showTicket').innerHTML = '<div align="center"><h1>Congratulations !! You have successfully obtained the ticket</h1><br><h2>Total amount paid is ' + money + '</div>';
  }
  else if (x == "motor") {
    let money:string = (<HTMLInputElement>document.querySelector('input[name = "motorCyclePass"]:checked')).value;
    document.getElementById('showTicket').innerHTML = '<div align="center"><h1>Congratulations !! You have successfully obtained the ticket</h1><br><h2>Total amount paid is ' + money + '</div>';
  }
  else {
    let money:string = (<HTMLInputElement>document.querySelector('input[name = "fourWheelerPass"]:checked')).value;
    document.getElementById('showTicket').innerHTML = '<div align="center"><h1>Congratulations !! You have successfully obtained the ticket</h1><br><h2>Total amount paid is ' + money + '</div>';
  }
  document.getElementById('cyclePass').innerHTML = '';
  document.getElementById('motorCyclePass').innerHTML = '';
  document.getElementById('fourWheelerPass').innerHTML = '';
}
