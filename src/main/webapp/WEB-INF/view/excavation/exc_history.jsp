<%@ include file="../misc/header.jsp" %>
<div class="row">
    <div class="col-lg-12">
        <h1 class="page-header">Excavation History</h1>
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
                <div class="dataTable_wrapper">
                    <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                        <thead>
                            <tr>
                                <th>#</th>
                                <th>Session</th>
                                <th>Operations</th>
                            </tr>
                        </thead>
                        <tbody>
                                <c:forEach var="hist" items="${exc_history}" varStatus="loop">
                                    <tr class="odd gradeX">
                                        <td>${loop.index + 1}</td>
                                        <td>Excavation Session #${hist.sessionNumber}</td>
                                        <td>
                                            <a href="edit/id/${hist.id}" id="${hist.id}">
                                                <span class="glyphicon glyphicon-edit" aria-hidden="true"></span>
                                            </a>
                                             |
                                            <a class="confirm" href="delete/id/${hist.id}" id="${hist.id}">
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