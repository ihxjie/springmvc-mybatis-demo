var addBtn = null;
var backBtn = null;

$(function(){
    projectId= $("#projectId");
    personId = $("#personId");
    personName = $("#personName");
    result = $("#result");

    addBtn = $("#add");
    backBtn = $("#back");

    addBtn.bind("click",function(){
        if(confirm("是否确认提交数据")){
            $("#resultForm").submit();
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


