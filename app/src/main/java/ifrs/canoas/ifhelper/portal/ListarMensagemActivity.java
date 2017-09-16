package ifrs.canoas.ifhelper.portal;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONObject;

import java.io.IOException;
import java.util.List;

import ifrs.canoas.ifhelper.DefaultActivity;
import ifrs.canoas.ifhelper.R;
import ifrs.canoas.ifhelper.geral.LoginActivity;
import ifrs.canoas.lib.MensagemAdapter;
import ifrs.canoas.lib.SharedPreferenceHelper;
import ifrs.canoas.lib.WebServiceUtil;
import ifrs.canoas.model.portal.Mensagem;
import ifrs.canoas.model.portal.User;

public class ListarMensagemActivity extends DefaultActivity {

    private String token;
    private User usuario;
    private ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_mensagem);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarMsg);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        if(usuario == null)
            recuperaDados();//Recuperando dados do putExtra
        else
            loadUser();
        trataFloatButton();
        setToolbar();

    }


    /**
     *
     */
    private void recuperaDados() {

        //buscar do sharedPreferences
        try{
            this.token = getIntent().getExtras().getString("token");

            Intent it = getIntent();
            if (it != null) {//Checar se veio por intent
                Bundle dados = it.getExtras();
                if (dados != null && dados.getString("token") != null) { //Checar se tem dados

                    this.token = dados.getString("token");
                    //Inicialmente preciso dos dados do user
                    loadUser();
                    return ;
                }
            }

        } catch (Exception e){
            //TODO o correto é tratar essas possíveis exceções um exemplo pode ser abrir o LoginActivity novamente
            startActivity(new Intent(getApplicationContext(), LoginActivity.class));
        }


    }

    private void geraLista(List<Mensagem> lista) {
        list = (ListView) findViewById(R.id.MensagensListView);
        MensagemAdapter ad = new MensagemAdapter(getApplicationContext(), lista);
        list.setAdapter(ad);

        //Sempre que for trabalhar com  Adapters você poderá ter esse problema
        //https://pt.stackoverflow.com/questions/48435/meu-listview-esta-sem-clique
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                Log.i("DADOS", "Para que servem?" + position + " " + id);
                Toast.makeText(getApplicationContext(), "aaaa", Toast.LENGTH_SHORT).show();

            }

        });
    }

    private void populaListaMensagens() {
        String url = "https://moodle.canoas.ifrs.edu.br/webservice/rest/server.php?" +
                "wstoken=" + this.token + "&wsfunction=core_message_get_messages&moodlewsrestformat=json&read=1"
                + "&useridto=" + usuario.getUserid() +"&type=conversations";
        new ListMensagemWebService().execute(url);

        //https://moodle.canoas.ifrs.edu.br/webservice/rest/server.php?
        // wstoken=3221a41c3ae8f524c2161567041c121b
        // &wsfunction=core_message_get_messages&type=conversations&useridto=1480
    }

    private void loadUser() {

        String url = "https://moodle.canoas.ifrs.edu.br/webservice/rest/server.php?" +
                "wstoken=" + this.token + "&wsfunction=core_webservice_get_site_info&moodlewsrestformat=json";
        new DadosDoUsuarioWebService().execute(url);

    }

    /**
     * Forma alternativa de tratar evento
     *
     *@param v
     */
    public void addMensagem(View v) {

    }

    private void trataFloatButton() {

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }

    private class ListMensagemWebService extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... urls) {
            try {
                Log.i("URL", WebServiceUtil.getContentAsString(urls[0]));
                return WebServiceUtil.getContentAsString(urls[0]);

            } catch (IOException e) {
                Log.e("Exception", e.toString());//Observe que aqui uso o log.e e não log.d
                return "Problema ao montar a requisição";
            }
        }

        // onPostExecute displays the results of the AsyncTask.
        @Override
        protected void onPostExecute(String result) {
            try {
                Gson parser = new Gson();

                JSONObject my_obj = new JSONObject(result);
                List<Mensagem> listaMensagens;
                listaMensagens = parser.fromJson(my_obj.getString("messages"), new TypeToken<List<Mensagem>>() {
                }.getType());
                geraLista(listaMensagens);
                Log.d("Mensagem", listaMensagens.get(0).toString());


            } catch (Exception e){
                Log.e("Erro",e.getMessage());
            }

            //getJSONArray("elenco")
        }


    }

    private class DadosDoUsuarioWebService extends AsyncTask<String, Void, String> {
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
            //Com o usuario posso pedir a lista das mensagens
            Gson g = new Gson();
            usuario = g.fromJson(result, User.class);
            populaListaMensagens();
            //Observe que chamo aqui o populaListaMensagem somente assim tenho certeza que os dados estão disponíveis.
            // Lembre-se assincrono é um processo pararelo e não sequencial como algoritmos.
        }


    }

}
