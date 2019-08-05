package sample.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Pizzaria {

    private ObservableList<Pizza> sabores;
    private Pedido pedido;

    private static Pizzaria instance=new Pizzaria();

    private Pizzaria(){
        sabores = FXCollections.emptyObservableList();
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
        }
        throw new Exception("Pedido já aberto!!");
    }

    public void incluirPizza(Pizza p) throws Exception{
        if(pedido != null){
            pedido.incluir(p);
        }
        throw new Exception("Pedido fechado!!");
    }

    public Double fecharPedido() throws Exception{
        Double valor=0.0;
        if(pedido != null){
            valor = pedido.getValorTotal();
            pedido = null;
            return valor;
        }

        throw  new Exception("Pedido fechado!!");

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
        }
        return FXCollections.emptyObservableList();

    }


}
