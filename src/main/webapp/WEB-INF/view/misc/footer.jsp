   </div>
    <!-- /#wrapper -->

<script type="text/javascript">
		 var options = {
			series: {
				shadowSize: 6
			},
			yaxis: {
				min: 0,
				max: 100
			},
			xaxis: {
				min: 0,
				max: 480
			}
		 };

		var continueExcavationProcess;
		var continueLoadProcess;

		var oldExcData = [[0,0]];
		var oldLoadData = [[0,0]];

		$.plot("#placeholder", [oldExcData], options);
		$.plot("#placeholder2", [oldLoadData], options);

		function fetchExcavationData() {

			function onDataReceived1(series) {
				var data = [];

				var arrayLength = series.length;
				var oldDataLength = oldExcData.length;
				for (var i = 0; i < arrayLength; i++) {
				   data.push([(oldDataLength + i) * 7, series[i]]);
				}

				var result = oldExcData.concat(data);
				oldExcData = result;

				$.plot("#placeholder", [result], options);
			}

			$.ajax({
				url: "/drill/excavation/fetchExcavationData",
				type: "GET",
				contentType : "application/json",
				dataType: "json",
				success: onDataReceived1,
				error: function(){
					alert('System Error. Please, contact administrator.');
				}
			});

			continueExcavationProcess = setTimeout(fetchExcavationData, 2000);
		}

		function fetchLoadData() {

        			function onDataReceived(series) {
        				var data = [];

        				var arrayLength = series.length;
        				var oldDataLength = oldLoadData.length;
        				for (var i = 0; i < arrayLength; i++) {
        				   data.push([(oldDataLength + i) * 7, series[i]]);
        				}

        				var result = oldLoadData.concat(data);
        				oldLoadData = result;

        				$.plot("#placeholder2", [result], options);
        			}

        			$.ajax({
        				url: "/drill/excavation/fetchLoadData",
        				type: "GET",
        				contentType : "application/json",
        				dataType: "json",
        				success: onDataReceived,
        				error: function(){
        					alert('System Error. Please, contact administrator.');
        				}
        			});

        			continueLoadProcess = setTimeout(fetchLoadData, 2000);
        		}

		$("#startBtn").click(function() {
			  fetchExcavationData();
			  fetchLoadData();

			  $("#startBtn").hide();
			  $("#stopBtn").show();
		});

		$("#stopBtn").click(function() {
			  clearTimeout(continueExcavationProcess);
			  clearTimeout(continueLoadProcess);

			  $("#startBtn").show();
			  $("#stopBtn").hide();
		  });

		function clearPlot() {
			$.plot("#placeholder", null, {
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