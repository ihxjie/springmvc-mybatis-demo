function setTeacher(personId, personName, projectId) {
    $("#teacherName").text(personName);
    $("#teacherId").val(personId);
}
function submit_evaluate() {

    var teacherId = $("#teacherId").val();

    var option1 = $("input[name='option1']:checked").val();
    var option2 = $("input[name='option2']:checked").val();
    var option3 = $("input[name='option3']:checked").val();
    var option4 = $("input[name='option4']:checked").val();
    var option5 = $("input[name='option5']:checked").val();
    var option6 = $("input[name='option6']:checked").val();
    var option7 = $("input[name='option7']:checked").val();
    var option8 = $("input[name='option8']:checked").val();


    if (option1 != undefined && option2 != undefined && option3 != undefined && option4 != undefined
        && option5 != undefined && option6 != undefined && option7 != undefined && option8 != undefined){
        $.ajax({
            url:"single_evaluate",
            type:"post",
            data:{teacherId:teacherId,option1:option1,option2:option2,option3:option3,option4:option4,option5:option5,
                option6:option6,option7:option7,option8:option8},
            success:function (data) {
                alert(data)
            }
        })
    }else {
        alert("请检查选项是否全部选中");
    }



}