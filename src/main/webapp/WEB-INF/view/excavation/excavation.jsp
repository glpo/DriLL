<%@ include file="header.jsp" %>

<script type="text/javascript">
    $(document).ready(function() {
        $("#test").click(function(){
            $.get("/drill/getexc",function(data,status){

                var rows = '';

                $.each(data, function(index, val) {
                    rows += val.time + ' ' + val.exc;
                });

                $("#result_text").text(rows);
            });
        });
    });

   $(function() {

   		// We use an inline data source in the example, usually data would
   		// be fetched from a server

   		var data = [],
   			totalPoints = 300;

   		function getRandomData() {

   			if (data.length > 0)
   				data = data.slice(1);

   			// Do a random walk

   			while (data.length < totalPoints) {

   				var prev = data.length > 0 ? data[data.length - 1] : 50,
   					y = prev + Math.random() * 10 - 5;

   				if (y < 0) {
   					y = 0;
   				} else if (y > 100) {
   					y = 100;
   				}

   				data.push(y);
   			}

   			// Zip the generated y values with the x values

   			var res = [];
   			for (var i = 0; i < data.length; ++i) {
   				res.push([i, data[i]])
   			}

   			return res;
   		}

   		// Set up the control widget

   		var updateInterval = 30;
   		/*$("#updateInterval").val(updateInterval).change(function () {
   			var v = $(this).val();
   			if (v && !isNaN(+v)) {
   				updateInterval = +v;
   				if (updateInterval < 1) {
   					updateInterval = 1;
   				} else if (updateInterval > 2000) {
   					updateInterval = 2000;
   				}
   				$(this).val("" + updateInterval);
   			}
   		}); */

   		var plot = $.plot("#placeholder", [ getRandomData() ], {
   			series: {
   				shadowSize: 0	// Drawing is faster without shadows
   			},
   			yaxis: {
   				min: 0,
   				max: 100
   			},
   			xaxis: {
   				show: false
   			}
   		});

   		function update() {
   			plot.setData([getRandomData()]);
  			plot.draw();
   			setTimeout(update, updateInterval);
   		}

   		update();
   	});
</script>

 <div class="row">
    <div class="col-lg-12">
               <h1 class="page-header">Excavation History</h1>
    </div>
    <!-- /.col-lg-12 -->
 </div>
<!-- /.row -->

<button id="test">Load</button>
<p id="result_text"></p>

<div id="placeholder"></div>


<%@ include file="footer.jsp" %>