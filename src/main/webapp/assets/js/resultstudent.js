
$(".addResult").on("click",function(){
    var path = $("#path").val();
    var personId= $(this).attr("personId");
    var obj = $(this);
    window.location.href=path+"/sys/resultlist/add/"+ obj.attr("personId");

});