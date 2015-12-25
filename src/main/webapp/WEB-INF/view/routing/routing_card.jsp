<%@ include file="../misc/header.jsp" %>
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Modal Routing</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>

<div class="row">
   <div class="panel panel-default">
                        <div class="panel-heading">
                           Modal Routing Ololo #1
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <div class="table-responsive">
                                <table class="table table-striped table-bordered table-hover">
                                    <thead>
                                        <tr>
                                            <th rowspan="3">Depth</th>
                                            <th rowspan="3">Lithology</th>
                                            <th rowspan="3">Construction</th>
                                            <th rowspan="3">The types and ranges of possible complications</th>
                                            <th rowspan="3">Bit size</th>
                                            <th rowspan="3">Qnas</th>
                                            <th rowspan="3">Hd</th>
                                            <th rowspan="3">T,(hours)</th>
                                            <th rowspan="3">V,(m/hour)</th>
                                            <th colspan="12">Drilling Mode</th>
                                        </tr>
                                        <tr>
                                            <th rowspan="2">KNBK</th>
                                            <th rowspan="2">Drilling Method</th>
                                            <th rowspan="2">Gd</th>
                                            <th rowspan="2">Np</th>
                                            <th rowspan="2">Q,(l/s)</th>
                                            <th rowspan="2">P,(kgs/cm2)</th>
                                            <th colspan="6">Drilling Fluid </th>
                                        </tr>
                                        <tr>
                                            <th>Ro</th>
                                            <th>F3</th>
                                            <th>T, sec</th>
                                            <th>CH3</th>
                                            <th>P, %</th>
                                            <th>Type</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                         <c:forEach var="crd" items="${card}">
                                                <tr>
                                                    <td>${crd.name}</td>
                                                </tr>
                                            </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                            <!-- /.table-responsive -->
                        </div>
                        <!-- /.panel-body -->
                    </div>
   </div>
<%@ include file="../misc/footer.jsp" %>