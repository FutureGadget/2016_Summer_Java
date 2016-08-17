function myFunc() {
    // 1. All Selector
    // $("*").css("color", "red");

    // 2. Tag selector
    // $("h1").css("color", "blue");

    // 3. 아이디 선택자
    // $("#dog").css("color", "green");

    // 5-1. Descendants
    // $("div *").css("color", "red");

    // 5-2. Siblings
    // $("#dog + li").css("color", "red");

    // 5-3. 직계후손
    // $("div > ul").css("color", "yellow");

    // 6. 속성 선택자
    // $("[type=button]").css("color", "red");

    // 값 가져오는 방법들
    // Tag 사이의 값 가져오기
    console.log($("#dog").text());

    // input text 가져오기
    console.log($("#myInput").val());
}