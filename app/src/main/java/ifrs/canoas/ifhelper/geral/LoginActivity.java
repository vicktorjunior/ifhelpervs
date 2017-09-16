package ifrs.canoas.ifhelper.geral;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import ifrs.canoas.ifhelper.R;
import ifrs.canoas.ifhelper.portal.ListarCursoActivity;
import ifrs.canoas.ifhelper.portal.ListarMensagemActivity;
import ifrs.canoas.lib.SharedPreferenceHelper;
import ifrs.canoas.lib.WebServiceUtil;
import ifrs.canoas.model.portal.LoginRetorno;

public class LoginActivity extends AppCompatActivity {

    private TextView mensagem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mensagem = (TextView) findViewById(R.id.message);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void login(View v) {
        Log.d("Teste","testando botão");
        EditText usuario =  (EditText) findViewById(R.id.login);
        EditText senha =  (EditText) findViewById(R.id.senha);

        String uri = "http://moodle.canoas.ifrs.edu.br/login/token.php";

        try {
            uri += "?username=" + usuario.getText().toString() +
                    "&password=" + URLEncoder.encode(senha.getText().toString(), "utf-8") +
                    "&service=moodle_mobile_app";

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        DownloadWebpageTask  tarefa = new DownloadWebpageTask();
        tarefa.execute(uri);
    }

    private void processaRetorno(LoginRetorno retorno) {
        if (retorno.getToken() == "Nenhum") {
            mensagem.setText(retorno.getError());
        } else {
            //Vamos criar um bundle para passar as info para outra tela e como alternativa seria usar variável estática.
            //Intent intent = new Intent(getApplicationContext(), ListarCursoActivity.class);
            Intent intent = new Intent(getApplicationContext(), ListarMensagemActivity.class);
            intent.putExtra("token", retorno.getToken());//Observar que o putExtra tem várias assinaturas
            startActivity(intent);
        }
    }


    private class DownloadWebpageTask extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... urls) {
            try {
                return WebServiceUtil.getContentAsString(urls[0]);
            } catch (IOException e) {
                Log.e("Exception", e.toString());//Observe que aqui uso o log.e e não log.d
                return "Problema ao montar a requisição";
            }
        }

        // onPostExecute displays the results of the AsyncTask.
        @Override
        protected void onPostExecute(String result) {
            Log.d("teste", result);
            Gson g = new Gson();
            LoginRetorno retorno = g.fromJson(result.trim(), LoginRetorno.class);
            Log.d("Teste", retorno.toString());
            processaRetorno(retorno);
        }
    }




}
