var backBtn = null;

$(function(){
    backBtn = $("#back");
    backBtn.on("click",function(){
        //alert("view : "+referer);
        if(referer != undefined
            && null != referer
            && "" != referer
            && "null" != referer
            && referer.length > 4){
            window.location.href = referer;
        }else{
            history.back(-1);
        }
    });
});

$(function() {
    var path = $("#path").val();

    $(".viewTeacher").on("click", function () {
        var teacherId = $(this).attr("teacherId");
        var obj = $(this);
        window.location.href = path + "/sys/teacherlist/view/" + obj.attr("teacherId");

    });
});
