<%@ include file="../misc/header.jsp" %>
<div class="row">
    <div class="col-lg-12">
        <h1 class="page-header">Experiment In Progress</h1>
    </div>
    <!-- /.col-lg-12 -->
</div>

<div class="row">
<div class="col-lg-12">
    <div class="panel panel-default">
        <div class="panel-heading">
            Experiment: <c:if test="${not empty experiment}"> ${experiment.name} </c:if>
        </div>
        <div class="panel-body">
            <div class="row">
                <div class="col-lg-6">
                    <c:if test="${not empty experiment}">
                         <label>Bit Load:&nbsp </label><span id="bitLoad">${experiment.bitLoad}</span> <br>
                         <label>Bit Delta Load:&nbsp </label><span id="bitDeltaLoad">${experiment.bitDeltaLoad}</span><br>
                         <label>Stop process By:&nbsp </label><span id="breakBy">${experiment.breakBy}</span><br>
                         <label>Stop param value:&nbsp </label><span id="breakByVal">${experiment.breakParamValue}</span>
                    </c:if>
                     <div class="demo-container">
                        <div id="placeholder" class="demo-placeholder"></div>
                     </div>
                     <span id="flot2"></span>
                     <span id="flot3"></span>
                      <p>
                          <button type="button" class="btn btn-outline btn-primary" id="startBtn">Start Stage</button>
                          <button type="button" class="btn btn-outline btn-primary" id="stopBtn" style="display: none;">Stop Stage</button>
                      </p>
                 </div>
            </div>
            <!-- /.row (nested) -->
        </div>
        <!-- /.panel-body -->
    </div>
    <!-- /.panel -->
</div>
<!-- /.col-lg-12 -->
</div>

<%@ include file="../misc/footer.jsp" %>