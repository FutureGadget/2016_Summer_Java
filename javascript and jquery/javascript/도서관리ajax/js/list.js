function search() {
    $.ajax({
        async : true,
        type : "GET",
        dataType : "jsonp",
        jsonp : "callback",
        data : {
            keyword: $("#keyword").val()
        },
        url : "http://localhost:8080/search/searchBooks",
        timeout : 1000,
        success : function(data) {
            $("#searchListTable tbody").empty();
            for (var i = 0; i < data.length; ++i) {
                var td = $("<td></td>");
                var img = $("<img>").attr("src", data[i].bimgurl);
                var tdImg = td.clone().append(img);
                var tdTitle = td.clone().text(data[i].btitle);
                var tdPrice = td.clone().text(data[i].bprice);
                var tdAuthor = td.clone().text(data[i].bauthor);
                var tdisbn = td.clone().text(data[i].bisbn);
                var button = $("<button>del</button>").attr("class","form-control").attr("id",data[i].bisbn);
                var tdButton = td.clone().append(button);
                var row = $("<tr></tr>").append(tdImg);
                row.append(tdTitle);
                row.append(tdAuthor);
                row.append(tdisbn);
                row.append(tdPrice);
                row.append(tdButton);

                $("#searchListTable tbody").append(row);

                button.on("click", function (){
                    $(this).parent().parent().remove();
                    $.ajax({
                        async : true,
                        type : "GET",
                        dataType : "jsonp",
                        jsonp : "callback",
                        data : {
                            // isbn: data[i].bisbn 으로 하면 call back 함수이기 때문에 실행 시점에는 undefined 가 된다.
                            isbn: $(this).attr("id")
                        },
                        url : "http://localhost:8080/search/remove",
                        timeout : 3000,
                        success : function(data) {
                            alert("삭제했습니다!");
                        }
                    })
                });
            }
        },
        error : function() {

        },
        complete : function() {

        }
    });
}