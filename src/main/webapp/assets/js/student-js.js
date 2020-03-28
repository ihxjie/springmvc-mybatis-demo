$(document).ready(function () {

    $.ajax({
        url:"getStudentInfo",
        type:"get",
        dataType:"json",
        contentType : "application/json;charset=utf-8",
        success:function (data) {
            $("#username").val(data.studentId);
            $("#email").val(data.studentEmail);
            $("#tel").val(data.studentTel);
            $("#sex").val(data.studentSex);
            $("#name").val(data.studentName);
            $("#major").val(data.studentMajor);
            $("#class").val(data.studentClass);

        }
    });

    var gradeSection = $("#grade-section");
    var gradeHtml = "";

    $.ajax({
        url: "getStudentResult",
        type: "get",
        dataType: "json",
        contentType: "application/json;charset=utf-8",
        success:function (data) {
            $.each(data,function (idx,obj) {

                gradeHtml += "<h4 class='small font-weight-bold'>" + obj.projectTitle;
                gradeHtml += "<span class='float-right'>" + obj.result + "分";
                gradeHtml += "</span></h4><div class='progress progress-xl mb-3'>";

                if (obj.result < 60){
                    gradeHtml += "<div class='progress-bar bg-danger' aria-valuenow='" + obj.result;
                }else if (obj.result >=60 && obj.result < 80){
                    gradeHtml += "<div class='progress-bar bg-warning' aria-valuenow='" + obj.result;
                }else if (obj.result >=80 && obj.result < 100){
                    gradeHtml += "<div class='progress-bar bg-info' aria-valuenow='" + obj.result;
                }else{
                    gradeHtml += "<div class='progress-bar bg-success' aria-valuenow='" + obj.result;
                }
                gradeHtml += "' aria-valuemin='0' aria-valuemax='100' style='width: " + obj.result;
                gradeHtml += "%;'><span class='sr-only'>" + obj.result;
                gradeHtml += "%</span></div></div>";
            });
            gradeSection.html(gradeHtml);

        }
    })
});