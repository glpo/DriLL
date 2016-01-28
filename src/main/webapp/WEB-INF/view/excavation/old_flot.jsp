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

     <!-- Bootstrap Core JavaScript -->
            <script src="resources/js/bootstrap.min.js"></script>

     <!-- Metis Menu Plugin JavaScript -->
     <script src="resources/js/metisMenu.js"></script>

	<script type="text/javascript">

	$(function() {

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
                            <a href="/drill/dashboard/dashboard"><i class="fa fa-dashboard fa-fw"></i> Dashboard</a>
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
</div>

<div class="panel panel-default">
   <div class="panel-heading">
        <i class="fa fa-bar-chart-o fa-fw"></i> Excavation Chart
        <div class="pull-right">
            <div class="btn-group">
                <button type="button" class="btn btn-default btn-xs dropdown-toggle" data-toggle="dropdown">
                    Actions
                    <span class="caret"></span>
                </button>
                <ul class="dropdown-menu pull-right" role="menu">
                    <li><a href="#" >Save</a></li>
                    <li class="divider"></li>
                    <li><a href="#" onClick="clearPlot()">Clear</a></li>
                </ul>
            </div>
        </div>
   </div>
   <!-- /.panel-heading -->
   <div id="content">
       <div class="demo-container">
           <div id="placeholder" class="demo-placeholder"></div>
       </div>
       <p>
            <button type="button" class="btn btn-outline btn-primary" id="startBtn">Start Process</button>
            <button type="button" class="btn btn-outline btn-primary" id="stopBtn" style="display: none;">Stop Process</button>
       </p>
   </div>
   <!-- /.panel-body -->
</div>
 <!-- /.panel -->

<%@ include file="../misc/footer.jsp" %>
