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

            </div>
            <!-- /.panel-body -->
        </div>
        <!-- /.panel -->
    </div>
    <!-- /.col-lg-12 -->
</div>
<%@ include file="../misc/footer.jsp" %>