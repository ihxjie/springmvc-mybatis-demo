var testsObj;

//用户管理页面上点击删除按钮弹出删除框(testslist.jsp)
$(function(){
    var path = $("#path").val();
    var path1 = $("#path1").val();
    $(".viewApply").on("click",function(){
        var applyId= $(this).attr("applyId");
        var obj = $(this);
        window.location.href=path+"/sys/applyList/view/"+ obj.attr("applyId");

    });

    $(".modifyApply").on("click",function(){
        var applyId= $(this).attr("applyId");
        var obj = $(this);
        window.location.href=path+"/sys/applyList/modify/"+ obj.attr("applyId");
    });
    $('#no').click(function () {
        cancleBtn();
    });

    $('#yes').click(function () {
        console.log(testsObj);
        deleteStudent(testsObj);
    });

});
