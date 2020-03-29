var oldteacherPwd = null;
var newteacherPwd = null;
var rnewteacherPwd = null;
var saveBtn = null;
var path
$(function(){
    oldteacherPwd = $("#oldteacherPwd");
    newteacherPwd = $("#newteacherPwd");
    rnewteacherPwd = $("#rnewteacherPwd");
    saveBtn = $("#save");
    path=$("#path");
    oldteacherPwd.next().html("*");
    newteacherPwd.next().html("*");
    rnewteacherPwd.next().html("*");

    oldteacherPwd.on("blur",function(){
        ///ert("ssss")
        $.ajax({
            type:"POST",
            url:$("#path").val()+"/sys/teacherlist/updatepwd.json",
            data:{oldteacherPwd:oldteacherPwd.val()},
            dataType:"json",
            success:function(data){
                alert(data.result);
                if(data.result == "true"){//旧密码正确
                    validateTip(oldteacherPwd.next(),{"color":"green"},"旧密码正确",true);
                }else if(data.result == "false"){//旧密码输入不正确
                    validateTip(oldteacherPwd.next(),{"color":"red"}, " 原密码输入不正确",false);
                }else if(data.result == "sessionerror"){//当前用户session过期，请重新登录
                    validateTip(oldteacherPwd.next(),{"color":"red"}," 当前用户session过期，请重新登录",false);
                }else if(data.result == "error"){//旧密码输入为空
                    validateTip(oldteacherPwd.next(),{"color":"red"}, " 请输入旧密码",false);
                }
            },
            error:function(data){
                //请求出错
                validateTip(oldteacherPwd.next(),{"color":"red"}," 请求错误",false);
            }
        });

    }).on("focus",function(){
        validateTip(oldteacherPwd.next(),{"color":"#666666"},"* 请输入原密码",false);
    });

    newteacherPwd.on("focus",function(){
        validateTip(newteacherPwd.next(),{"color":"#666666"},"* 密码长度必须是大于2小于20",false);
    }).on("blur",function(){
        if(newteacherPwd.val() != null && newteacherPwd.val().length >= 2
            && newteacherPwd.val().length < 20 ){
            validateTip(newteacherPwd.next(),{"color":"green"},"密码正确",true);
        }else{
            validateTip(newteacherPwd.next(),{"color":"red"}," 密码输入不符合规范，请重新输入",false);
        }
    });


    rnewteacherPwd.on("focus",function(){
        validateTip(rnewteacherPwd.next(),{"color":"#666666"},"* 请输入与上面一致的密码",false);
    }).on("blur",function(){
        if(rnewteacherPwdd.val() != null && rnewteacherPwdd.val().length >= 2
            && rnewteacherPwd.val().length < 20 && newteacherPwd.val() == rnewteacherPwd.val()){
            validateTip(rnewteacherPwd.next(),{"color":"green"},"两次密码输入一致",true);
        }else{
            validateTip(rnewteacherPwd.next(),{"color":"red"}, " 两次密码输入不一致，请重新输入",false);
        }
    });


    saveBtn.on("click",function(){
        oldteacherPwd.blur();
        newteacherPwd.blur();
        rnewteacherPwd.blur();
        if(oldteacherPwd.attr("validateStatus") == "true"
            && newteacherPwd.attr("validateStatus") == "true"
            && rnewteacherPwd.attr("validateStatus") == "true"){
            if(confirm("确定要修改密码？")){
                $("#teacherForm").submit();
            }
        }

    });
});