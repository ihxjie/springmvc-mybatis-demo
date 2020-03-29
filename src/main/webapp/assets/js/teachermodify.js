var testsObj;
//用户管理页面上点击删除按钮弹出删除框(testslist.jsp)
$(function(){
    var wpath = $("#wpath").val();
    $(".updateTeacher").on("click",function(){
        var adminId= $(this).attr("adminId");
        var obj = $(this);
        window.location.href=wpath+"/sys/adminList/modify/"+ obj.attr("adminId");
    });
    $('#no').click(function () {
        cancleBtn();
    });

    $('#yes').click(function () {
        console.log(testsObj);
        deleteStudent(testsObj);
    });


});