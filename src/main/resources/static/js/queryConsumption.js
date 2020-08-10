$(function () {
    $("#start_date").datetimepicker({
        timepicker: false,
        format: 'Y-m-d'
    });

    $("#end_date").datetimepicker({
        timepicker: false,
        format: 'Y-m-d'
    });

    $("#query").click(function () {
        $("form:first").submit();
    })
});