<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %>
<%@ page import="com.entities.Book" %>

<html>
  <head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <title></title>
    <meta name="description" content="" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link rel="stylesheet" href="" />
    <style>
      body {
        margin: 0;
        padding: 0;
        min-height: 100%;
        display: flex;
        flex-direction: column;
      }

      header {
        background-color: #333;
        color: #fff;
        display: flex;
        justify-content: space-between;
        padding: 1rem;
      }

      header p {
        font-size: 1.2rem;
        margin: 0;
      }

      header form {
        margin: 0;
        display: flex;
        align-items: center;
      }

      header input[type="submit"] {
        background-color: #fff;
        border: none;
        border-radius: 5px;
        cursor: pointer;
        font-size: 1rem;
        padding: 0.5rem;
        margin-left: 1rem;
      }

      header div {
        display: flex;
        align-items: center;
      }

      main {
        padding: 1rem;
        flex: 1;
      }

      main h2 {
        font-size: 2rem;
        margin-top: 0;
        display: inline-block;
      }

      main form {
        display: inline-block;
        margin-left: 1rem;
      }

      main input[type="submit"] {
        border: none;
        border-radius: 5px;
        cursor: pointer;
        font-size: 1rem;
        padding: 0.5rem;
      }

      footer {
        background-color: #333;
        color: #fff;
        padding: 1rem;
        margin-top: auto;
        position: fixed;
        bottom: 0;
        left: 0;
        right: 0;
        text-align: center;
      }

      footer p {
        margin: 0;
      }

      .head1 {
        margin-left: 87%;
      }

      .h2 {
        margin-left: 4%;
        margin-right: 39%;
      }
    </style>
  </head>
  <body>
    <header>
      <div class="head1">
        <p>Welcome User</p>
        <form action="Logout">
          <input type="submit" value="logout" />
        </form>
      </div>
    </header>
    <main>
      <div>
        <h2 class="h2">
          Books Listing
        </h2>
        <form action="Addbook" >
          <input type="submit" value="Add a Book" />
        </form>
      </div>
      <div>
      		<table>
        <thead>
            <tr>
                <th>bookcode</th>
                <th>bookname</th>
                <th>author</th>
                <th>date</th>
            </tr>
        </thead>
        <tbody>
<%
    List<Book> bookList = (List<Book>)request.getAttribute("bookList");
    for (Book book : bookList) {
%>
    <tr>
        <td><%= book.getBookcode() %></td>
        <td><%= book.getBookname() %></td>
        <td><%= book.getAuthor() %></td>
        <td><%= book.getDate() %></td>
        <td><form action="editbook">
                 <input type="hidden" name="bookcode" value="<%= book.getBookcode() %>">
        <input type="submit" value="edit" ></form></td>
        <td><form action="deletebook">
         <input type="hidden" name="bookcode" value="<%= book.getBookcode() %>"><input type="submit" value="delete" ></form></td>
    </tr>
<%
    }
%>
</tbody>
    </table>
      
      </div>
    </main>
    <footer>
      <div>
        <p>Nagarro Training</p>
      </div>
    </footer>
  </body>
</html>
