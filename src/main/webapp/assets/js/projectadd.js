var isCompany = null;
var projectTitle = null;
var period = null;
var projectContent = null;
var projectPrice = null;
var projectAddress = null;

var addBtn = null;
var backBtn = null;

var path;

$(function(){
    isCompany = $("#isCompany");
    projectTitle = $("#projectTitle");
    period = $("#period");
    projectContent = $("#projectContent");
    projectPrice = $("#projectPrice");
    projectAddress = $("#projectAddress");

    projectTitle.next().html("*");
    projectTitle.next().html("*");
    period.next().html("*");//next() 方法返回被选元素的后一个同级元素。 这里应该是input标签
    projectContent.next().html("*");
    projectPrice.next().html("*");
    projectAddress.next().html("*");

    addBtn = $("#add");
    backBtn = $("#back");



    projectTitle.bind("blur",function(){
        //ajax后台验证--projectTitle是否已存在
        $.ajax({
            type:"GET",//请求类型
            url:path+"/sys/projectlist/projectexist.json",//请求的url
            data:{projectTitle:projectTitle.val()},//请求参数
            dataType:"json",//ajax接口（请求url）返回的数据类型
            success:function(data){//data：返回数据（json对象）
                if(data.projectTitle == "exist"){//账号已存在，错误提示
                    validateTip(projectTitle.next(),{"color":"red"},imgNo+ " 该实训项目已存在！",false);
                }else{//账号可用，正确提示
                    validateTip(projectTitle.next(),{"color":"green"},imgYes+" 该实训项目可以使用！",true);
                }
            },
            error:function(data){//当访问时候，404，500 等非200的错误状态码
                validateTip(projectTitle.next(),{"color":"red"},imgNo+" 您访问的页面不存在",false);
            }
        });

    }).bind("focus",function(){
        //显示友情提
        validateTip(projectTitle.next(),{"color":"#666666"},"* ",false);
    }).focus();


    isCompany.bind("focus",function(){
        console.log("dsd")
        validateTip(isCompany.next(),{"color":"#666666"},"* ",false);
    }).bind("blur",function(){

        validateTip(isCompany.next(),{"color":"green"},imgYes,true);
    });

    projectTitle.bind("focus",function(){
        console.log("dsd")
        validateTip(projectTitle.next(),{"color":"#666666"},"* ",false);
    }).bind("blur",function(){

        validateTip(projectTitle.next(),{"color":"green"},imgYes,true);
    });

    period.bind("focus",function(){
        console.log("dsd")
        validateTip(period.next(),{"color":"#666666"},"* ",false);
    }).bind("blur",function(){

        validateTip(period.next(),{"color":"green"},imgYes,true);

    });

    projectContent.bind("focus",function(){
        console.log("dsd")
        validateTip(projectContent.next(),{"color":"#666666"},"* ",false);
    }).bind("blur",function(){
        validateTip(projectContent.next(),{"color":"green"},imgYes,true);
    });

    projectAddress.bind("focus",function(){
        console.log("dsd")
        validateTip(projectAddress.next(),{"color":"#666666"},"* ",false);
    }).bind("blur",function(){
        validateTip(projectAddress.next(),{"color":"green"},imgYes,true);

    });

    projectPrice.bind("focus",function(){
        console.log("dsd")
        validateTip(projectPrice.next(),{"color":"#666666"},"* ",false);
    }).bind("blur",function(){

        validateTip(projectPrice.next(),{"color":"green"},imgYes,true);

    });


    addBtn.bind("click",function(){
        if(isCompany.attr("validateStatus")!= "true"){
            isCompany.blur();
        }else if(projectTitle.attr("validateStatus") != "true") {
            projectTitle.blur();
        } else if(period.attr("validateStatus") != "true"){
            period.blur();
        }else if(projectContent.attr("validateStatus") != "true") {
            projectContent.blur();
        }else if(projectAddress.attr("validateStatus") != "true"){
            projectAddress.blur();
        }else if(projectPrice.attr("validateStatus") != "true"){
            projectPrice.blur();
        }
        else{
            if(confirm("是否确认提交数据")){
                $("#projectForm").submit();
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