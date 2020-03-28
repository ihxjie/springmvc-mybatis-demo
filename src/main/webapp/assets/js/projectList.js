var testsObj;

//用户管理页面上点击删除按钮弹出删除框(testslist.jsp)
$(function(){
    var path = $("#path").val();

    $(".viewProject").on("click",function(){
        var projectId= $(this).attr("projectId");
        var obj = $(this);
        window.location.href=path+"/sys/projectList/view/"+ obj.attr("projectId");

    });

    $(".modifyProject").on("click",function(){
        var projectId= $(this).attr("projectId");
        var obj = $(this);
        window.location.href=path+"/sys/projectList/modify/"+ obj.attr("projectId");
    });
    $('#no').click(function () {
        cancleBtn();
    });

    $('#yes').click(function () {
        console.log(testsObj);
        deleteProject(testsObj);
    });



        $(".projectClose").on("click",function(){
            testsObj = $(this);
            var projectId= $(this).attr("projectId");
            if(confirm("你确定要将项目【"+testsObj.attr("projectTitle")+"】审核不通过吗？")){
                $.ajax({
                    type:"POST",
                    url:path+"/Closeproject.json",
                    data:{projectId:testsObj.attr("projectId")},
                    dataType:"json",
                    success:function(data){

                        if(data.result == "true"){

                            window.location.href=path+"/projectList"

                        }else if(data.result=="false"){
                            alert("对不起，下架失败");
                        }

                    }
                });
            }

        });
        $(".projectOpen").on("click",function(){
            testsObj = $(this);
            var projectId= $(this).attr("projectId");
            if(confirm("你确定要将项目【"+testsObj.attr("projectTitle")+"】审核通过吗？")){

                    $.ajax({
                        type:"POST",
                        url:path+"/Openproject.json",
                        data:{projectId:testsObj.attr("projectId")},
                        dataType:"json",
                        success:function(data){

                            if(data.result == "true"){//删除成功：移除删除行

                                window.location.href=path+"/projectList"

                            }else if(data.result=="false"){
                                alert("对不起，上架失败");
                            }

                        }
                    });

            }

        });
    $(".projectRefuse").on("click",function(){
        testsObj = $(this);
        var projectId= $(this).attr("projectId");
        if(confirm("你确定要将项目【"+testsObj.attr("projectTitle")+"】审核通过吗？")){

            $.ajax({
                type:"POST",
                url:path+"/Juproject.json",
                data:{projectId:testsObj.attr("projectId")},
                dataType:"json",
                success:function(data){

                    if(data.result == "true"){//删除成功：移除删除行

                        window.location.href=path+"/projectList"

                    }else if(data.result=="false"){
                        alert("对不起，上架失败");
                    }

                }
            });

        }

    });
});
