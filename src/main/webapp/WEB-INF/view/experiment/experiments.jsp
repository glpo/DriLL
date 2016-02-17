<%@ include file="../misc/header.jsp" %>
<div class="row">
    <div class="col-lg-12">
        <h1 class="page-header">Drilling Experiments History</h1>
    </div>
    <!-- /.col-lg-12 -->
</div>

<div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                           Experiments
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                        <c:if test="${not empty message}">
                            <div class="alert alert-success">
                                ${message}
                            </div>
                        </c:if>
                            <div class="dataTable_wrapper">
                                <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                                    <thead>
                                        <tr>
                                            <th>#</th>
                                            <th>Name</th>
                                            <th>Bit Load</th>
                                            <th>Delta Bit Load</th>
                                            <th>Break By</th>
                                            <th>Break Param Value</th>
                                            <th>Operations</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                            <c:forEach var="experiment" items="${experiments}" varStatus="loop">
                                                <tr class="odd gradeX">
                                                    <td>${loop.index + 1}</td>
                                                    <td>${experiment.name}</td>
                                                    <td>${experiment.bitLoad}</td>
                                                    <td>${experiment.bitDeltaLoad}</td>
                                                    <td>${experiment.breakBy}</td>
                                                    <td>${experiment.breakParamValue}</td>
                                                    <td>
                                                        <a href="edit/id/${experiment.id}" id="${experiment.id}">
                                                            <span class="glyphicon glyphicon-edit" aria-hidden="true"></span>
                                                        </a>
                                                         |
                                                        <a href="delete/id/${experiment.id}" id="${experiment.id}">
                                                            <span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
                                                        </a>
                                                    </td>
                                                </tr>
                                            </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                            <!-- /.table-responsive -->
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
            </div

<%@ include file="../misc/footer.jsp" %>