package br.edu.usj.ads.lpii;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/SubtracaoServlet")
public class SubtracaoServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String a = request.getParameter("a");
        Integer valorA = Integer.valueOf(a);

        String b = request.getParameter("b");
        Integer valorB = Integer.valueOf(b);

        Integer resultado = valorA - valorB;

        PrintWriter saida = response.getWriter();
        saida.println("<html>");
        saida.println("<body>");
        saida.print("<h1>");
        saida.print(a);
        saida.print(" - ");
        saida.print(b);
        saida.print(" = ");
        saida.print(resultado);
        saida.println("</h1>");
        saida.println("</body>");
        saida.println("</html>");
    }
}
