<%@ include file="../misc/header.jsp" %>

 <div class="row">
    <div class="col-lg-12">
        <h1 class="page-header">Reports</h1>
    </div>
</div>
<div class="row">
    <div class="col-lg-12">
        <div class="panel panel-default">
            <div class="panel-heading">
               <a href="/drill/reports/excavation">Generate Excavation Report</a> |
               <a href="/drill/reports/breed">Generate Breed Report</a> |
               <a href="/drill/reports/faults">Generate Faults Report</a> |
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
                                <th>Report Name</th>
                                <th>Operations</th>
                            </tr>
                        </thead>
                        <tbody>
                                <c:forEach var="report" items="${reports}" varStatus="loop">
                                    <tr class="odd gradeX">
                                        <td>${loop.index + 1}</td>
                                        <td>${report.name}</td>
                                        <td>
                                            <a href="reports/download/id/${report.id}" id="${report.id}">
                                                <span class="glyphicon glyphicon-edit" aria-hidden="true"></span>
                                            </a>
                                             |
                                            <a class="confirm" href="reports/delete/id/${report.id}" id="${report.id}">
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
</div>
<%@ include file="../misc/footer.jsp" %>