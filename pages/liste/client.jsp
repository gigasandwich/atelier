<%@ page import="java.util.List" %>
<%@ page import="model.Client" %>
<%@ page import="dao.ClientDao" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>

<%
    ClientDao clientDao = new ClientDao();
    List<Client> clients = clientDao.selectAll();
%>

<!-- Line Awesome section start -->
<section id="line-awesome-icons">
  <div class="row">
    <div class="col-12">
      <div class="card">
        <div class="card-header">
          <h4 class="card-title">Client List</h4>
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
            <table class="table table-bordered">
              <thead>
                <tr>
                  <th>ID</th>
                  <th>Name</th>
                  <th>Contact</th>
                  <th>Actions</th>
                </tr>
              </thead>
              <tbody>
                <%
                  for (Client client : clients) {
                %>
                <tr>
                  <td><%= client.getIdClient() %></td>
                  <td><%= client.getNomClient() %> <%= client.getPrenomClient() %></td>
                  <td><%= client.getContact() %></td>
                  <td>
                    <!-- Action buttons for editing or deleting -->
                    <a href="edit.jsp?id=<%= client.getIdClient() %>">Edit</a> |
                    <a href="delete.jsp?id=<%= client.getIdClient() %>">Delete</a>
                  </td>
                </tr>
                <%
                  }
                %>
              </tbody>
            </table>
          </div>
        </div>
      </div>
    </div>
  </div>
</section>
<!-- // Line Awesome section end -->
