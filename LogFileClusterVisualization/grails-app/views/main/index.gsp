<!--
  To change this template, choose Tools | Templates
  and open the template in the editor.
-->

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
  <head>
    <meta name="layout" content="homeLayout"/>
    <title>Log file clustering</title>

  <g:javascript src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"/>
  <script type="text/javascript" src="${resource(dir: 'js', file: 'jquery.1.7.1.min.js')}"></script>
  <script type="text/javascript" src="${resource(dir: 'js', file: 'jquery.easing.1.3.js')}"></script>
  <script type="text/javascript" src="${resource(dir: 'js', file: 'jquery.coda-slider-2.0.js')}"></script>
  <script type="text/javascript">
$(function () {
    var chart;
    $(document).ready(function() {
        chart = new Highcharts.Chart({
            chart: {
                renderTo: 'container',
                plotBackgroundColor: null,
                plotBorderWidth: null,
                plotShadow: false
            },
            title: {
                text: 'Log file clustering and visulization'
            },
            tooltip: {
                formatter: function() {
                    return '<b>'+ this.point.name +'</b>: '+ this.percentage +' %';
                }
            },
            plotOptions: {
                pie: {
                    allowPointSelect: true,
                    cursor: 'pointer',
                    dataLabels: {
                        enabled: true,
                        color: '#000000',
                        connectorColor: '#000000',
                        formatter: function() {
                            return '<b>'+ this.point.name +'</b>: '+ this.percentage +' %';
                        }
                    }
                }
            },
            series:${slusterInfo}
//            series: [{
//                type: 'pie',
//                name: 'log file counter',
//                data: [
//                    ['Cluster-1',   45.0],
//                    ['Cluster-2',       26.8],
//                    {
//                        name: 'Cluster-3',
//                        y: 12.8,
//                        sliced: true,
//                        selected: true
//                    },
//                    ['Cluster-4',    8.5],
//                    ['Cluster-5',     6.2],
//                    ['Cluster-6',   0.7],
//                    ['Cluster-7',   0.8]
//                ]
//            }]
        });
    });
    
});
		</script>
</head>
<body>
<script src="${resource(dir: 'js', file: 'highcharts.js')}"></script>
<script src="${resource(dir: 'js/modules', file: 'exporting.js')}"></script>
<div id="container" style="min-width: 400px; height: 400px; margin: 0 auto"></div>

</body>
</html>
