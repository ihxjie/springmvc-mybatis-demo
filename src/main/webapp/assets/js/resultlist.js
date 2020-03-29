$(function() {


    var path = $("#path").val();
    $(".viewResult").on("click", function () {
        var resultId= $(this).attr("resultId");
        var obj = $(this);
        window.location.href = path + "/sys/resultlist/view/" + obj.attr("resultId");
    });

});