package ifdminterfaces;

import java.sql.*;
import javax.swing.*;

public class Process {

    private String driver = "com.mysql.cj.jdbc.Driver";
    private String url = "jdbc:mysql://127.0.0.1/" + "dbifdm";
    private String usuario = "root";
    private String senha = "";

    public void carregarEstados(JComboBox<String> comboBox) {
        try {
            Class.forName(driver);
            Connection conexao = DriverManager.getConnection(url, usuario, senha);
            System.out.println("Conexão realizada com sucesso");

            Statement st = conexao.createStatement();
            ResultSet rs = st.executeQuery("SELECT DISTINCT sigla_uf FROM ifdm_empregoerenda ORDER BY sigla_uf");
            
            while (rs.next()) {
            String sigla = rs.getString("sigla_uf");
            comboBox.addItem(sigla);
            }            
           
            conexao.close();
        } catch (ClassNotFoundException e) {
            System.out.println("Driver não encontrado: " + e);
        } catch (SQLException e) {
            System.out.println("Erro ao acessar o banco: " + e);
        }
    }
    
    public void carregarMunic(String siglaUf, JComboBox<String> comboBox) {
        try {
            Class.forName(driver);
            Connection conexao = DriverManager.getConnection(url, usuario, senha);
            System.out.println("Conexão realizada com sucesso");
            
            String sql = "SELECT DISTINCT nome_munic FROM ifdm_empregoerenda WHERE sigla_uf = ? ORDER BY nome_munic";
            PreparedStatement pst = conexao.prepareStatement(sql);
            pst.setString(1, siglaUf);
            
            ResultSet rs = pst.executeQuery();
            
            comboBox.removeAllItems();
            
            while (rs.next()) {
            String cidade = rs.getString("nome_munic");
            comboBox.addItem(cidade);
            }

            rs.close();
            pst.close();
            
            conexao.close();
        } catch (ClassNotFoundException e) {
            System.out.println("Driver não encontrado: " + e);
        } catch (SQLException e) {
            System.out.println("Erro ao acessar o banco: " + e);
        }
    }
    
