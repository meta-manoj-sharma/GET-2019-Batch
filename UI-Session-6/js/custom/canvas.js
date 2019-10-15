
/*
  To create canvas
*/
function  firstFuction() {
    var canvas = document.getElementById("partly-cloudy-day");
    var ctx = canvas.getContext("2d");
    var img = new Image();   // Create new img element
    img.addEventListener('load', function() {
        ctx.drawImage(img, 0, 0);
    }, false);
    img.src = 'images/cloud.png';
};

function secondFunction() {
    var canvas = document.getElementById("rain");
    var ctx = canvas.getContext("2d");
    var img = new Image();   // Create new img element
    img.addEventListener('load', function() {
        ctx.drawImage(img, 0, 0);
    }, false);
    img.src = 'images/rain.png';
};

function thirdFunction() {
    var canvas = document.getElementById("wind");
    var ctx = canvas.getContext("2d");
    var img = new Image();   // Create new img element
    img.addEventListener('load', function() {
        ctx.drawImage(img, 0, 0);
    }, false);
    img.src = 'images/wind.png';
};

function start() {
    firstFuction();
    secondFunction();
    thirdFunction();
}

window.onload = start;
