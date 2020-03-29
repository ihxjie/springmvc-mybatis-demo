var testsObj;

//用户管理页面上点击删除按钮弹出删除框(testslist.jsp)
$(function(){
    var path = $("#path").val();

    $(".viewProject").on("click",function(){
        var projectId= $(this).attr("projectId");
        var obj = $(this);
        window.location.href=path+"/sys/projectlist/view/"+ obj.attr("projectId");

    });

    $(".modifyProject").on("click",function(){
        var projectId= $(this).attr("projectId");
        var obj = $(this);
        window.location.href=path+"/sys/projectlist/modify/"+ obj.attr("projectId");
    });

    $('#no').click(function () {
        cancleBtn();
    });

    $('#yes').click(function () {
        console.log(testsObj);
        deleteProject(testsObj);
    });

    $(".deleteProject").on("click",function(){
        testsObj = $(this);
        var projectId= $(this).attr("projectId");
        var _this = $(this).parent().parent().parent();
        if(confirm("你确定要删除这个项目吗？")){
            $.ajax({
                type:"POST",
                url:path+"/delProject",//请求的url
                data:{"projectId":projectId},//请求参数
                dataType:"json",//ajax接口（请求url）返回的数据类型
                traditional:true,
                success:function(data){//data：返回数据（json对象）
                    if(data){
                        $(_this).remove();
                        alert("删除成功");
                    }
                },
                error:function(data){//当访问时候，404，500 等非200的错误状态码
                    alert("删除失败");
                }
            })
        }
    });
});
