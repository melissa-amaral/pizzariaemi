package sample;

import sample.model.Pizza;

import java.sql.*;
import java.util.ArrayList;

public class Main2 {


    public static void main(String[] args) {

        try{
            /*Pizza p = new Pizza("bananacaxi",100.0);

            Connection con = DriverManager.getConnection("jdbc:sqlite:pizzappemi.sqlite");


            PreparedStatement stm = con.prepareStatement("INSERT INTO Pizzas(sabor,valor) VALUES (?,?)");

            stm.setString(1,p.getSabor());
            stm.setDouble(2,p.getValor());

            stm.executeUpdate();

            stm.close();
            con.close();*/


            Connection con = DriverManager.getConnection("jdbc:sqlite:pizzappemi.sqlite");
            PreparedStatement stm = con.prepareStatement("SELECT * FROM Pizzas");

            ResultSet rs = stm.executeQuery();

            ArrayList<Pizza> pizzas = new ArrayList<>();

            while(rs.next()){
                int id = rs.getInt("id");
                String sabor = rs.getString("sabor");
                double valor = rs.getDouble("valor");

                Pizza p = new Pizza(sabor,valor);

                pizzas.add(p);
            }

            System.out.println(pizzas);

            rs.close();
            stm.close();
            con.close();




        }catch (SQLException e){
            e.printStackTrace();
        }




    }


}
