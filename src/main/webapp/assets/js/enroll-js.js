var pageNum = 1;
var pageSize = 5;
var keyword = "";

$(document).ready(function(){

    $("#pageSize").change(function () {
        pageSize = $(this).val();
        getProjects();
    });
    $("#search-box").on('input',function () {
        keyword = $(this).val();
        getProjects();
    });

    getProjects();

});
function getNextPage() {
    pageNum += 1;
    getProjects();
}
function getPreviousPage() {
    pageNum -= 1;
    getProjects();
}
function enroll(projectId) {
    $.ajax({
        url: "enrollProject",
        type: "get",
        data: {projectId:projectId},
        contentType : "application/json;charset=utf-8",
        success:function (data) {
            alert(data);
        }
    })

}
function getProjects() {
    $.ajax({
        url:"project/getProjects",
        type:"get",
        dataType:"json",
        data:{pageNum:pageNum,pageSize:pageSize,keyword:keyword},
        contentType : "application/json;charset=utf-8",
        success:function (data) {

            var list = data.list;
            var thead = $("#dataTable").children("thead");
            var tbody = $("#dataTable").children("tbody");

            var theadHtml = "";

            theadHtml += "<tr><th>" + "发布渠道";
            theadHtml += "</th><th>" + "发布人";
            theadHtml += "</th><th>" + "实训周期";
            theadHtml += "</th><th>" + "实训标题";
            theadHtml += "</th><th>" + "实训内容";
            theadHtml += "</th><th>" + "实训地址";
            theadHtml += "</th><th>" + "实训价格";
            theadHtml += "</th><th>" + "报名";
            theadHtml += "</th></tr>";

            var tbodyHtml = "";
            $.each(list,function (idx,obj) {

                if (obj.isCompany == "0"){
                    tbodyHtml += "<tr><td>" + "老师";
                }else{
                    tbodyHtml += "<tr><td>" + "公司";
                }
                tbodyHtml += "</td><td>" + obj.workId;
                tbodyHtml += "</td><td>" + obj.period;
                tbodyHtml += "</td><td>" + obj.projectTitle;
                tbodyHtml += "</td><td>" + obj.projectContent;
                tbodyHtml += "</td><td>" + obj.projectAddress;
                tbodyHtml += "</td><td>" + obj.projectPrice;
                tbodyHtml += "</td><td><a class='btn btn-primary btn-icon-split' role='button' onclick='enroll(" + obj.projectId +
                    ")'><span class='text-white icon'><i class='fas fa-sign-in-alt'></i></span></a>";

                tbodyHtml += "</td></tr>";
            });
            tbody.html(tbodyHtml);
            thead.html(theadHtml);

            $("#page-num").children("a").text(data.pageNum);
            $("#dataTable_info").text("展示了 " + data.startRow + " 到 " + data.endRow + " 条数据，共 " + data.size + " 条");
            if (data.hasPreviousPage){
                $("#previous-page").removeClass("disabled");
            }else {
                $("#previous-page").addClass("disabled");
            }
            if (data.hasNextPage){
                $("#next-page").removeClass("disabled");
            }else {
                $("#next-page").addClass("disabled");
            }
        }
    })
}