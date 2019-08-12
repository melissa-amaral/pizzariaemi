package sample.control;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import sample.NavegadorCenas;
import sample.model.Pizzaria;

public class JanelaCadastro {

    @FXML
    private TextField tfSabor;

    @FXML
    private TextField tfValor;

    public void cadastrar(){

        String sabor = tfSabor.getText();
        Double valor = Double.valueOf(tfValor.getText());
        Pizzaria.getInstance().cadastraPizza(sabor,valor);

        voltar();
    }

    public void voltar(){
        NavegadorCenas.loadJanela(NavegadorCenas.PRINCIPAL);
    }

}