    public void carregarDadoSaudeUF(String siglaUf, JTextField saudeUfJtf) {
        try {
            
            Class.forName(driver);
            Connection conexao = DriverManager.getConnection(url, usuario, senha);
            System.out.println("Conexão realizada com sucesso");
            
            String sql = "SELECT sigla_uf, ROUND(( IFNULL(ifdm_saude_2013, 0) + IFNULL(ifdm_saude_2014, 0) + IFNULL(ifdm_saude_2015, 0) + IFNULL(ifdm_saude_2016, 0) + IFNULL(ifdm_saude_2017, 0) + IFNULL(ifdm_saude_2018, 0) + IFNULL(ifdm_saude_2019, 0) + IFNULL(ifdm_saude_2020, 0) + IFNULL(ifdm_saude_2021, 0) + IFNULL(ifdm_saude_2022, 0) + IFNULL(ifdm_saude_2023, 0) ) / 11, 4) AS media_ifdm_saude FROM ifdm_saude WHERE sigla_uf = ? GROUP BY sigla_uf;";
            PreparedStatement pst = conexao.prepareStatement(sql);
            pst.setString(1, siglaUf);
            
            ResultSet rs = pst.executeQuery();
            
            while (rs.next()) {
                saudeUfJtf.setText(rs.getString("media_ifdm_saude"));
            }
            
            rs.close();
            pst.close();
            conexao.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void carregarDadoEducacaoUF(String siglaUf, JTextField eduUfJtf) {
        try {
            
            Class.forName(driver);
            Connection conexao = DriverManager.getConnection(url, usuario, senha);
            System.out.println("Conexão realizada com sucesso");
            
            String sql = "SELECT sigla_uf, ROUND(( IFNULL(ifdm_educacao_2013, 0) + IFNULL(ifdm_educacao_2014, 0) + IFNULL(ifdm_educacao_2015, 0) + IFNULL(ifdm_educacao_2016, 0) + IFNULL(ifdm_educacao_2017, 0) + IFNULL(ifdm_educacao_2018, 0) + IFNULL(ifdm_educacao_2019, 0) + IFNULL(ifdm_educacao_2020, 0) + IFNULL(ifdm_educacao_2021, 0) + IFNULL(ifdm_educacao_2022, 0) + IFNULL(ifdm_educacao_2023, 0) ) / 11, 4) AS media_ifdm_educacao FROM ifdm_educacao WHERE sigla_uf = ? GROUP BY sigla_uf;";
            PreparedStatement pst = conexao.prepareStatement(sql);
            pst.setString(1, siglaUf);
            
            ResultSet rs = pst.executeQuery();
            
            while (rs.next()) {
                eduUfJtf.setText(rs.getString("media_ifdm_educacao"));
            }
            
            rs.close();
            pst.close();
            conexao.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void carregarDadoRendaUF(String siglaUf, JTextField rendaUfJtf) {
        try {
            
            Class.forName(driver);
            Connection conexao = DriverManager.getConnection(url, usuario, senha);
            System.out.println("Conexão realizada com sucesso");
            
            String sql = "SELECT sigla_uf, ROUND(( IFNULL(ifdm_emprego_2013, 0) + IFNULL(ifdm_emprego_2014, 0) + IFNULL(ifdm_emprego_2015, 0) + IFNULL(ifdm_emprego_2016, 0) + IFNULL(ifdm_emprego_2017, 0) + IFNULL(ifdm_emprego_2018, 0) + IFNULL(ifdm_emprego_2019, 0) + IFNULL(ifdm_emprego_2020, 0) + IFNULL(ifdm_emprego_2021, 0) + IFNULL(ifdm_emprego_2022, 0) + IFNULL(ifdm_emprego_2023, 0) ) / 11, 4) AS media_ifdm_emprego FROM ifdm_empregoerenda WHERE sigla_uf = ? GROUP BY sigla_uf;"; 
            PreparedStatement pst = conexao.prepareStatement(sql);
            pst.setString(1, siglaUf);
            
            ResultSet rs = pst.executeQuery();
            
            while (rs.next()) {
                rendaUfJtf.setText(rs.getString("media_ifdm_emprego"));
            }
            
            rs.close();
            pst.close();
            conexao.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void carregarDadoIfdmUF(String siglaUf, JTextField ifdmUfJtf) {
        try {
            
            Class.forName(driver);
            Connection conexao = DriverManager.getConnection(url, usuario, senha);
            System.out.println("Conexão realizada com sucesso");
            
            String sql = "SELECT sigla_uf, ROUND(( IFNULL(ifdm_2013, 0) + IFNULL(ifdm_2014, 0) + IFNULL(ifdm_2015, 0) + IFNULL(ifdm_2016, 0) + IFNULL(ifdm_2017, 0) + IFNULL(ifdm_2018, 0) + IFNULL(ifdm_2019, 0) + IFNULL(ifdm_2020, 0) + IFNULL(ifdm_2021, 0) + IFNULL(ifdm_2022, 0) + IFNULL(ifdm_2023, 0) ) / 11, 4) AS media_ifdm_geral FROM ifdm_geral WHERE sigla_uf = ? GROUP BY sigla_uf;";
            PreparedStatement pst = conexao.prepareStatement(sql);
            pst.setString(1, siglaUf);
            
            ResultSet rs = pst.executeQuery();
            
            while (rs.next()) {
                ifdmUfJtf.setText(rs.getString("media_ifdm_geral"));
            }
            
            rs.close();
            pst.close();
            conexao.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
     
     //medias das cidades
     
    public void carregarDadoCidade(String cidade, JTextField saudeCidJtf) {
        try {
            
            Class.forName(driver);
            Connection conexao = DriverManager.getConnection(url, usuario, senha);
            System.out.println("Conexão realizada com sucesso");
            
            String sql = "SELECT AVG(( IFNULL(ifdm_saude_2013, 0) + IFNULL(ifdm_saude_2014, 0) + IFNULL(ifdm_saude_2015, 0) + IFNULL(ifdm_saude_2016, 0) + IFNULL(ifdm_saude_2017, 0) + IFNULL(ifdm_saude_2018, 0) + IFNULL(ifdm_saude_2019, 0) + IFNULL(ifdm_saude_2020, 0) + IFNULL(ifdm_saude_2021, 0) + IFNULL(ifdm_saude_2022, 0) + IFNULL(ifdm_saude_2023, 0) ) / 11.0) AS media_ifdm_saude FROM ifdm_saude WHERE nome_munic = ?;";
            PreparedStatement pst = conexao.prepareStatement(sql);
            pst.setString(1, cidade);
            
            ResultSet rs = pst.executeQuery();
            
            while (rs.next()) {
                saudeCidJtf.setText(rs.getString("media_ifdm_saude"));
            }
            
            rs.close();
            pst.close();
            conexao.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void carregarDadoEducacaoCid(String cidade, JTextField eduCidJtf) {
        try {
            
            Class.forName(driver);
            Connection conexao = DriverManager.getConnection(url, usuario, senha);
            System.out.println("Conexão realizada com sucesso");
            
            String sql = "SELECT AVG(( IFNULL(ifdm_educacao_2013, 0) + IFNULL(ifdm_educacao_2014, 0) + IFNULL(ifdm_educacao_2015, 0) + IFNULL(ifdm_educacao_2016, 0) + IFNULL(ifdm_educacao_2017, 0) + IFNULL(ifdm_educacao_2018, 0) + IFNULL(ifdm_educacao_2019, 0) + IFNULL(ifdm_educacao_2020, 0) + IFNULL(ifdm_educacao_2021, 0) + IFNULL(ifdm_educacao_2022, 0) + IFNULL(ifdm_educacao_2023, 0) ) / 11.0) AS media_ifdm_educacao FROM ifdm_educacao WHERE nome_munic = ?;";
            PreparedStatement pst = conexao.prepareStatement(sql);
            pst.setString(1, cidade);
            
            ResultSet rs = pst.executeQuery();
            
            while (rs.next()) {
                eduCidJtf.setText(rs.getString("media_ifdm_educacao"));
            }
            
            rs.close();
            pst.close();
            conexao.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
     
    
}
