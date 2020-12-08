$(function () {
    var myChart = echarts.init(document.getElementById('consumption_chart'));
    var option = {
        title: {
            text: ''
        },
        tooltip: {},
        legend: {
            data: []
        },
        xAxis: {
            data: []
        },
        yAxis: {},
        series: [{
            name: '',
            type: 'bar',
            data: []
        }]
    };

    var now = new Date()
    showStatistic(now.getFullYear(), now.getMonth() + 1)
    showStatisticByYear(now.getFullYear(), now.getFullYear())

    /*
    $.datetimepicker.setLocale('ch');

    $("#date_of_month_year").datetimepicker({
        timepicker: false,
        format: 'Y-m-d',
        onSelectDate: function (dateText, inst) {
            var year = dateText.getFullYear();
            var month = dateText.getMonth() + 1;
            showStatistic(year, month)
        }
    });
  */
    $("#okButton").click(
        function () {
            var year = $("#date_of_year").val();
            var month = $("#date_of_month").val();
            showStatistic(year, month)
        }
    );

    $("#statisticByYearButton").click(function () {
        var year = $("#consumption_year").val();
        showStatisticByYear(year, year)
    });

    function showStatistic(year, month) {
        $.ajax({
            type: "GET",
            contentType: "application/json;charset=UTF-8",
            url: "./monthConsumptionStatistic?year=" + year + "&month=" + month,
            success: function (result) {
                if (result.length > 0) {
                    option.title.text = result[0].month + "月消费统计";
                    for (var i = 0; i < result.length; i++) {
                        option.xAxis.data[i] = result[i].type.name;
                        option.series[0].data[i] = result[i].total;
                    }
                    option.legend.data[0] = "类别"
                    myChart.setOption(option);
                } else {
                    myChart.clear();
                }
                var yearOptions = "";
                var now = new Date();
                var start;
                for (start = now.getFullYear() - 5; start <= now.getFullYear(); start++) {
                    if (start == parseInt(year)) {
                        yearOptions += "<option " + "value= '" + start + "' selected>" + start + "</option>";
                    } else {
                        yearOptions += "<option " + "value= '" + start + "'>" + start + "</option>";
                    }
                }
                $("#date_of_year").html(yearOptions);
                var monthOptions = "";
                for (start = 1; start <= 12; start++) {
                    if (start == parseInt(month)) {
                        monthOptions += "<option " + "value= '" + start + "' selected>" + start + "</option>";
                    } else {
                        monthOptions += "<option " + "value= '" + start + "'>" + start + "</option>";
                    }
                }
                $("#date_of_month").html(monthOptions);
            },
            error: function (error) {
                myChart.clear();
            }
        })
    }

    var yearStatisticChart = echarts.init(document.getElementById('year_consumption_chart'));
    var yearStatisticOption = {
        title: {
            text: ''
        },
        tooltip: {},
        legend: {
            data: []
        },
        xAxis: {
            type: "category",
            data: []
        },
        yAxis: {
            type: "value"
        },
        series: [{
            name: '',
            type: 'line',
            data: []
        }]
    };


    function showStatisticByYear(start, end) {
        $.ajax({
            type: "GET",
            contentType: "application/json;charset=UTF-8",
            url: "./yearConsumptionStatistic?start=" + start + "&end=" + end,
            success: function (result) {
                yearStatisticChart.clear()
                if (result.length > 0) {
                    yearStatisticOption.title.text = start + "年每月统计"
                    for (var i = 0; i < result.length; i++) {
                        yearStatisticOption.xAxis.data[i] = result[i].year + "-" + result[i].month;
                        yearStatisticOption.series[0].data[i] = result[i].total;
                    }
                   yearStatisticChart.setOption(yearStatisticOption)
                } else {
                   yearStatisticChart.clear()
                }
                var now = new Date();
                var begin;
                var yearOptions = ""
                for (begin = now.getFullYear() - 5; begin <= now.getFullYear(); begin++) {
                    if (begin == parseInt(start)) {
                        yearOptions += "<option " + "value= '" + begin + "' selected>" + begin + "</option>";
                    } else {
                        yearOptions += "<option " + "value= '" + begin + "'>" + begin + "</option>";
                    }
                }
                $("#consumption_year").html(yearOptions);
            },
            error: function (error) {
                yearStatisticChart.clear()
            }
        })
    }
});