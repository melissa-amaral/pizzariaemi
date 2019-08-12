package sample.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.*;
import java.util.ArrayList;

public class Pizzaria {

    private String ARQ = "pizzas.bin";

    private ObservableList<Pizza> sabores;
    private Pedido pedido;

    private static Pizzaria instance=new Pizzaria();

    private Pizzaria(){
        sabores = FXCollections.observableArrayList();
    }

    public static Pizzaria getInstance(){
        return instance;
    }

    public void cadastraPizza(String sabor, Double valor){
        Pizza p = new Pizza(sabor,valor);

        sabores.add(p);
    }

    public void abrirPedido() throws Exception{
        if(pedido == null){
            pedido = new Pedido();
        }else{
            throw new Exception("Pedido já aberto!!");
        }

    }

    public void incluirPizza(Pizza p) throws Exception{
        if(pedido != null){
            pedido.incluir(p);
        }else{
            throw new Exception("Pedido fechado!!");
        }

    }

    public Double fecharPedido() throws Exception{
        Double valor=0.0;
        if(pedido != null){
            valor = pedido.getValorTotal();
            pedido = null;
            return valor;
        }else {
            throw  new Exception("Pedido fechado!!");
        }



    }

    public ObservableList listaSabores(){
        return sabores;
    }

    public Double getValorPedido(){
        if(pedido != null){
            return pedido.getValorTotal();
        }

        return 0.0;
    }

    public ObservableList getListaPedido(){
        if(pedido != null){
            return pedido.listaPizzas();
        }else{
            return FXCollections.emptyObservableList();
        }
    }

    public void salva() throws IOException {

        File f = new File(ARQ);
        FileOutputStream fos = new FileOutputStream(f);
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeObject(new ArrayList<>(sabores));

        oos.close();
        fos.close();

    }

    public void carrega() throws IOException,ClassNotFoundException{

        File f = new File(ARQ);
        FileInputStream fis = new FileInputStream(f);
        ObjectInputStream ois = new ObjectInputStream(fis);


        ArrayList pizzas = (ArrayList) ois.readObject();

        sabores.addAll(pizzas);


        ois.close();
        fis.close();

    }


}
