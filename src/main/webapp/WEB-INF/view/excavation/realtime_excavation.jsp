<%@ include file="../misc/header.jsp" %>

<div class="row">
    <div class="col-lg-12">
      <h1 class="page-header">Real-time excavation processfghfjhfh</h1>
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
       ${isChange}
       <form method="POST" action="/drill/excavation/check_layer">
           <button type="submit" class="btn btn-default">Check layer</button>
       </form>
   </div>
   <!-- /.panel-body -->
</div>
 <!-- /.panel -->

<%@ include file="../misc/footer.jsp" %>
