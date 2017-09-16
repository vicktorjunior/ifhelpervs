package ifrs.canoas.model;

import java.util.ArrayList;

/**
 * Created by marcio on 06/08/17.
 */

public class MediaHarmonicaCalculator {
    private ArrayList<ItemMedia> notas = new ArrayList();

    public void addNota(String label, double peso, double media){
        //TODO adicionar no arrayList
    }

    /**
     * TODO verificar médias >0 ou 0,0001
     * TODO verificar se a soma dos pesos é igual a 10
     * TODO calcular
     *
     * @return
     * @throws Exception
     */
    public double calcula() throws Exception {
        double media = 0;
        if(notas.size()>2){

        }else{
            throw new Exception("Quantidade de notas insuficientes");
        }
        return media;
    }
}
