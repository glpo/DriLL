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
                             <label>Bit Load: </label>${experiment.bitLoad} <br>
                             <label>Bit Delta Load: </label>${experiment.bitDeltaLoad} <br>
                             <label>Cost Per Hour: </label>${experiment.costPerHour} <br>
                             <label>Bit Cost: </label>${experiment.bitCost} <br>
                             <label>Desc/Asc Time: </label>${experiment.descAscTime} <br>
                             <label>Stop process By: </label>${experiment.breakBy} <br>
                             <label>Stop param value: </label>${experiment.breakParamValue} <br>
                    </c:if>
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