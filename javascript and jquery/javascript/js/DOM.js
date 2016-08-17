var time = function() {
    document.getElementById("time").innerHTML = new Date().toLocaleString();
}

function printTime() {
    setInterval(time, 1000);
}