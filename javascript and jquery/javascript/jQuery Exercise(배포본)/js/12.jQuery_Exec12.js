$("#targetDiv").bind("click", function() {
    if ($(this).css("background-color") == "rgb(255, 255, 0)") {
        $(this).css("background-color", "blue");
    } else {
        $(this).css("background-color", "yellow");
    }
});