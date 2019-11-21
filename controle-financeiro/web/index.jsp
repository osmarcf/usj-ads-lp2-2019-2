<%@ page import="br.edu.usj.ads.lpii.LivroCaixa" %>
<%@ page import="br.edu.usj.ads.lpii.Registro" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Controle Financeiro</title>
  </head>
  <body>
  <form action="LivroCaixaServlet" method="post">
    <fieldset>
      <legend>Adicionar registro</legend>
      <input type="text" name="descricao" id="descricao">
      <input type="text" name="valor" id="valor">
      <input type="submit" value="Salvar">
    </fieldset>
  </form>

  <fieldset>
    <legend>Registros do Livro Caixa</legend>
    <ul>
<%
  LivroCaixa livro = (LivroCaixa) request.getAttribute("livro");

  if (livro != null) {
    for (Registro r : livro.getRegistros()) {
      %>
      <li> <%= r.getDescricao() %> <%= r.getValor() %></li>
      <%
    }
  }
  else {
    out.print("<li>Não há registros</li>");
  }
%>
    </ul>
  </fieldset>
  </body>
</html>
