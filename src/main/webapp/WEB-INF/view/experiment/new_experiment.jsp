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
                    <form role="form">
                        <div class="form-group">
                            <label>Experiment Name</label>
                            <input class="form-control" placeholder="Enter experiment name">
                            <label class="checkbox-inline">
                                <input type="checkbox">Auto generate name
                            </label>
                        </div>
                        <div class="form-group">
                            <label>Attach drilling doc</label>
                            <input type="file">
                        </div>
                        <div class="form-group">
                            <label>Additional Comment</label>
                            <textarea class="form-control" rows="3"></textarea>
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