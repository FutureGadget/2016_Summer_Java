function myFunc() {
    $("h1").addClass("myStyle");
    // 속성을 제어할 때 사용하는 method

    if ($("#myBtn").attr("disabled") == "disabled") {
        $("#myBtn").removeAttr("disabled");
    } else {
        $("#myBtn").attr("disabled", "disabled");
    }

    // $("h2").remove(); // 자신과 자식들을 모두 remove.

    // 후손만 없애려면?
    // $("div").empty();

    // html element 만들어서 붙이려면?
    var h1 = $("<h1></h1>").text("소리없는 아우성");
    // 1. 자식으로 마지막에 붙일 때
    // $("div").append(h1);

    // 2. 자식으로 처음에 붙일 때
    // $("div").prepend(h1);

    // 3. 형제로 앞에 붙일 때
    // $("div h2").before(h1);

    // 4. 형제로 뒤에 붙일 때
    // $("div h2").after(h1);
}