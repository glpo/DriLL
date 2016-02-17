<%@ include file="../misc/header.jsp" %>
<div class="row">
    <div class="col-lg-12">
        <h1 class="page-header">New Drilling Experiment</h1>
    </div>
    <!-- /.col-lg-12 -->
</div>

<div class="row">
<div class="col-lg-12">
    <div class="panel panel-default">
        <div class="panel-heading">
            Create New Experiment
        </div>
        <div class="panel-body">
            <div class="row">
                <div class="col-lg-6">
                    <form role="form" method="post" action="/drill/experiment/create">
                        <div class="form-group">
                            <label>Experiment Name</label>
                            <input class="form-control" placeholder="Enter experiment name" name="name">
                            <label class="checkbox-inline">
                                <input type="checkbox" name="autoGenerate">Auto generate name
                            </label>
                        </div>
                        <div class="form-group">
                            <label>Load - F</label>
                            <input class="form-control" placeholder="Enter load value" name="bitLoad">
                        </div>

                        <div class="form-group">
                            <label>Delta Load - dF</label>
                            <input class="form-control" placeholder="Enter delta load value" name="bitDeltaLoad">
                        </div>

                        <div class="form-group">
                            <label>Break By</label>
                            <div class="radio">
                                <label>
                                    <input type="radio" name="breakBy" value="Time">Time
                                </label>
                            </div>
                            <div class="radio">
                                <label>
                                     <input type="radio" name="breakBy" value="Excavation">Excavation
                                </label>
                            </div>
                                <label>Break Parameter Value</label>
                                <input class="form-control" placeholder="Enter Break Parameter Value (minuets/miters)" name="breakParamValue">
                        </div>

                        <button type="submit" class="btn btn-default">Create</button>
                        <button type="reset" class="btn btn-default">Discard</button>
                    </form>
                </div>
            </div>
            <!-- /.row (nested) -->
        </div>
        <!-- /.panel-body -->
    </div>
    <!-- /.panel -->
</div>
<!-- /.col-lg-12 -->
</div>

<%@ include file="../misc/footer.jsp" %>