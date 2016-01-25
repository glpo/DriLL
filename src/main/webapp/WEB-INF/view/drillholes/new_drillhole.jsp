<%@ include file="../misc/header.jsp" %>

 <div class="row">
    <div class="col-lg-12">
        <h1 class="page-header">New Drill-Hole</h1>
    </div>
</div>
<div class="row">
    <div class="col-lg-12">
        <div class="panel panel-default">
            <div class="panel-heading">

            </div>
            <!-- /.panel-heading -->
            <div class="panel-body">
               <form method="POST" action="/drill/drillholes/create">
                    <div class="form-group">
                        <label>Name</label>
                        <input class="form-control" placeholder="Enter Drill-Hole Name" name="name">
                    </div>
                    <div class="form-group">
                        <label>Location</label>
                        <input class="form-control" placeholder="Enter Drill-Hole Location" name="location">
                    </div>
                    <button type="submit" class="btn btn-default">Create</button>
                    <button type="reset" class="btn btn-default">Discard</button>
               </form>
            </div>
            <!-- /.panel-body -->
        </div>
        <!-- /.panel -->
    </div>
    <!-- /.col-lg-12 -->
</div>
<%@ include file="../misc/footer.jsp" %>