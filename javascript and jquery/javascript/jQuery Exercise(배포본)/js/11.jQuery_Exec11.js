function countChild() {
    var cnt = 0;
    $("#targetDiv img").each(function (idx, item){
        ++cnt;
    });
    window.alert(cnt);
}