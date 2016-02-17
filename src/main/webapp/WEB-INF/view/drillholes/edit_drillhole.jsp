<%@ include file="../misc/header.jsp" %>
<div class="row">
    <div class="col-lg-12">
        <h1 class="page-header">Edit Drill-Hole</h1>
    </div>
    <!-- /.col-lg-12 -->
</div>
<div class="row">
    <div class="col-lg-12">
        <div class="panel panel-default">
            <div class="panel-heading">
               Drill-Hole: ${hole.name}
            </div>
            <!-- /.panel-heading -->
            <div class="panel-body">
                <c:if test="${not empty message}">
                    <div class="alert alert-success">
                        ${message}
                    </div>
                </c:if>
                <div class="dataTable_wrapper">
                <form action="/drill/drillholes/edit" method="post">
                    <input value="${hole.id}" name="id" type="hidden">
                    <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                        <thead>
                            <tr>
                                <th>ObjectID: ${hole.id}</th>
                                <th>Values</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr class="odd gradeX">
                                <td>Name: </td> <td><input class="form-control" value="${hole.name}" name="name"></td>
                            </tr>
                            <tr class="odd gradeX">
                                <td>Location: </td> <td><input class="form-control" value="${hole.location}" name="location"></td>
                            </tr>
                             <tr class="odd gradeX">
                                <td>Cost Per Hour: </td> <td><input class="form-control" value="${hole.costPerHour}" name="costPerHour"></td>
                            </tr>
                            <tr class="odd gradeX">
                                <td>Bit Cost: </td> <td><input class="form-control" value="${hole.bitCost}" name="bitCost"></td>
                            </tr>
                            <tr class="odd gradeX">
                                <td>Desc/Asc Time: </td> <td><input class="form-control" value="${hole.descAscTime}" name="descAscTime"></td>
                            </tr>
                        </tbody>
                    </table>
                    <button type="submit" class="btn btn-default">Save</button>
                    <button type="reset" class="btn btn-default">Reset</button>
                 </form>
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