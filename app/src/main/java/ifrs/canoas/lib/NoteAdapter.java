package ifrs.canoas.lib;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import ifrs.canoas.ifhelper.R;
import ifrs.canoas.ifhelper.geral.NotesActivity;
import ifrs.canoas.model.Note;

/**
 * Created by VictorJr on 19/09/2017.
 */

public class NoteAdapter extends BaseAdapter {

    private Context context;
    private List<Note> list;

    public NoteAdapter(Context context, List<Note> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return list.get(i).getIdNota();
    }

    @Override
    public View getView(int position, View elemento, ViewGroup pai) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        final LinearLayout layout = (LinearLayout) inflater.inflate(R.layout.note_elemento, null);

        TextView titulo = (TextView) layout.findViewById(R.id.notaTitulo);
        final TextView descricao = (TextView) layout.findViewById(R.id.notaTexto);

        final Note nota = (Note) this.getItem(position);
        titulo.setText(nota.getTitulo());

        String desc = nota.getTexto().replaceAll("\\<.*?>", "");

        int tam = desc.length() > 100 ? 100 : desc.length();

        final String finalDesc = desc.substring(0, tam) + "...";

        descricao.setText(finalDesc);

        Button btDelete = (Button) layout.findViewById(R.id.notaDelete);
        //Button btEdit = (Button) layout.findViewById(R.id.notaEdit);

        btDelete.setOnClickListener(
                new View.OnClickListener() {

                    private boolean toogle = true;

                    @Override
                    public void onClick(View view) {
                        EverynoteHelper everynoteHelper = new EverynoteHelper(context);
                        Log.d("debug", "listener delete acionada!");
                        nota.delete(everynoteHelper);
                    }
                });




        return layout;
    }
}
