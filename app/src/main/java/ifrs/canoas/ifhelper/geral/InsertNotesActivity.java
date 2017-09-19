package ifrs.canoas.ifhelper.geral;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import ifrs.canoas.ifhelper.R;
import ifrs.canoas.lib.EverynoteHelper;
import ifrs.canoas.model.Note;

public class InsertNotesActivity extends AppCompatActivity {
    private Note note = new Note();
    private EverynoteHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_notes);
    }

    public void saveNote(View view) {
        helper = new EverynoteHelper(getApplicationContext());
        EditText title = (EditText) findViewById(R.id.txtTitulo);
        EditText text = (EditText) findViewById(R.id.txtDescricao);
        EditText discipline = (EditText) findViewById(R.id.txtDisciplina);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
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
}
