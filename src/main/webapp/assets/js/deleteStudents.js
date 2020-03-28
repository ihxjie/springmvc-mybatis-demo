$(function(){
    var path = $("#path").val();
    $("body").delegate("#delAllStudent","click",function(){
        var arr = [];
        $("input[type='checkbox']").each(function (a, b) {
            if ($(this).is(":checked")) {
                var id = $(b).parent().children(".id").html();
                arr.push(id)
            }
        });
        console.log(arr);
        $.ajax({
            type:"POST",//请求类型
            url:path+"/delStudents",//请求的url
            data:{"list":arr},//请求参数
            dataType:"json",//ajax接口（请求url）返回的数据类型
            traditional:true,
            success:function(data){//data：返回数据（json对象）
                if(data){
                    alert("删除成功");
                    $("input[type='checkbox']").each(function (a, b) {
                        if ($(this).is(":checked")) {
                            var id = $(b).parent().parent().remove();
                        }
                    });
                }
            },
            error:function(data){//当访问时候，404，500 等非200的错误状态码
                alert("删除失败");
            }
        });
    })
});