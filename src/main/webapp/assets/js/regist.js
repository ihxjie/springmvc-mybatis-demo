
var studentId = null;
var studentPwd= null;
var studentName= null;
var studentSex = null;
var studentMajor= null;
var studentClass = null;
var studentTel = null;
var studentEmail = null;
var addBtn = null;
var backBtn = null;



$(function(){
    studentId= $("#studentId");
    studentPwd = $("#studentPwd");
    studentName = $("#studentName");
    studentSex = $("#studentSex");
    studentMajor = $("#studentMajor");
    studentClass= $("#studentClass");
    studentTel = $("#studentTel");
    studentEmail  = $("#studentEmail");

    studentId.next().html("*");//next() 方法返回被选元素的后一个同级元素。 这里应该是input标签
    studentPwd.next().html("*");
    studentName.next().html("*");
    studentSex.next().html("*");
    studentMajor.next().html("*");
    studentClass.next().html("*");
    studentTel.next().html("*");
    studentEmail .next().html("*");
    addBtn = $("#regist");
    backBtn = $("#back");
    /*
     * 验证
     * 失焦\获焦
     * jquery的方法传递
     */
    studentId.bind("blur",function(){
        //ajax后台验证--userCode是否已存在
        $.ajax({
            type:"GET",//请求类型
            url:path+"/sys/studentList/csexist.json",//请求的url
            data:{studentId:studentId.val()},//请求参数
            dataType:"json",//ajax接口（请求url）返回的数据类型
            success:function(data){//data：返回数据（json对象）
                if(data.studentId== "exist"){//账号已存在，错误提示
                    validateTip(studentId.next(),{"color":"red"},imgNo+ " 该账号已存在",false);
                }else{//账号可用，正确提示
                    validateTip(studentId.next(),{"color":"green"},imgYes+" 该账号可以使用",true);
                }
            },
            error:function(data){//当访问时候，404，500 等非200的错误状态码
                validateTip(studentId.next(),{"color":"red"},imgNo+" 您访问的页面不存在",false);
            }
        });
    }).bind("focus",function(){
        //显示友情提
        validateTip(studentId.next(),{"color":"#666666"},"* ",false);
    }).focus();

    //邮箱验证
    studentEmail.bind("blur",function(){
        //ajax后台验证--userCode是否已存在
        $.ajax({
            type:"GET",//请求类型
            url:path+"/sys/studentList/csexistEmail.json",//请求的url
            data:{studentEmail:studentEmail.val()},//请求参数
            dataType:"json",//ajax接口（请求url）返回的数据类型
            success:function(data){//data：返回数据（json对象）
                if(data.studentEmail== "exist"){//账号已存在，错误提示
                    validateTip(studentEmail.next(),{"color":"red"},imgNo+ " 该邮箱已注册",false);
                }else{//账号可用，正确提示
                    validateTip(studentEmail.next(),{"color":"green"},imgYes+" 该邮箱还没有注册",true);
                }
            },
            error:function(data){//当访问时候，404，500 等非200的错误状态码
                validateTip(studentEmail.next(),{"color":"red"},imgNo+" 您访问的页面不存在",false);
            }
        });
    }).bind("focus",function(){
        //显示友情提
        validateTip(studentEmail.next(),{"color":"#666666"},"* ",false);
    }).focus();


    addBtn.bind("click",function(){
        if(studentId.attr("validateStatus") != "true"){
            studentId.blur();
        }else if(studentPwd.attr("validateStatus") != "true"){
            studentPwd.blur();
        }else if(studentName.attr("validateStatus") != "true"){
            studentName.blur();
        }else if(studentSex.attr("validateStatus") != "true"){
            studentSex.blur();
        }else if(studentMajor.attr("validateStatus") != "true"){
            studentMajor.blur();
        }else if(studentClass.attr("validateStatus") != "true"){
            studentClass.blur();
        }else if(studentTel.attr("validateStatus") != "true") {
            studentTel.blur();
        }else if(studentEmail.attr("validateStatus") != "true") {
            studentEmail.blur();
        }
        else{
            if(confirm("是否确认提交数据")){
                $("#courseForm").submit();
            }
        }
    });

    backBtn.on("click",function(){
        if(referer != undefined
            && null != referer
            && "" != referer
            && "null" != referer
            && referer.length > 4){
            window.location.href = referer;
        }else{
            history.back(-1);
        }

    });

});