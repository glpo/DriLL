<%@ include file="../misc/header.jsp" %>

<div class="row">
    <div class="col-lg-12">
      <h1 class="page-header">Real-time excavation process</h1>
    </div>
</div>

<div class="panel panel-default">
<c:if test="${not empty message}">
                    <div class="alert alert-success">
                        ${message}
                    </div>
                </c:if>
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
       <c:if test="${empty message}">
            <div class="demo-container">
               <div id="placeholder" class="demo-placeholder"></div>
            </div>

             <div class="demo-container">
                 <div id="placeholder2" class="demo-placeholder"></div>
             </div>

             <p>
                 <button type="button" class="btn btn-outline btn-primary" id="startBtn">Start Process</button>
                 <button type="button" class="btn btn-outline btn-primary" id="stopBtn" style="display: none;">Stop Process</button>
             </p>

             <div class="panel panel-default">
                         <div class="panel-heading">
                             <i class="fa fa-bell fa-fw"></i> Notifications Panel
                         </div>
                         <!-- /.panel-heading -->
                         <div class="panel-body">
                             <div class="list-group">
                              <!--   <a href="#" class="list-group-item">
                                     <i class="fa fa-tasks fa-fw"></i> Test Drilling Started
                                     <span class="pull-right text-muted small"><em>43 minutes ago</em>
                                     </span>
                                 </a>
                                 <a href="#" class="list-group-item">
                                     <i class="fa fa-upload fa-fw"></i> Raise the chisel
                                     <span class="pull-right text-muted small"><em>11:32 AM</em>
                                     </span>
                                 </a>
                                 <a href="#" class="list-group-item">
                                     <i class="fa fa-bolt fa-fw"></i> Chisel Crashed!
                                     <span class="pull-right text-muted small"><em>11:13 AM</em>
                                     </span>
                                 </a>
                                 <a href="#" class="list-group-item">
                                     <i class="fa fa-warning fa-fw"></i> Formation Changed!
                                     <span class="pull-right text-muted small"><em>10:57 AM</em>
                                     </span>
                                 </a> -->
                             </div>
                             <!-- /.list-group -->
                             <a href="#" class="btn btn-default btn-block">View All Alerts</a>
                         </div>
                         <!-- /.panel-body -->
                     </div>
                     <!-- /.panel -->
       </c:if>
   </div>
   <!-- /.panel-body -->
</div>
 <!-- /.panel -->

<%@ include file="../misc/footer.jsp" %>
