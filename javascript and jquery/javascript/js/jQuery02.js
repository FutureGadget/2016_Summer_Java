function submit() {
    var str = $("[type=checkbox]:checked + span").text();
    console.log(str);
}

// 위 처럼 하면 한 묶음으로 나옴. 각각 처리하려면 ?

function submit_each() {
    $("[type=checkbox]:checked + span").each(function (idx, item){
        // text() 는 jQuery의 메소드이고 item은 자바스크립트 객체이므로 $(객체) 를 통해 jquery객체로 변환해주어야 한다.
        console.log($(item).text() + " 이/가 선택되었습니다.");
    });
}