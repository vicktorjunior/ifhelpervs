package ifrs.canoas.model;

/**
 * Created by marcio on 06/08/17.
 */

class ItemMedia {
    private String name;
    private double nota;
    private double peso;


    public ItemMedia(String name, double nota, double peso) {
        this.name = name;
        this.nota = nota;
        this.peso = peso;
    }

    public String getName() {
        return name;
    }

    public ItemMedia setName(String name) {
        this.name = name;
        return this;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }



}
