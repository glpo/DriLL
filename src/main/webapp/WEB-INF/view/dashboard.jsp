<%@ include file="header.jsp" %>

 <div class="row">
                            <div class="col-lg-12">
                                <h1 class="page-header">Dashboard</h1>
                            </div>
                            <!-- /.col-lg-12 -->
                        </div>
                        <!-- /.row -->
<div class="col-lg-6">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <i class="fa fa-bar-chart-o fa-fw"></i> Current Excavation Process
                            <div class="pull-right">
                                <div class="btn-group">
                                    <button type="button" class="btn btn-default btn-xs dropdown-toggle" data-toggle="dropdown">
                                        Actions
                                        <span class="caret"></span>
                                    </button>
                                    <ul class="dropdown-menu pull-right" role="menu">
                                        <li><a href="#">Action</a>
                                        </li>
                                        <li><a href="#">Another action</a>
                                        </li>
                                        <li><a href="#">Something else here</a>
                                        </li>
                                        <li class="divider"></li>
                                        <li><a href="#">Separated link</a>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <div id="morris-area-chart"></div>
                        </div>
                        <!-- /.panel-body -->

                                                <div class="panel-heading">
                                                    Moving Line Chart Example
                                                </div>
                                                <!-- /.panel-heading -->
                                                <div class="panel-body">
                                                    <div class="flot-chart">
                                                        <div class="flot-chart-content" id="flot-line-chart-moving"></div>
                                                    </div>
                                                </div>
                                                <!-- /.panel-body -->
                                                </div>
                                                <!-- /.panel -->
                </div>

                    <script src="resources/js/excanvas.min.js"></script>

                    <script src="resources/js/jquery.flot.pie.js"></script>
                    <script src="resources/js/jquery.flot.resize.js"></script>
                    <script src="resources/js/jquery.flot.time.js"></script>
                    <script src="resources/js/jquery.flot.tooltip.min.js"></script>
                    <script src="resources/js/flot-data.js"></script>

<%@ include file="footer.jsp" %>