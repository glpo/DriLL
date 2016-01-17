<%@ include file="../misc/header.jsp" %>

 <div class="row">
    <div class="col-lg-12">
        <h1 class="page-header">Drill-Holes Management</h1>
    </div>
</div>
<div class="row">
    <div class="col-lg-12">
        <div class="panel panel-default">
            <div class="panel-heading">
               <form method="POST" action="">
                   <button type="button" class="btn btn-outline btn-primary">Create New</button>
              </form>
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
                                <th>Drill-Hole</th>
                                <th>Operations</th>
                            </tr>
                        </thead>
                        <tbody>
                                <c:forEach var="hole" items="${drillholes}" varStatus="loop">
                                    <tr class="odd gradeX">
                                        <td>${loop.index + 1}</td>
                                        <td>${hole.name}</td>
                                        <td>
                                            <a href="drillholes/edit/id/${hole.id}" id="${hole.id}">
                                                <span class="glyphicon glyphicon-edit" aria-hidden="true"></span>
                                            </a>
                                             |
                                            <a class="confirm" href="drillholes/delete/id/${hole.id}" id="${hole.id}">
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