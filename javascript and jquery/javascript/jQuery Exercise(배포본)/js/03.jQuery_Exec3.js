function copyDiv() {
    var copy = $("#innerDiv").clone();
    $("#targetDiv #innerDiv").after(copy);
}