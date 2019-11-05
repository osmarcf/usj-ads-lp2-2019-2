<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Calculadora</title>
  </head>
  <body>

  <form action="SomaServlet">
    <fieldset>
      <legend>Somar</legend>
      <label for="soma_a">Valor a:</label>
      <input type="text" name="a" id="soma_a" />
      <br/>
      <label for="soma_b">Valor b:</label>
      <input type="text" name="b" id="soma_b" />
      <br/>
      <input type="submit" value="Somar" />
    </fieldset>
  </form>

  <hr/>

  <form action="SubtracaoServlet">
    <fieldset>
      <legend>Subtrair</legend>
      <label for="subtracao_a">Valor a:</label>
      <input type="text" name="a" id="subtracao_a" />
      <br/>
      <label for="subtracao_b">Valor b:</label>
      <input type="text" name="b" id="subtracao_b" />
      <br/>
      <input type="submit" value="Subtrair" />
    </fieldset>
  </form>

  </body>
</html>
