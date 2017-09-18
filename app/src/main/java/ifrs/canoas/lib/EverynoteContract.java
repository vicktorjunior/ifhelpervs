package ifrs.canoas.lib;

import android.provider.BaseColumns;

/**
 * Created by developer on 18/09/17.
 */

/*      Dados DB
        Titulo da nota - Opcional
        Data da nota
        Texto da nota
        Disciplina relacionada.
*/


public class EverynoteContract {

    private static final String TEXT_TYPE = " TEXT";
    private static final String COMMA_SEP = ",";
    public static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + FeedEntry.TABLE_NAME + " (" +
                    FeedEntry._ID + " INTEGER PRIMARY KEY," +
                    FeedEntry.COLUMN_NAME_TEXTO + TEXT_TYPE + COMMA_SEP +
                    FeedEntry.COLUMN_NAME_DATA + TEXT_TYPE + COMMA_SEP +
                    FeedEntry.COLUMN_NAME_DISCIPLINA + TEXT_TYPE + COMMA_SEP +
                    FeedEntry.COLUMN_NAME_TITULO + TEXT_TYPE + COMMA_SEP +" )";

    public static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + FeedEntry.TABLE_NAME;

    // To prevent someone from accidentally instantiating the contract class,
    // make the constructor private.
    private EverynoteContract() {}

    /* Inner class that defines the table contents */
    public static class FeedEntry implements BaseColumns {
        public static final String TABLE_NAME = "evernote";
        public static final String COLUMN_NAME_TITULO= "titulo";
        public static final String COLUMN_NAME_DATA = "data";
        public static final String COLUMN_NAME_TEXTO = "texto";
        public static final String COLUMN_NAME_DISCIPLINA = "disciplina";
    }


}
