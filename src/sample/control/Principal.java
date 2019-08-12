package sample.control;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import sample.NavegadorCenas;
import sample.model.Pizza;
import sample.model.Pizzaria;

import javax.swing.*;

public class Principal {


    @FXML
    private ListView<Pizza> ltvSabores;

    @FXML
    private ListView<Pizza> ltvPedido;

    @FXML
    private Button btIncluir;

    @FXML
    private Button btAbrirPedido;

    @FXML
    private Button btFecharPedido;


    public void initialize(){
        ltvSabores.setItems(Pizzaria.getInstance().listaSabores());
        btFecharPedido.setDisable(true);
        btIncluir.setDisable(true);
    }

    public void abrirPedido(){
        try{
            Pizzaria.getInstance().abrirPedido();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }


    }


    public void cadastrarPizza(){

        NavegadorCenas.loadJanela(NavegadorCenas.JANELA_CADASTRO);

    }



}
