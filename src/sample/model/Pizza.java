package sample.model;

public class Pizza {

    private String sabor;
    private Double valor;

    public Pizza(String sabor, Double valor) {
        this.sabor = sabor;
        this.valor = valor;
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
