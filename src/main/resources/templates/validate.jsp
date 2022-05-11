<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
  <!DOCTYPE html>
 <html>
  <head>
      <meta content="text/html" charset="UTF-8">
      <title>Validate user data</title>
  </head>
  <body>
            <jsp:useBean id="user" class="jsp.model.User" scope="session"></jsp:useBean>
            <jsp:setProperty property="*" name="user"/>
            <jsp:useBean id="dataSource" scope="session"></jsp:useBean>

            <!-- Wyświetlenie nazwy użytkownika. -->
            Nazwa: <%= user.getName() %><br />

            <% String result = "Dane niepoprawne";

            <!-- Logika sprawdzająca poprawność parametrów logowania. -->
            if(dataSource.userExists(user)) {
                result = "Poprawny użytkownik oraz hasło";
                }
            %>

            <!-- Zwrócenie  stringa "result" -->
            <%= result %>
  </body>
 </html>