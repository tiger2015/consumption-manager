$(function () {

    $("#selectedAll").change(function () {
        if (this.checked) {
            $("input[type=checkbox]").prop("checked", true)
        } else {
            $("input[type=checkbox]").prop("checked", false)
        }
    })

    $("#deleteAll").click(function () {
        var selectedIds = $("input[name=recordIds]:checkbox:checked");
        if (selectedIds.length === 0) {
            alert("请选择要删除的记录");
            return;
        }
        var ids = "";
        for (var i = 0; i < selectedIds.length; i++) {
            ids += selectedIds[i].value;
            if (i !== selectedIds.length - 1)
                ids += ",";
        }
        var page = $("#page").attr("value");
        console.log(ids);
        window.location.href = "./delete?id=" + ids + "&page=" + page;
    });

    $("#next_page").click(function () {
        var start_time = $("#start_date").attr("value");
        console.log(start_time)
        var end_time = $("#end_date").attr("value");
        console.log(end_time)
        var consumptionType = $("select[name='consumptionType.id'] option:selected").val();
        console.log(consumptionType)
        var payType = $("select[name='payType.id'] option:selected").val();
        console.log(payType)
        // 提交表单
        var page = $("#page").attr("value");
        var pageNum = parseInt(page)
        $("#page").attr("value", parseInt(page) + 1);
        console.log(page)
        $("form:first").submit();
    });

    $("#prev_page").click(function () {
        var page = $("#page").attr("value");
        console.log("page:"+page)
        $("#page").attr("value", parseInt(page) - 1);
        $("form:first").submit();
    });
});