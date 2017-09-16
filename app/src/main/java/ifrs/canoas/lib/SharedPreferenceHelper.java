package ifrs.canoas.lib;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * TODO Complete a classe com os métodos para ler e salvar dados de Booleanos e doubles e ler inteiros
 */
public class SharedPreferenceHelper {
    private Context context;
    private SharedPreferences sp;
    private String file;

    /**
     * @param Context t
     * @param String  name - Nome do arquivo de SharedPreferences
     */
    public SharedPreferenceHelper(Context t, String name) {
        this.context = t;
        //Observe que o 0 é o modo do SharedPreferences que hoje só é aceito o Context.MODE_PRIVATE
        this.sp = t.getSharedPreferences(name, 0);
        this.file = name;
    }

    public SharedPreferenceHelper(Context t) {
        this.context = t;
        //Observe que o 0 é o modo do SharedPreferences que hoje só é aceito o Context.MODE_PRIVATE
        this.sp = t.getSharedPreferences(CONST.CONF_FILE, 0);
        this.file = CONST.CONF_FILE;
    }


    public void save(String chave, String valor) {

        SharedPreferences.Editor editor = sp.edit();
        editor.putString(chave, valor);

        // Commit the edits!
        editor.commit();

    }

    public void save(String chave, int valor) {
        SharedPreferences.Editor editor = sp.edit();
        editor.putInt(chave, valor);

        // Commit the edits!
        editor.commit();
    }


    public String readString(String chave) {
        return sp.getString(chave, "DEFAULT_VALUE");
    }

    public String readString(String chave, String defaultValue) {
        return sp.getString(chave, defaultValue);
    }

    public int readInt(String chave, int i) {
        return sp.getInt(chave, i);
    }
}
