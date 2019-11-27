<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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

  <jsp:useBean id="livro" class="br.edu.usj.ads.lpii.LivroCaixa" />
  <fieldset>
    <legend>Registros do Livro Caixa</legend>
    <c:if test="${not empty livro.registros}">
      <ul>
        <c:forEach items="${livro.registros}" var="r">
          <li> ${ r.descricao } ${ r.valor } </li>
        </c:forEach>
      </ul>
    </c:if>

    <c:if test="${empty livro.registros}">
      <p>Não há registros!</p>
    </c:if>
  </fieldset>
  </body>
</html>
