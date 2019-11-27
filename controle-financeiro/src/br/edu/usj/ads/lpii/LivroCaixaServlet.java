package br.edu.usj.ads.lpii;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/LivroCaixaServlet")
public class LivroCaixaServlet extends HttpServlet {

    LivroCaixa livro = new LivroCaixa();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String descricao = request.getParameter("descricao");
        String valor = request.getParameter("valor");

        Registro registro = new Registro();
        registro.setDescricao(descricao);
        registro.setValor(valor);

        livro.adicionaRegistro(registro);

        RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
        rd.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
