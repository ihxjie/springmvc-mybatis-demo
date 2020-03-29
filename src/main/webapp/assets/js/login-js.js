
var domainUrl;

$(document).ready(function () {
    domainUrl = $("#domainUrl").val();
    var info = $("#info").val();
    if (info == "failed"){
        alert(info)
    }

});
function teacher_login() {
    var newUrl = domainUrl + "/teacher_validate";
    $("#login_form").attr("action", newUrl);
    $("#login_form").submit()
}