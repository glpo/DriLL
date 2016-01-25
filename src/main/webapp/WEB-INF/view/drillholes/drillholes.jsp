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
               <form method="GET" action="/drill/drillholes/create">
                   <button type="submit" class="btn btn-outline btn-primary">Create New</button>
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
                                <th>Drill-Hole Name</th>
                                <th>Location</th>
                                <th>Select Primary</th>
                                <th>Operations</th>
                            </tr>
                        </thead>
                        <tbody>
                                <c:forEach var="hole" items="${drillHoles}" varStatus="loop">
                                    <tr class="odd gradeX">
                                        <td>${loop.index + 1}</td>
                                        <td>${hole.name}</td>
                                        <td>${hole.location}</td>
                                        <td>
                                            <c:choose>
                                                <c:when test = "${hole.id eq currentHole.id}">
                                                    <a href="unselectPrimary/id/${hole.id}">
                                                        <p class="fa fa-times-circle">Unselect As Primary</p>
                                                    </a>
                                                </c:when>
                                                <c:otherwise>
                                                    <a href="selectPrimary/id/${hole.id}">
                                                        <p class="fa fa-check">Select As Primary</p>
                                                    </a>
                                                </c:otherwise>
                                            </c:choose>
                                        </td>
                                        <td>
                                            <a href="edit/id/${hole.id}" id="${hole.id}">
                                                <span class="glyphicon glyphicon-edit" aria-hidden="true"></span>
                                            </a>
                                             |
                                            <a href="delete/id/${hole.id}" id="${hole.id}">
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