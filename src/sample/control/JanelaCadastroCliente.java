package sample.control;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import sample.NavegadorCenas;
import sample.model.Pizzaria;

public class JanelaCadastroCliente {
    @FXML
    private TextField tfNome;

    @FXML
    private TextField tfTelefone;

    @FXML
    private TextField tfAnoNascimento;

        public void cadastrar(){

        String nome = tfNome.getText();
        String telefone = tfTelefone.getText();
        int anoNascimento = Integer.valueOf(tfAnoNascimento.getText());
        Pizzaria.getInstance().cadastraCliente(nome,telefone,anoNascimento);

        voltar();
    }

    public void voltar(){
        NavegadorCenas.loadJanela(NavegadorCenas.PRINCIPAL);
    }

}
