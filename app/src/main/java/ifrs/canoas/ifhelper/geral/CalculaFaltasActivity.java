package ifrs.canoas.ifhelper.geral;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import ifrs.canoas.ifhelper.R;
import ifrs.canoas.model.FaltaCalculator;

public class CalculaFaltasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calcula_faltas);

    }

    public void calcula(View v) {
        EditText numCreditosTv = (EditText) findViewById(R.id.numCreditos);
        EditText faltasTv = (EditText) findViewById(R.id.diasComFalta);
        FaltaCalculator fc = new FaltaCalculator(Integer.parseInt(numCreditosTv.getText().toString()));
        fc.setTotalFaltas(Integer.parseInt(faltasTv.getText().toString()));

        Log.d("DEBUG", "Frequencia" + fc.calculaFrequencia());

        TextView resultado = (TextView) findViewById(R.id.resultado);
        resultado.setText(fc.calculaFrequencia() + "%");
    }
}
