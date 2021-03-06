<%@ include file="../misc/header.jsp" %>
<div class="row">
    <div class="col-lg-12">
        <h1 class="page-header">Edit Excavation</h1>
    </div>
    <!-- /.col-lg-12 -->
</div>
<div class="row">
    <div class="col-lg-12">
        <div class="panel panel-default">
            <div class="panel-heading">
               Excavation Session #${sessionNumber} Is Experiment: ${isExperiment}
            </div>
            <!-- /.panel-heading -->
            <div class="panel-body">
                <c:if test="${not empty message}">
                    <div class="alert alert-success">
                        ${message}
                    </div>
                </c:if>
                <div class="dataTable_wrapper">
                <form action="/drill/excavation/edit" method="post">
                    <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                        <thead>
                            <tr>
                                <th>ObjectID: ${id}</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr class="odd gradeX">
                                    <c:forEach var="excvtn" items="${excavation}" varStatus="loop">
                                        <label>Time: ${excvtn.time}</label> <br>
                                        <label>Excavation:</label> <input class="form-control" value="${excvtn.exc}" name="exc"> </br>
                                        <input value="${id}" name="id" type="hidden">
                                    </c:forEach>
                                </td>
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