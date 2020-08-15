$(function () {
    var myChart = echarts.init(document.getElementById('consumption_chart'));
    var option = {
        title: {
            text: ''
        },
        tooltip: {},
        legend: {
            data:[]
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
    showStatistic(now.getFullYear(), now.getMonth()+1)

    $.datetimepicker.setLocale('ch');

    $("#date_of_month_year").datetimepicker({
        timepicker: false,
        format: 'Y-m-d',
        onSelectDate: function(dateText, inst) {
            var year = dateText.getFullYear();
            var month = dateText.getMonth() + 1;
            showStatistic(year, month)
        }
    });

    function showStatistic(year, month) {
        $.ajax({
            type: "GET",
            contentType:"application/json;charset=UTF-8",
            url: "./monthConsumptionStatistic?year="+year+"&month="+month,
            success: function (result) {
                if(result.length > 0){
                    option.title.text=result[0].month+"月消费统计";
                    for(var i=0;i < result.length; i++){
                        option.xAxis.data[i] = result[i].type.name;
                        option.series[0].data[i] = result[i].total;
                    }
                    option.legend.data[0]="类别"
                    myChart.setOption(option);
                }else {
                    myChart.clear();
                }
            },
            error: function (error) {
                myChart.clear();
            }
        })
    }
})