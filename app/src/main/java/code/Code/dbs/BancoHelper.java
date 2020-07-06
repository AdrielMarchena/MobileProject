package code.Code.dbs;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 *
 * @author ProfAlexandre
 */
public class BancoHelper extends SQLiteOpenHelper{

    private static final String NOME_BANCO = "PROJETOMOBILE.db";
    public static final String TABELA_U = "USUARIOS";
    public static final String TABELA_P = "PESSOAS";
    public static final String TABELA_UP = "USU_PES";
    public static final String TABELA_IM = "IMOVEL";
    public static final String TABELA_IQ = "INQUILINO";
    public static final String TABELA_II = "IMO_INQ";

    private static final int VERSAO_SCHEMA = 1;
    private final String S_CREATE_U;
    private final String S_CREATE_P;
    private final String S_CREATE_UP;
    private final String S_CREATE_IM;
    private final String S_CREATE_IQ;
    private final String S_CREATE_II;

    // APLICAR CHAVE ESTRANGEIRA

    public BancoHelper(Context context) {
        super(context, NOME_BANCO, null, VERSAO_SCHEMA);
        this.S_CREATE_U = "CREATE TABLE USUARIOS (ID INTEGER PRIMARY KEY AUTOINCREMENT,LOGIN TEXT,SENHA TEXT,STATUS TEXT,TIPO TEXT);";
        this.S_CREATE_P = "CREATE TABLE PESSOAS (ID INTEGER PRIMARY KEY AUTOINCREMENT,NOME TEXT,CPF TEXT);";
        this.S_CREATE_UP = "CREATE TABLE USU_PES (ID INTEGER PRIMARY KEY AUTOINCREMENT,ID_U TEXT,ID_P TEXT, OBS TEXT );";
        this.S_CREATE_IM = "CREATE TABLE IMOVEL (ID INTEGER PRIMARY KEY AUTOINCREMENT, ENDERECO TEXT,PROPRIETARIO TEXT,VALOR_ALUGUEL REAL);";
        this.S_CREATE_IQ = "CREATE TABLE INQUILINO (ID INTEGER PRIMARY KEY AUTOINCREMENT, NOME TEXT);";
        this.S_CREATE_II = "CREATE TABLE IMO_INQ (ID INTEGER PRIMARY KEY AUTOINCREMENT, ID_IMOVEL TEXT,ID_INQUILINO TEXT,OBS TEXT , "
                + "FOREIGN KEY (ID_IMOVEL) REFERENCES IMOVEL(ID), FOREIGN KEY (ID_INQUILINO) REFERENCES INQUILINO(ID)";
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(S_CREATE_U);
        db.execSQL(S_CREATE_P);
        db.execSQL(S_CREATE_UP);
        db.execSQL(S_CREATE_IM);
        db.execSQL(S_CREATE_IQ);
        db.execSQL(S_CREATE_II);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABELA_U);
        db.execSQL("DROP TABLE IF EXISTS " + TABELA_P);
        db.execSQL("DROP TABLE IF EXISTS " + TABELA_UP);
        db.execSQL("DROP TABLE IF EXISTS " + TABELA_IM);
        db.execSQL("DROP TABLE IF EXISTS " + TABELA_IQ);
        db.execSQL("DROP TABLE IF EXISTS " + TABELA_II);

        onCreate(db);
    }

}
