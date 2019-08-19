package sample.model;

import java.io.Serializable;

public class Pizza implements Serializable {

    private int id;
    private String sabor;
    private Double valor;

    public Pizza(int id, String sabor, Double valor){
        this(sabor,valor);
        this.id = id;
    }

    public Pizza(String sabor, Double valor) {
        this.sabor = sabor;
        this.valor = valor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSabor() {
        return sabor;
    }

    public void setSabor(String sabor) {
        this.sabor = sabor;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String toString(){
        return sabor+"(R$ "+valor+")";
    }


}
