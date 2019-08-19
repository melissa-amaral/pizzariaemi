package sample.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAOImpl implements ClienteDAO {

    @Override
    public Cliente insere(String nome, String telefone, int anoNascimento) throws SQLException{
        Cliente c = new Cliente(nome, telefone, anoNascimento);

        Connection con = DriverManager.getConnection("jdbc:sqlite:pizzappemi.sqlite");

        PreparedStatement stm = con.prepareStatement("INSERT INTO CLIENTES(NOME,TELEFONE,ANONASCIMENTO) VALUES (?,?,?)");

        stm.setString(1,c.getNome());
        stm.setString(2,c.getTelefone());
        stm.setInt(3,c.getAnoNascimento());

        stm.executeUpdate();

        stm.close();
        con.close();

        return c;
    }

    @Override
    public Cliente atualiza(Cliente c) throws SQLException {
        Connection con = DriverManager.getConnection("jdbc:sqlite:pizzappemi.sqlite");

        PreparedStatement stm = con.prepareStatement("UPDATE CLIENTES SET NOME=?, TELEFONE=?, ANONASCIMENTO=? WHERE id=?");

        stm.setString(1,c.getNome());
        stm.setString(2,c.getTelefone());
        stm.setInt(3,c.getAnoNascimento());
        stm.setInt(4,c.getId());

        stm.executeUpdate();

        stm.close();
        con.close();

        return c;
    }

    @Override
    public boolean remove(Cliente c) throws SQLException {
        Connection con = DriverManager.getConnection("jdbc:sqlite:pizzappemi.sqlite");

        PreparedStatement stm = con.prepareStatement("DELETE FROM CLIENTES WHERE id=?");

        stm.setInt(1,c.getId());

        stm.executeUpdate();

        stm.close();
        con.close();

        return true;
    }

    @Override
    public Cliente buscaId(int id) throws SQLException {
        Cliente c = null;

        Connection con = DriverManager.getConnection("jdbc:sqlite:pizzappemi.sqlite");

        PreparedStatement stm = con.prepareStatement("SELECT * FROM CLIENTES where id=?");

        stm.setInt(1,id);

        ResultSet res = stm.executeQuery();

        while(res.next()){
            String nome = res.getString("NOME");
            String telefone = res.getString("NOME");
            int anoNascimento = res.getInt("ANONASCIMENTO");

            c = new Cliente(id,nome,telefone,anoNascimento);
        }

        res.close();
        stm.close();
        con.close();

        return c;
    }

    @Override
    public List<Cliente> lista() throws SQLException {
        ArrayList<Cliente> clientes = new ArrayList<>();

        Connection con = DriverManager.getConnection("jdbc:sqlite:pizzappemi.sqlite");
        PreparedStatement stm = con.prepareStatement("SELECT * FROM CLIENTES");

        ResultSet rs = stm.executeQuery();


        while(rs.next()){
            int id = rs.getInt("ID");
            String nome = rs.getString("NOME");
            String telefone = rs.getString("NOME");
            int anoNascimento = rs.getInt("ANONASCIMENTO");

            Cliente c = new Cliente(id,nome,telefone,anoNascimento);

            clientes.add(c);
        }


        rs.close();
        stm.close();
        con.close();

        return clientes;
    }
}
