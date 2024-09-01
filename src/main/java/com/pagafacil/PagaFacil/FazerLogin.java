package com.pagafacil.PagaFacil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FazerLogin {

    // URL do banco de dados, usuário e senha do banco
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/PAGAFACIL";
    private static final String DB_USER = "postgres";
    private static final String DB_PASSWORD = "root";

    public static void main(String[] args) {
        String cnpj = "usuario";
        String senha = "senha123";

        if (login(cnpj, senha)) {
            System.out.println("Login realizado com sucesso!");
        } else {
            System.out.println("Nome de usuário ou senha incorretos.");
        }
    }

    public static boolean login(String username, String password) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            // Conectar ao banco de dados
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            // Query para verificar as credenciais
            String sql = "SELECT * FROM usuarios WHERE cnpj = ? AND senha = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

            // Executar a query
            resultSet = preparedStatement.executeQuery();

            // Verificar se existe algum resultado
            return resultSet.next();

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            // Fechar as conexões
            try {
                if (resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
