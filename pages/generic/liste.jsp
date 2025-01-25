<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%-- Table --%>
<section id="line-awesome-icons">
  <div class="row">
    <div class="col-12">
      <div class="card">
        <div class="card-header">
          <h4 class="card-title">Liste des <%= request.getAttribute("modelName") %>s</h4>
          <a class="heading-elements-toggle"><i class="la la-ellipsis-v font-medium-3"></i></a>
          <div class="heading-elements">
            <ul class="list-inline mb-0">
              <li><a data-action="collapse"><i class="ft-minus"></i></a></li>
              <li><a data-action="reload"><i class="ft-rotate-cw"></i></a></li>
              <li><a data-action="close"><i class="ft-x"></i></a></li>
            </ul>
          </div>
        </div>

        <div class="card-content collapse show">
          <div class="card-body">
            <%= request.getAttribute("tableHtml") %>
          </div>
        </div>
      </div>
    </div>
  </div>
</section>

<!-- Modal Structure -->
<div id="editModal" class="modal" style="display:none;">
    <div class="modal-content">
        <div class="modal-header">
            <h5 class="modal-title">Edit Entity</h5>
            <button type="button" class="close" onclick="closeModal()">&times;</button>
        </div>
        <div class="modal-body">
            <form id="editForm" onsubmit="return submitForm();">
                <input type="hidden" name="id" id="entityId"/>
                <div id="modalFields"></div> <!-- Dynamic fields -->
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" onclick="closeModal()">Close</button>
                    <input type="submit" class="btn btn-primary" value="Update"/>
                </div>
            </form>
        </div>
    </div>
</div>