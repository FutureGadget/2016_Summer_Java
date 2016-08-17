var str = new String();
str[0] = $("#apple").text();
str[1] = $("#pineapple").text();
str[2] = $("ul>li.myList").text();
str[3] = $("#uId").attr("id");
str[4] = $("ol>li:first").text();
str[5] = $("ol>li:eq(1)").text();
str[6] = $("ol>li:last").text();

for (var i = 0; i < 7; ++i) {
    console.log(str[i]);
}