function sortSelect(){
    var arr = [];
    $("option").each(function(idx, item) {
       arr[idx] = $(item).clone();
    });
    arr.sort(function(a, b){
       return $(a).text().localeCompare($(b).text());
    });
    $("option").each(function(idx,item){
        $(item).replaceWith(arr[idx]);
    });
}