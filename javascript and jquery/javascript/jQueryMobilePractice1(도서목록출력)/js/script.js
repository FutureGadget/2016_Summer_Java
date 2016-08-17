$(document).on("keypress", function(event) {
    if (event.which != 13) return;
    $.ajax(
        {
            async : true,
            type : "GET",
            dataType : "jsonp",
            jsonp : "callback",
            data : {
                keyword: $("#search").val()
            },
            url : "http://10.16.31.168:8080/search/searchBooks",
            timeout : 1000,
            success : function(data) {
                var ul = $("#result");
                ul.empty();

                var li = $("<li></li>");
                var anchor = $("<a></a>").attr("href","#");

                for (var i = 0; i < data.length; ++i) {
                    var title = $("<h3></h3>").text(data[i].btitle);
                    var author = $("<p></p>").text(data[i].bauthor);
                    var isbn = $("<p></p>").attr("class","ui-li-aside").text(data[i].bisbn);
                    var price = $("<p></p>").text(data[i].bprice);
                    var image = $("<img>").attr("src",data[i].bimgurl);
                    var delAnchor = $("<a></a>").attr("href","#").attr("id",data[i].bisbn);
                    var a = anchor.clone();
                    a.append(image);
                    a.append(title);
                    a.append(author);
                    a.append(isbn);
                    a.append(price);
                    var listItem = li.clone();

                    listItem.append(a);
                    listItem.append(delAnchor);

                    delAnchor.on("click",function() {
                        var ok = confirm("삭제하시겠습니까?");
                        if (ok) {
                            $(this).parent().remove();
                            $.ajax({
                                async: true,
                                type: "GET",
                                dataType: "jsonp",
                                jsonp: "callback",
                                data: {
                                    isbn: $(this).attr("id")
                                },
                                url: "http://10.16.31.168:8080/search/remove",
                                timeout: 3000,
                                success: function (data) {
                                    alert("삭제했습니다!");
                                }
                            });
                        }
                    });

                    ul.append(listItem);
                }
                $("#result").listview("refresh");
            },
            error : function() {

            },
            complete : function() {

            }
        }
    );
});