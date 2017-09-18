package ifrs.canoas.model;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.widget.ThemedSpinnerAdapter;

import java.util.ArrayList;
import java.util.List;

import ifrs.canoas.lib.EverynoteContract;
import ifrs.canoas.lib.EverynoteHelper;

/**
 * Created by developer on 18/09/17.
 */

public class Note {
    private int idNota;
    private String titulo;
    private String data;
    private String texto;
    private String disciplina;

    public Note() {
    }



    public Note(int idNota) {
        this.idNota = idNota;
    }

    public int getIdNota() {
        return idNota;
    }

    public void setIdNota(int idNota) {
        this.idNota = idNota;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public void insert(EverynoteHelper everynoteHelper){
        // Gets the data repository in write mode
        SQLiteDatabase db = everynoteHelper.getWritableDatabase();

        // Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(EverynoteContract.FeedEntry.COLUMN_NAME_TITULO, titulo);
        values.put(EverynoteContract.FeedEntry.COLUMN_NAME_TEXTO, texto);
        values.put(EverynoteContract.FeedEntry.COLUMN_NAME_DATA, data);
        values.put(EverynoteContract.FeedEntry.COLUMN_NAME_DISCIPLINA, disciplina);

        // Insert the new row, returning the primary key value of the new row
        long newRowId = db.insert(EverynoteContract.FeedEntry.TABLE_NAME, null, values);

    }

    public void update(EverynoteHelper everynoteHelper){
        SQLiteDatabase db = everynoteHelper.getReadableDatabase();

        // New value for one column
        ContentValues values = new ContentValues();
        values.put(EverynoteContract.FeedEntry.COLUMN_NAME_TITULO, titulo);
        values.put(EverynoteContract.FeedEntry.COLUMN_NAME_TEXTO, texto);
        values.put(EverynoteContract.FeedEntry.COLUMN_NAME_DATA, data);
        values.put(EverynoteContract.FeedEntry.COLUMN_NAME_DISCIPLINA, disciplina);


        // Which row to update, based on the title
        String selection = EverynoteContract.FeedEntry._ID + " LIKE ?";
        String[] selectionArgs = { String.valueOf(this.idNota) };

        int count = db.update(
                EverynoteContract.FeedEntry.TABLE_NAME,
                values,
                selection,
                selectionArgs);
    }

    public void delete(EverynoteHelper everynoteHelper){
        SQLiteDatabase db = everynoteHelper.getReadableDatabase();
        // Define 'where' part of query.
        String selection = EverynoteContract.FeedEntry._ID + " LIKE ?";
        // Specify arguments in placeholder order.
        String[] selectionArgs = { String.valueOf(this.idNota) };
        // Issue SQL statement.
        db.delete(EverynoteContract.FeedEntry.TABLE_NAME, selection, selectionArgs);

    }

    public void load(EverynoteHelper everynoteHelper){
        SQLiteDatabase db = everynoteHelper.getReadableDatabase();

        // Define a projection that specifies which columns from the database
        // you will actually use after this query.
        String[] projection = {
                EverynoteContract.FeedEntry._ID,
                EverynoteContract.FeedEntry.COLUMN_NAME_TITULO,
                EverynoteContract.FeedEntry.COLUMN_NAME_TEXTO,
                EverynoteContract.FeedEntry.COLUMN_NAME_DATA,
                EverynoteContract.FeedEntry.COLUMN_NAME_DISCIPLINA
        };

        // Filter results WHERE "title" = 'My Title'
        String selection = EverynoteContract.FeedEntry._ID + " = ?";
        String[] selectionArgs = { String.valueOf(this.idNota) };

        // How you want the results sorted in the resulting Cursor
        String sortOrder =
                EverynoteContract.FeedEntry.COLUMN_NAME_TITULO + " DESC";

        Cursor c = db.query(
                EverynoteContract.FeedEntry.TABLE_NAME,                     // The table to query
                projection,                               // The columns to return
                selection,                                // The columns for the WHERE clause
                selectionArgs,                            // The values for the WHERE clause
                null,                                     // don't group the rows
                null,                                     // don't filter by row groups
                sortOrder                                 // The sort order
        );

        c.moveToFirst();
        this.idNota = c.getInt(c.getColumnIndex(EverynoteContract.FeedEntry._ID));
        this.data = c.getString(c.getColumnIndex(EverynoteContract.FeedEntry.COLUMN_NAME_DATA));
        this.disciplina = c.getString(c.getColumnIndex(EverynoteContract.FeedEntry.COLUMN_NAME_DISCIPLINA));
        this.texto = c.getString(c.getColumnIndex(EverynoteContract.FeedEntry.COLUMN_NAME_TEXTO));

    }

    public static List getAll(EverynoteHelper everynoteHelper) {
        SQLiteDatabase db = everynoteHelper.getReadableDatabase();

        // Define a projection that specifies which columns from the database
        // you will actually use after this query.
        String[] projection = {
                EverynoteContract.FeedEntry._ID,
                EverynoteContract.FeedEntry.COLUMN_NAME_TITULO,
                EverynoteContract.FeedEntry.COLUMN_NAME_TEXTO,
                EverynoteContract.FeedEntry.COLUMN_NAME_DATA,
                EverynoteContract.FeedEntry.COLUMN_NAME_DISCIPLINA
        };

        String sortOrder =
                EverynoteContract.FeedEntry.COLUMN_NAME_TITULO + " DESC";

        Cursor c = db.query(
                EverynoteContract.FeedEntry.TABLE_NAME,   // The table to query
                projection,                               // The columns to return
                null,                                     // The columns for the WHERE clause
                null,                                     // The values for the WHERE clause
                null,                                     // don't group the rows
                null,                                     // don't filter by row groups
                sortOrder                                 // The sort order
        );
        c.moveToFirst();

        List<Note> list = new ArrayList<>();
        do {
            Note nt = new Note();
            nt.setIdNota(c.getInt(c.getColumnIndex(EverynoteContract.FeedEntry._ID)));
            nt.setData(c.getString(c.getColumnIndex(EverynoteContract.FeedEntry.COLUMN_NAME_DATA)));
            nt.setDisciplina(c.getString(c.getColumnIndex(EverynoteContract.FeedEntry.COLUMN_NAME_DISCIPLINA)));
            nt.setTexto(c.getString(c.getColumnIndex(EverynoteContract.FeedEntry.COLUMN_NAME_TEXTO)));
            nt.setTitulo(c.getString(c.getColumnIndex(EverynoteContract.FeedEntry.COLUMN_NAME_TITULO)));
            list.add(nt);
        }while(c.moveToNext());
        return list;
    }


}
