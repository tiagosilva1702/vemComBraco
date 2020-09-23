package dao;

import dao.abstractfactory.FabricaAbstrata;
import dao.abstractfactory.SGBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Usuario;
import util.DbUtil;

/**
 *
 * @author TIAGO
 */
public class UsuarioDAO {

    private Connection connection;

    public UsuarioDAO() {

        //this.connection = DbUtil.getConnection();
        this.connection = FabricaAbstrata.criarFabricaAbstrata(SGBD.MYSQL).criarConector().conectar();
    }

    public void Inserir(Usuario usuario) {
        String sql = "INSERT INTO USUARIO (NOME, EMAIL, SENHA) VALUES (?, ?, ?)";

        try {
            PreparedStatement sentenca = connection.prepareStatement(sql);
            sentenca.setString(1, usuario.getNome());
            sentenca.setString(2, usuario.getEmail());
            sentenca.setString(3, usuario.getSenha());

            sentenca.execute();
            sentenca.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Usuario> ListarUsuario() {
        List<Usuario> listaDeUsuario = new ArrayList<Usuario>();
        String sql = "select * from Usuario";

        try {
            PreparedStatement sentenca = connection.prepareStatement(sql);

            //recebe o resultado da consulta
            ResultSet resultadoSentenca = sentenca.executeQuery();

            //percorrer cada linha do resultado
            while (resultadoSentenca.next()) {
                //resgata o valor de cada linha, selecionando pelo nome de cada coluna da tabela Escola
                Usuario user = new Usuario();
                user.setUsuarioId(resultadoSentenca.getInt("usuarioid"));
                user.setNome(resultadoSentenca.getString("nome"));
                user.setDataNascimento(resultadoSentenca.getDate("datanascimento"));
                user.setEmail(resultadoSentenca.getString("email"));

                //adiciona cada tupla na listaEscolas que será retornada para a janela Escola
                listaDeUsuario.add(user);
            }
            sentenca.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listaDeUsuario;
    }

    public Usuario getUsuario(String login, String senha) {
        Usuario user = new Usuario();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("select usuarioid, nome, email, senha from usuario where email ='" + login + "' and senha ='" + senha + "'");
            while (rs.next()) {
                user = new Usuario();
                user.setUsuarioId(rs.getInt("usuarioid"));
                user.setNome(rs.getString("nome"));
                user.setEmail(rs.getString("email"));
                user.setSenha(rs.getString("senha"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public void salvar(Usuario usuario) {
        String sql = "INSERT INTO USUARIO (NOME, EMAIL, SENHA) VALUES (?, ?, ?)";

        try {
            PreparedStatement sentenca = connection.prepareStatement(sql);
            sentenca.setString(1, usuario.getNome());
            sentenca.setString(2, usuario.getEmail());
            sentenca.setString(3, usuario.getSenha());

            sentenca.execute();
            sentenca.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
