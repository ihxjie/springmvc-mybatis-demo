var testsObj;

//用户管理页面上点击删除按钮弹出删除框(testslist.jsp)
$(function(){
    var path = $("#path").val();
    $(".viewCompany").on("click",function(){
        var companyId= $(this).attr("companyId");
        var obj = $(this);
        window.location.href=path+"/sys/companyList/view/"+ obj.attr("companyId");

    });

    $(".modifyCompany").on("click",function(){
        var companyId= $(this).attr("companyId");
        var obj = $(this);
        window.location.href=path+"/sys/companyList/modify/"+ obj.attr("companyId");
    });
    $('#no').click(function () {
        cancleBtn();
    });

    $('#yes').click(function () {
        console.log(testsObj);
        deleteStudent(testsObj);
    });

    $(".deleteCompanyt").on("click",function(){
        testsObj = $(this);
        var companyId= $(this).attr("companyId");
        var _this = $(this).parent().parent().parent();
        if(confirm("你确定要将用户["+testsObj.attr("companyName")+"]删除吗？")){
            $.ajax({
                type:"POST",
                url:path+"/delCompany",//请求的url
                data:{"companyId":companyId},//请求参数
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
        //changeDLGContent("你确定要删除学生【"+testsObj.attr("studentName")+"】吗？");
        //openYesOrNoDLG();
    });
});
