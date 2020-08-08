$(function () {

    $("#add_menu").click(function () {
        window.location.href="./listAllTypes?target=addConsumptionRecord"
    });

    $("#statistic_menu").click(function () {
        window.location.href="./listAllTypes?target=statisticConsumption"
    });

    $("#query_menu").click(function () {
        // 提交post请求进行url跳转
        var form = $("<form>");
        form.attr("style","display:none")
        form.attr("action","./listAll")
        form.attr("method","post")
        $('body').append(form)
        form.submit();
    });
})