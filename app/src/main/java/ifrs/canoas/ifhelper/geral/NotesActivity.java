package ifrs.canoas.ifhelper.geral;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CursorAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ifrs.canoas.ifhelper.R;
import ifrs.canoas.lib.EverynoteHelper;
import ifrs.canoas.model.Note;

public class NotesActivity extends AppCompatActivity {
    private Note note = new Note();
    private EverynoteHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //List<Note> notesList= new ArrayList<Note>();
        helper = new EverynoteHelper(getApplicationContext());
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        TextView notasAdicionadas = (TextView) findViewById(R.id.tvNotas);
        notasAdicionadas.setText(notasAdicionadas.getText() + note.listToString(Note.getAll(helper)));

        //notesList.addAll(Note.getAll(helper));
        //ArrayAdapter<Note> adapter = new ArrayAdapter<Note>(this,android.R.layout.simple_list_item_1,notesList);
       // ListView lv= (ListView) findViewById(R.id.noteList);
        //lv.setAdapter(adapter);
    }

    public void insertNote(View view) {

            EditText title = (EditText) findViewById(R.id.txtTitulo);
            EditText text = (EditText) findViewById(R.id.txtDescricao);
            EditText discipline = (EditText) findViewById(R.id.txtDisciplina);
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            note.setData(sdf.format(new Date()));
            note.setDisciplina(discipline.getText().toString());
            note.setTexto(text.getText().toString());
            note.setTitulo(title.getText().toString());
            if (!(title.getText().toString().isEmpty() || text.getText().toString().isEmpty() || discipline.getText().toString().isEmpty()))
                note.insert(helper);
            title.setText("");
            text.setText("");
            discipline.setText("");
            view.refreshDrawableState();
            //Log.d("DEBUG", "Notas " + Note.getAll(dbHelper).toString() + " " + Note.getAll(dbHelper).size());
        }

    private void deleteNote() {}

    private void updateNote() {}

    private void listNotes(EverynoteHelper helper) {
        Note note = new Note();
        List<Note> noteList = new ArrayList<Note>();
        ListView listView = (ListView) findViewById(R.id.noteList);
        noteList.addAll(Note.getAll(helper));
        // initialize listview
       // listView.setAdapter(new CustomAdapterArrayAdapter(NotesActivity.this,noteList));
        // set the custom adapter to listview
    }

}
