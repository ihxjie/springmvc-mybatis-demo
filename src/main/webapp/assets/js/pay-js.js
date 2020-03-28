function pay(applyId, price) {

    var domainUrl = $("#domainUrl").val();

    if (price == 0){
        alert("没有费用，无需缴费");
    }else {
        $.ajax({
            url:domainUrl + "/pay",
            type: "get",
            data: {applyId:applyId},
            contentType : "application/json;charset=utf-8",
            success:function (data) {
                alert(data);
            }
        })
    }
}