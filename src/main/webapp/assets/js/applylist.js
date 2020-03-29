var enrollObj;

//用户管理页面上点击删除按钮弹出删除框(enrolllist.jsp)
function deleteEnroll(obj){
    $.ajax({
        type:"GET",
        url:path+"/sys/enrolllist/delenroll.json",
        data:{eno:obj.attr("eno")},
        dataType:"json",
        success:function(data){
            console.log(data);
            if(data.delResult == "true"){//删除成功：移除删除行
                cancleBtn();
                obj.parents("tr").remove();
            }else if(data.delResult == "false"){//删除失败
                //alert("对不起，删除用户【"+obj.attr("username")+"】失败");
                changeDLGContent("对不起，删除【"+obj.attr("sname")+"】学生的报名失败");
            }else if(data.delResult == "notexist"){
                //alert("对不起，用户【"+obj.attr("username")+"】不存在");
                changeDLGContent("对不起，学生【"+obj.attr("sname")+"】的报名不存在");
            }
        },
        error:function(data){
            //alert("对不起，删除失败");
            changeDLGContent("对不起，删除失败");
        }
    });
}




$(".addGrade").on("click",function(){
    var obj = $(this);
    window.location.href=path+"/sys/gradelist/add/"+ obj.attr("eno");
});

function openYesOrNoDLG(){
    $('.zhezhao').css('display', 'block');
    $('#removeEnroll').fadeIn();
}

function cancleBtn(){
    $('.zhezhao').css('display', 'none');
    $('#removeEnroll').fadeOut();
}
function changeDLGContent(contentStr){
    var p = $(".removeMain").find("p");
    p.html(contentStr);
}

$(function(){
    //通过jquery的class选择器（数组）
    //对每个class为viewUser的元素进行动作绑定（click）
    /**
     * bind、live、delegate
     * on
     */
    $(".viewEnroll").on("click",function(){
        //将被绑定的元素（a）转换成jquery对象，可以使用jquery方法
        var obj = $(this);
        window.location.href=path+"/sys/enrolllist/view/"+ obj.attr("eno");
    });





    $('#no').click(function () {
        cancleBtn();
    });

    $('#yes').click(function () {
        console.log(enrollObj);
        deleteEnroll(enrollObj);
    });


    $(".deleteEnroll").on("click",function(){
        enrollObj = $(this);
        console.log(enrollObj);
        changeDLGContent("你确定要删除学生【"+enrollObj.attr("sname")+"】的报名吗？");
        openYesOrNoDLG();
    });

});



var DownloadBtn=null;
$(function(){


    DownloadBtn= $("#download");




    DownloadBtn.bind("click",function(){
        if(confirm("是否确认导出数据")){
            $("#excelForm").submit();
        }
    });


});