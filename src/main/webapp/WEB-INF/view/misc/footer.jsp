   </div>
    <!-- /#wrapper -->

     <script type="text/javascript">

                        var continueProcess = false;

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

                      		var updateInterval = 240;

                      		$("#startBtn").click(function() {
                                  update();
                                  continueProcess = true;

                                  $("#startBtn").hide();
                                  $("#stopBtn").show();
                      		});

                      		$("#stopBtn").click(function() {
                                  continueProcess = false;

                                  $("#startBtn").show();
                                  $("#stopBtn").hide();
                              });

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
                      		    if(continueProcess) {
                      			    plot.setData([getRandomData()]);
                      		    }

                      			plot.draw();
                      			setTimeout(update, updateInterval);
                      		}

                              if(continueProcess) {
                      		  update();
                      		}

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