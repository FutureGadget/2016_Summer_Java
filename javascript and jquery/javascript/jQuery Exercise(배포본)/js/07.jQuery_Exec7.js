function divMove() {
    var tmp = $(".innerDiv").clone();
    $("#sourceDiv").empty();
    $("#targetDiv").append(tmp);
}