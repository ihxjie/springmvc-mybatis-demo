

$(function() {
    var path = $("#path").val();

    $(".viewTeacher").on("click", function () {
        var teacherId = $(this).attr("teacherId");
        var obj = $(this);
        window.location.href = path + "/sys/teacherlist/view/" + obj.attr("teacherId");

    });
});
