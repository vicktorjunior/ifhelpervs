package ifrs.canoas.model;

/**
 * Created by marcio on 28/08/16.
 */
public class FaltaCalculator {
    private int numCreditos = 4;
    private int totalAulas;
    private int totalFaltas = 0;
    private int totalSemanas = 20;

    public FaltaCalculator(int numCreditos) {
        this.numCreditos = numCreditos;
        totalAulas = this.numCreditos * this.totalSemanas;
    }

    public int calculaFrequencia() {
        return (totalAulas - (totalFaltas * numCreditos)) * 100 / totalAulas;
    }


    public int getNumCreditos() {
        return numCreditos;
    }

    public void setNumCreditos(int numCreditos) {
        this.numCreditos = numCreditos;
    }

    public int getTotalAulas() {
        return totalAulas;
    }

    public void setTotalAulas(int totalAulas) {
        this.totalAulas = totalAulas;
    }

    public int getTotalFaltas() {
        return totalFaltas;
    }

    public void setTotalFaltas(int totalFaltas) {
        this.totalFaltas = totalFaltas;
    }
}
