function deleteDiv() {
    $("div").each(function(idx, item){
        if (item.childElementCount == 0) $(item).remove();
    });
}