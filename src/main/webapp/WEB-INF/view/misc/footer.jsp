   </div>
    <!-- /#wrapper -->

    <script type="text/javascript">

         var options = {
    		series: {
    			shadowSize: 2	// Drawing is faster without shadows
    		},
    		yaxis: {
    			min: 0,
    			max: 100
    		},
    		xaxis: {
    			show: false
    		}
    	 };

		var continueProcess = false;

		data = [[0, 0]];

		var oldData;

    	var plot = $.plot("#placeholder", [data], options);

    		function fetchData() {

				function onDataReceived(series) {
					//var oldData = plot.getData();
					var data = [];

					var arrayLength = series.length;
                    for (var i = 0; i < arrayLength; i++) {
                       data.push([i, series[i]]);
                    }

					plot = $.plot("#placeholder", [data], options);

					oldData = data;
				}

				$.ajax({
					url: "/drill/excavation/fetchData",
					type: "GET",
					contentType : "application/json",
					dataType: "json",
					success: onDataReceived,
					error: function(){
						alert('Error');
					}
				});
    		}

    		//setTimeout(fetchData, 1000);

    		$("#startBtn").click(function() {
    			  fetchData();
    			  continueProcess = true;

    			  $("#startBtn").hide();
    			  $("#stopBtn").show();
    		});

    		$("#stopBtn").click(function() {
    			  continueProcess = false;

    			  $("#startBtn").show();
    			  $("#stopBtn").hide();
    		  });

    		function clearPlot() {
    			$.plot("#placeholder", null, {
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
    		}
        </script>
</body>
</html>