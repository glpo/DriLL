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
               Excavation Session #${sessionNumber}
            </div>
            <!-- /.panel-heading -->
            <div class="panel-body">
                <div class="dataTable_wrapper">
                    <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                        <thead>
                            <tr>
                                <th>ObjectID: ${id}</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr class="odd gradeX">
                                <td> Excavation: </br>
                                    <c:forEach var="excvtn" items="${excavation}" varStatus="loop">
                                        Time: ${excvtn.time}; Excavation: ${excvtn.exc} </br>
                                    </c:forEach>
                                </td>
                            </tr>
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