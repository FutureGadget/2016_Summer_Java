function resizeDiv(){
    var w = $("#targetDiv").css("width");
    var h = $("#targetDiv").css("height");
    $("#targetDiv").css("width", parseInt(w)*Math.sqrt(2));
    $("#targetDiv").css("height", parseInt(h)*Math.sqrt(2));
}