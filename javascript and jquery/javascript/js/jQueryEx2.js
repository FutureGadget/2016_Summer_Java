function myFunc() {
    var sel = $("select>option:selected").text();
    $("[type=text]").val(sel);
}