<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Drill - </title>

    <!-- Bootstrap Core CSS -->
    <link href="resources/css/bootstrap.min.css" rel="stylesheet" type="text/css">

    <!-- MetisMenu CSS -->
    <link href="resources/css/metisMenu.css" rel="stylesheet" type="text/css">

    <!-- Timeline CSS -->
    <link href="resources/css/timeline.css" rel="stylesheet" type="text/css">

    <!-- Custom CSS -->
    <link href="resources/css/sb-admin-2.css" rel="stylesheet" type="text/css">

    <!-- Morris Charts CSS -->
    <link href="resources/css/morris.css" rel="stylesheet" type="text/css">

    <!-- Custom Fonts -->
    <link href="resources/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <!-- jQuery -->
    <script language="javascript" type="text/javascript" src="resources/js/jquery.js"></script>


    <link href="resources/css/examples.css" rel="stylesheet" type="text/css">

    <script language="javascript" type="text/javascript" src="resources/js/jquery.flot.js"></script>

	<script type="text/javascript">

	$(function() {

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
		//$("#updateInterval").val(updateInterval).change(function () {
		//	var v = $(this).val();
		//	if (v && !isNaN(+v)) {
		//		updateInterval = +v;
		//		if (updateInterval < 1) {
		//			updateInterval = 1;
		//		} else if (updateInterval > 2000) {
		//			updateInterval = 2000;
		//		}
		//		$(this).val("" + updateInterval);
		//	}
		//});

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
</head>

<body>
    <div id="wrapper">

        <!-- Navigation -->
        <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="index.html">Drill</a>
            </div>
            <!-- /.navbar-header -->
            <div class="navbar-default sidebar" role="navigation">
                            <div class="sidebar-nav navbar-collapse">
                                <ul class="nav" id="side-menu">
                                    <li class="sidebar-search">
                                        <div class="input-group custom-search-form">
                                            <input type="text" class="form-control" placeholder="Search...">
                                            <span class="input-group-btn">
                                            <button class="btn btn-default" type="button">
                                                <i class="fa fa-search"></i>
                                            </button>
                                        </span>
                                        </div>
                                        <!-- /input-group -->
                                    </li>
                                    <li>
                                        <a href="/drill/dashboard"><i class="fa fa-dashboard fa-fw"></i> Dashboard</a>
                                    </li>
                                    <li>
                                                                                <a href="#"><i class="fa fa-table fa-fw"></i>Excavation</a>
                                                                                   <ul class="nav nav-second-level">
                                                                                       <li>
                                                                                           <a href="/drill/excavation/realtime"> Real-time Excavation</a>
                                                                                       </li>
                                                                                       <li>
                                                                                           <a href="/drill/excavation/history"> Excavation History</a>
                                                                                       </li>
                                                                                    </ul>
                                                                                   <!-- /.nav-second-level -->
                                                                                </li>
                                    <li>
                                            <a href="#"><i class="fa fa-table fa-fw"></i>Experiments</a>
                                            <ul class="nav nav-second-level">
                                               <li>
                                                   <a href="/drill/experiment/new"> New Experiment</a>
                                               </li>
                                               <li>
                                                   <a href="/drill/experiment/history"> Experiment History</a>
                                               </li>
                                            </ul>
                                           <!-- /.nav-second-level -->
                                        </li>
                                    <li>
                                        <a href="#"><i class="fa fa-table fa-fw"></i>Documents</a>
                                        <ul class="nav nav-second-level">
                                           <li>
                                               <a href="/drill/routing/allCards"> Routing Cards</a>
                                           </li>
                                           <li>
                                               <a href="/drill/params"> Global Params</a>
                                           </li>
                                        </ul>
                                       <!-- /.nav-second-level -->
                                    </li>
                                </ul>
                            </div>
                            <!-- /.sidebar-collapse -->
                        </div>
                        <!-- /.navbar-static-side -->
                    </nav>

                    <div id="page-wrapper">

	<div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">Real-time excavation process</h1>
        </div>
        <!-- /.col-lg-12 -->
    </div>

	<div id="content">

		<div class="demo-container">
			<div id="placeholder" class="demo-placeholder"></div>
		</div>
	</div>

<%@ include file="../misc/footer.jsp" %>
