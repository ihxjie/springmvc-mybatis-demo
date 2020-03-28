var testsObj;

//用户管理页面上点击删除按钮弹出删除框(testslist.jsp)
$(function(){
    var path = $("#path").val();
    $(".viewResult").on("click",function(){
        var studentId= $(this).attr("studentId");
        var obj = $(this);
        window.location.href=path+"/sys/resultList/view/"+ obj.attr("studentId");

    });

    $(".modifyResult").on("click",function(){
        var studentId= $(this).attr("studentId");
        var obj = $(this);
        window.location.href=path+"/sys/resultList/modify/"+ obj.attr("studentId");
    });
    $('#no').click(function () {
        cancleBtn();
    });

    $('#yes').click(function () {
        console.log(testsObj);
        deleteStudent(testsObj);
    });

});
