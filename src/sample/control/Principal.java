package sample.control;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.text.Text;
import sample.NavegadorCenas;
import sample.model.Pedido;
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

    @FXML
    private Text txtValor;

    ObservableList<Pizza> sabores;


    public void initialize(){
        ltvSabores.setItems(Pizzaria.getInstance().listaSabores());
        btFecharPedido.setDisable(true);
        btIncluir.setDisable(true);
    }

    public void abrirPedido(){
        try{
            Pizzaria.getInstance().abrirPedido();
            ltvPedido.setItems(Pizzaria.getInstance().getListaPedido());
            btFecharPedido.setDisable(false);
            btIncluir.setDisable(false);
        }catch (Exception e){
            mensagem(Alert.AlertType.ERROR,e.getMessage());
        }
    }

    public void incluirPizza(){
        Pizza p = ltvSabores.getSelectionModel().getSelectedItem();

        try{
            if(p!=null){
                Pizzaria.getInstance().incluirPizza(p);
                txtValor.setText("Valor Total R$:"+Pizzaria.getInstance().getValorPedido());
            }
        }catch (Exception e){
            mensagem(Alert.AlertType.ERROR,e.getMessage());
        }
    }

    public void fecharPedido(){
        try{
                double valor = Pizzaria.getInstance().fecharPedido();
                mensagem(Alert.AlertType.CONFIRMATION,"O valor do pedido é R$ "+valor);

                ltvPedido.setItems(null);

                btFecharPedido.setDisable(true);
                btIncluir.setDisable(true);
            txtValor.setText("Valor Total R$:");


        }catch (Exception e){
            mensagem(Alert.AlertType.ERROR,e.getMessage());
        }
    }



    public void cadastrarPizza(){

        NavegadorCenas.loadJanela(NavegadorCenas.JANELA_CADASTRO);

    }

    private void mensagem(Alert.AlertType type, String msg){
        Alert alert = new Alert(type,msg);
        alert.showAndWait();
    }


}
