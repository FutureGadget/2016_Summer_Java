function deleteTag() {
    var backup = $("#targetDiv h2").clone();
    $("#targetDiv").empty();
    $("#targetDiv").append(backup);
}