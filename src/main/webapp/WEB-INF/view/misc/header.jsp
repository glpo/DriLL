<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Drill - </title>

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

    <script language="javascript" type="text/javascript" src="resources/js/jquery.js"></script>

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

    <!-- Bootstrap Core JavaScript -->
        <script src="resources/js/bootstrap.min.js"></script>

        <!-- Metis Menu Plugin JavaScript -->
        <script src="resources/js/metisMenu.js"></script>

        <!-- Morris Charts JavaScript -->
        <script src="resources/js/raphael-min.js"></script>
        <script src="resources/js/morris.min.js"></script>
        <script src="resources/js/morris-data.js"></script>

        <!-- Custom Theme JavaScript -->
        <script src="resources/js/sb-admin-2.js"></script>

        <script src="resources/js/excanvas.min.js"></script>

        <script src="resources/js/jquery.flot.js"></script>
        <script src="resources/js/jquery.flot.pie.js"></script>
        <script src="resources/js/jquery.flot.resize.js"></script>
        <script src="resources/js/jquery.flot.time.js"></script>
        <script src="resources/js/jquery.flot.tooltip.min.js"></script>
        <script src="resources/js/flot-data.js"></script>



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

            <a class="nav navbar-top-links navbar-right" href="/drill/drillholes/id/${currentHole.id}">
                 <c:if test="${not empty currentHole}">
                    <p class="fa fa-map-marker">${currentHole.name}</p>
                 </c:if>
            </a>

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
                        <li>
                            <a href="/drill/drillholes/all"><i class="fa fa-table fa-fw"></i>Drill-holes</a>
                        </li>
                        <li>
                            <a href="/drill/reports/all"><i class="fa fa-table fa-fw"></i>Reports</a>
                        </li>
                    </ul>
                </div>
                <!-- /.sidebar-collapse -->
            </div>
            <!-- /.navbar-static-side -->
        </nav>
    <div id="page-wrapper">