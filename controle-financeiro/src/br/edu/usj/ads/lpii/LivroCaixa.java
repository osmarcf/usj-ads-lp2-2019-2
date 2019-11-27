package br.edu.usj.ads.lpii;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LivroCaixa {

    /*
    private List<Registro> registros = new ArrayList<>();

    public List<Registro> getRegistros() {
        return registros;
    }
    public void adicionarRegistro (Registro r ) {
        registros.add(r);
    }
     */

    public List<Registro> getRegistros() {
        // pegar conexao com banco
        Connection conexao = new ConnectionFactory().getConnection();

        // montar o sql (query - select)
        String sql = "select * from livro_caixa";

        List<Registro> retorno = new ArrayList<>();

        // executar a query
        try {
            PreparedStatement query = conexao.prepareStatement(sql);
            ResultSet rs = query.executeQuery();

            // ler os resultados para uma lista
            while (rs.next()) {
                String descricao = rs.getString("descricao");
                String valor = rs.getString("valor");

                Registro r = new Registro();
                r.setDescricao(descricao);
                r.setValor(valor);

                retorno.add(r);
            }

            // fechar objetos
            rs.close();
            query.close();
            conexao.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        // retornar essa lista
        return retorno;
    }

    public void adicionaRegistro(Registro r) {
        // pegar a conexao
        Connection conexao = new ConnectionFactory().getConnection();

        String sql = "insert into livro_caixa values (?, ?, ?)";

        // montar o sql (query - insert)
        try {
            PreparedStatement query = conexao.prepareStatement(sql);

            query.setString(1, null);
            query.setString(2, r.getDescricao());
            query.setString(3, r.getValor());

            // executar a query
            query.execute();

            // fechar os objetos/queries
            query.close();
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
