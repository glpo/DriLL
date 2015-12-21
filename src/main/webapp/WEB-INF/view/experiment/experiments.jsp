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
                            <div class="dataTable_wrapper">
                                <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                                    <thead>
                                        <tr>
                                            <th>#</th>
                                            <th>Name</th>
                                            <th>Operations</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                            <c:forEach var="card" items="${routingCards}">
                                                <tr class="odd gradeX">
                                                    <td>1</td>
                                                    <td>${card.name}</td>
                                                    <td>
                                                        <a href="routing/edit/id/${card.id}" id="${card.id}">
                                                            <span class="glyphicon glyphicon-edit" aria-hidden="true"></span>
                                                        </a>
                                                         |
                                                        <a class="confirm" href="routing/delete/id/${card.id}" id="${card.id}">
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