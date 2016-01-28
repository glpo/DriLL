<%@ include file="../misc/header.jsp" %>
<div class="row">
    <div class="col-lg-12">
        <h1 class="page-header">Edit Experiment</h1>
    </div>
    <!-- /.col-lg-12 -->
</div>
<div class="row">
    <div class="col-lg-12">
        <div class="panel panel-default">
            <div class="panel-heading">
               Experiment: ${experiment.name}
            </div>
            <!-- /.panel-heading -->
            <div class="panel-body">
                <c:if test="${not empty message}">
                    <div class="alert alert-success">
                        ${message}
                    </div>
                </c:if>
                <div class="dataTable_wrapper">
                <form action="/drill/experiment/edit" method="post">
                    <input value="${experiment.id}" name="id" type="hidden">
                    <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                        <thead>
                            <tr>
                                <th>ObjectID: ${experiment.id}</th>
                                <th>Values</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr class="odd gradeX">
                                <td>Name: </td> <td><input class="form-control" value="${experiment.name}" name="name"></td>
                            </tr>
                            <tr class="odd gradeX">
                                <td>Bit Load: </td> <td><input class="form-control" value="${experiment.bitLoad}" name="bitLoad"></td>
                            </tr>
                            <tr class="odd gradeX">
                                <td>Bit Delta Load: </td> <td><input class="form-control" value="${experiment.bitDeltaLoad}" name="bitDeltaLoad"></td>
                            </tr>
                            <tr class="odd gradeX">
                                <td>Cost Per Hour: </td> <td><input class="form-control" value="${experiment.costPerHour}" name="costPerHour"></td>
                            </tr>
                            <tr class="odd gradeX">
                                <td>Bit Cost: </td> <td><input class="form-control" value="${experiment.bitCost}" name="bitCost"></td>
                            </tr>
                            <tr class="odd gradeX">
                                <td>Desc/Asc Time: </td> <td><input class="form-control" value="${experiment.descAscTime}" name="descAscTime"></td>
                            </tr>
                            <tr class="odd gradeX">
                                <td>Break By: </td> <td><input class="form-control" value="${experiment.breakBy}" name="breakBy"></td>
                            </tr>
                            <tr class="odd gradeX">
                                <td>Break Param Value: </td> <td><input class="form-control" value="${experiment.breakParamValue}" name="breakParamValue"></td>
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