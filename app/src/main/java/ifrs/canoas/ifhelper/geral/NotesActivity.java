package ifrs.canoas.ifhelper.geral;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ifrs.canoas.ifhelper.R;
import ifrs.canoas.lib.EverynoteContract;
import ifrs.canoas.lib.EverynoteHelper;
import ifrs.canoas.lib.NoteAdapter;
import ifrs.canoas.model.Note;

public class NotesActivity extends AppCompatActivity {
    private Note note = new Note();
    private EverynoteHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //List<Note> notesList= new ArrayList<Note>();
        helper = new EverynoteHelper(getBaseContext());
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

        listNotes(helper);
    }

    public void insertNote(View view) {
        Context contexto = getApplicationContext();
        Intent objIntent = new Intent(contexto,InsertNotesActivity.class);

        startActivity(objIntent);
        listNotes(helper);

    }

    private void deleteNote() {}

    private void updateNote() {

    }

    private void listNotes(EverynoteHelper helper) {
        ListView notasAdicionadas = (ListView) findViewById(R.id.tvNotas);
        if (Note.getAll(helper) != null)
            notasAdicionadas.setAdapter(new NoteAdapter(getApplicationContext(), Note.getAll(helper)));
    }

}
