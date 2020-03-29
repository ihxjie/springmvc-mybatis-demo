$(function(){

    var path = $("#path").val();

    $(".viewProject").on("click",function(){
        var projectId= $(this).attr("projectId");
        var obj = $(this);
        window.location.href=path+"/sys/applylist/list/"+ obj.attr("projectId");
    });


});

