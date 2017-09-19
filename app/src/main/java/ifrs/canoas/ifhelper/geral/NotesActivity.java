package ifrs.canoas.ifhelper.geral;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
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
import java.util.Locale;

import ifrs.canoas.ifhelper.R;
import ifrs.canoas.lib.EverynoteHelper;
import ifrs.canoas.lib.NoteAdapter;
import ifrs.canoas.model.Note;

public class NotesActivity extends AppCompatActivity {
    private Note note = new Note();
    private EverynoteHelper helper;


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        listNotes();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        helper = new EverynoteHelper(getApplicationContext());
        //List<Note> notesList= new ArrayList<Note>();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        listNotes();





        //notesList.addAll(Note.getAll(helper));
        //ArrayAdapter<Note> adapter = new ArrayAdapter<Note>(this,android.R.layout.simple_list_item_1,notesList);
       // ListView lv= (ListView) findViewById(R.id.noteList);
        //lv.setAdapter(adapter);
    }

    public void insertNote(View view) {
        Context context = getApplicationContext();
        Intent objIntent = new Intent(context, InsertNotesActivity.class);

        startActivity(objIntent);
        }

    private void deleteNote() {}

    private void updateNote() {}

    private void listNotes() {
        ListView notasAdicionadas = (ListView) findViewById(R.id.tvNotas);
        if (Note.getAll(helper) != null) {
            notasAdicionadas.setAdapter(new NoteAdapter(getApplicationContext(), Note.getAll(helper)));
        } else {
            //exibir mensagem de não há notas cadastradas
        }
    }

}
