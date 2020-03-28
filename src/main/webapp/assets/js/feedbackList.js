var testsObj;

//用户管理页面上点击删除按钮弹出删除框(testslist.jsp)
$(function(){
    var path = $("#path").val();
    $(".viewFeedback").on("click",function(){
        var teacherId= $(this).attr("teacherId");
        var obj = $(this);
        window.location.href=path+"/sys/feedbackList/view/"+ obj.attr("teacherId");

    });
});