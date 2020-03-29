/**
 *
 */
$(function(){
    var path = $("#path").val();

    $(".viewProject").on("click",function(){
        var projectId= $(this).attr("projectId");
        var obj = $(this);
        window.location.href=path+"/sys/resultlist/list/"+ obj.attr("projectId");
    });


    $(".addResult").on("click",function(){
        var obj = $(this);
        window.location.href=path+"/sys/resultlist/liststudent/"+ obj.attr("projectId");
    });

});




