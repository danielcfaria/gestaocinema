/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;


public class Cliente {
   private long idCliente;
   private String nome;
   private String morada;
   private String cPostal;

   public Cliente(){
   }

    public long getIdCliente() {
        return idCliente;
    }

    public String getNome() {
        return nome;
    }

    public String getMorada() {
        return morada;
    }

    public String getcPostal() {
        return cPostal;
    }

    /*public void setIdCliente(long idCliente) {
        this.idCliente = idCliente;
    }*/

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public void setcPostal(String cPostal) {
        this.cPostal = cPostal;
    } 
    
    public void create() throws SQLException{
        Connection con = Util.criarConexao();
        String sqlCommand = "INSERT INTO CLIENTE COLUMNS (NOME,MORADA,CPOSTAL)" + "VALUES('" + this.nome + "','" + this.morada + "','"+ this.cPostal + "',)";
        Statement stmt = con.prepareStatement(sqlCommand);
        stmt.execute(sqlCommand);
    }
    
    public static List<Cliente> retrieveAll(){
        return null;
    }

    public void createGOOD() throws SQLException{
        Connection conn = Util.criarConexao();
        String sqlCommand = "INSERT INTO CLIENTE COLUMNS (NOME,MORADA,CPOSTAL)" + "VALUES(?,?,?)";
        PreparedStatement stmt = conn.prepareStatement(sqlCommand);
        stmt.setString(1, this.nome);
        stmt.setString(2, this.morada);
        stmt.setString(3, this.cPostal);
        stmt.execute();
    }
    
    public void retrieve (long idCliente) throws SQLException, IllegalArgumentException{
        Connection con = Util.criarConexao();
        String sqlCommand = "Select idcliente, nome, morada, cpostal from Cliente where idcliente = ?";
        PreparedStatement stmt = con.prepareStatement(sqlCommand);
        stmt.setLong(1, idCliente);
        ResultSet rs = stmt.executeQuery() ;
        if (rs.next()) {
            this.idCliente = rs.getLong("idCliente") ;
            this.nome = rs.getString("Nome") ;
            this.morada = rs.getString("Morada") ;
            this.cPostal = rs.getString("CPostal") ;
        }else{
            throw new IllegalArgumentException ("Parametro idCliente está errado") ;
        }
    }
    
    public void update () throws SQLException {
        Connection con = Util.criarConexao();
        String sqlCommand = "update cliente set nome = ?, Morada = ?, CPostal = ? where idcliente = ?";
        PreparedStatement stmt = con.prepareStatement(sqlCommand);
        stmt.setString(1, this.nome);
        stmt.setString(2, this.morada);
        stmt.setString(3, this.cPostal);
        stmt.setLong(4, this.idCliente);
        stmt.execute();
    }
    
    public void delete () throws SQLException {
        Connection con = Util.criarConexao();
        String sqlCommand = "Delete CLIENTE where idcliente = ?";
        PreparedStatement stmt = con.prepareStatement(sqlCommand);
        stmt.setLong(1, this.idCliente);
        stmt.execute();
    }
}
