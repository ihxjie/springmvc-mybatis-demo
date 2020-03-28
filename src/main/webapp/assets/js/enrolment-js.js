var pageNum = 1;
var pageSize = 5;
var keyword = "";

$(document).ready(function(){

    var info = $("#info").val();
    if (info == "未有老师报名，无法评价"){
        alert(info);
    }

    $("#pageSize").change(function () {
        pageSize = $(this).val();
        getApply();
    });
    $("#search-box").on('input',function () {
        keyword = $(this).val();
        getApply();
    });

    getApply();

});
function getNextPage() {
    pageNum += 1;
    getApply();
}
function getPreviousPage() {
    pageNum -= 1;
    getApply();
}

function getApply() {
    $.ajax({
        url:"apply/getApply",
        type:"get",
        dataType:"json",
        data:{pageNum:pageNum,pageSize:pageSize,keyword:keyword},
        contentType : "application/json;charset=utf-8",
        success:function (data) {

            var list = data.list;
            var thead = $("#dataTable").children("thead");
            var tbody = $("#dataTable").children("tbody");

            var theadHtml = "";

            theadHtml += "<tr><th>" + "实训项目";
            theadHtml += "</th><th>" + "申请人ID";
            theadHtml += "</th><th>" + "申请人姓名";
            theadHtml += "</th><th>" + "详情/缴费";
            theadHtml += "</th><th>" + "退选";
            theadHtml += "</th><th>" + "评价";
            theadHtml += "</th></tr>";

            var tbodyHtml = "";
            $.each(list,function (idx,obj) {

                tbodyHtml += "<tr><td>" + obj.projectTitle;
                tbodyHtml += "</td><td>" + obj.personId;
                tbodyHtml += "</td><td>" + obj.personName;

                tbodyHtml += "</td><td><a class='btn btn-primary btn-icon-split' role='button' href='payfor/" + obj.applyId +
                    "'><span class='text-white icon'><i class='fas fa-info-circle'></i></span></a>";

                tbodyHtml += "</td><td><a class='btn btn-danger btn-icon-split' role='button' onclick='drop(" + obj.applyId +
                    ")'><span class='text-white icon'><i class='fas fa-trash'></i></span></a>";

                tbodyHtml += "</td><td><a class='btn btn-info btn-icon-split' role='button' href='teacher_evaluate?applyId=" + obj.applyId +
                    "'><span class='text-white icon'><i class='fas fa-check'></i></span></a>";

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
function drop(applyId) {
    $.ajax({
        url:"drop",
        type:"get",
        data:{applyId:applyId},
        contentType : "application/json;charset=utf-8",
        success:function (data) {
            alert(data);
            getApply();
        }
    })

}