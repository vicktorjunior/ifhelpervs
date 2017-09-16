package ifrs.canoas.ifhelper;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import ifrs.canoas.ifhelper.geral.CalculaFaltasActivity;
import ifrs.canoas.ifhelper.geral.LoginActivity;

//Selecione a aba de todo e resolva todos eles inclusive esse
//TODO transformar essa tela no idioma Inglês e Português (caso não tenha feito) 0,5
//TODO adicionar um icone para cada Botão. (caso não tenha feito) 0,5
//TODO adicionar métodos para todas as funções da atividade principal (caso não tenha feito) 0,5
//TODO Submeter a atividade como um novo branch ou um novo projeto. Informar corretamente o link

//Basic activity com floatButton removido
public class MainActivity extends DefaultActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setToolbar();//Método que inicia a toolbar
    }

    /**
     * Evento criado para servir como método de listener.
     *
     * @param v
     */
    public void calculaFaltas(View v) {

        Context contexto = getApplicationContext();
        Intent objIntent = new Intent(contexto, CalculaFaltasActivity.class);

        startActivity(objIntent);
    }

    public void calendarioAcademico(View v){
        Intent objIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.canoas.ifrs.edu.br/site/midias/arquivos/2017625103324485calendario_academico_2017.pdf"));
        startActivity(objIntent);
    }

    //TODO add Botão calculadora de notas.


    /**
     * Chamada para atividade que realiza o login no MOODLE.
     *
     * @param v
     */
    public void loginMoodle(View v){
        startActivity(new Intent(this, LoginActivity.class));
    }
}
