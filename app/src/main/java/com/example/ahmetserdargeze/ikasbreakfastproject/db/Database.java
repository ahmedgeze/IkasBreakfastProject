package com.example.ahmetserdargeze.ikasbreakfastproject.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ahmetserdargeze on 28.06.2018.
 */

public class Database {
    private static final String DATABASE_NAME="IkasBreakfast";
    private static final String DATABASE_TABLE="UserAuth";
    private static final int DATABASE_VERSİON=1;

    private final Context context;
    private DatabaseHelper dbHelper;
    private SQLiteDatabase database;

    public static final String KEY_ROW_ID = "_id";
    public static final String KEY_TOKEN= "auth_tokens";
    public static final String KEY_EMAIL= "auth_email";
    public static final String KEY_FIRSTNAME= "auth_name";
    public static final String KEY_LASTNAME= "auth_surname";




    public Database(Context c){this.context=c;}

    public Database openCon(){
        dbHelper=new DatabaseHelper(context);
        database=dbHelper.getWritableDatabase();
        return this;
    }

    public void closeCon(){
        dbHelper.close();
    }

    private static class DatabaseHelper extends SQLiteOpenHelper {
        public static final String createAddFavTable= "create table "+  DATABASE_TABLE+"("+KEY_ROW_ID+" INTEGER PRIMARY KEY AUTOINCREMENT ,"+
                KEY_TOKEN+" TEXT NOT NULL,"+KEY_EMAIL+" TEXT NOT NULL, "+KEY_FIRSTNAME+" TEXT NOT NULL, "+KEY_LASTNAME+ " TEXT NOT NULL );"
                ;

        public DatabaseHelper(Context contextim) {
            super(contextim, DATABASE_NAME, null, DATABASE_VERSİON);

        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(createAddFavTable);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE);
            onCreate(db);

        }

    }

    public long addToken(String tokens,String mail,String name,String surname){
        ContentValues cv=new ContentValues();
        cv.put(KEY_TOKEN,tokens);
        cv.put(KEY_EMAIL,mail);
        cv.put(KEY_FIRSTNAME,name);
        cv.put(KEY_LASTNAME,surname);
        return database.insert(DATABASE_TABLE,null,cv);

    }

    public List<Model_User> showTokens(){
        String[] column=new String[]{KEY_ROW_ID,KEY_TOKEN,KEY_EMAIL,KEY_FIRSTNAME,KEY_LASTNAME};
        Cursor cursor=database.query(DATABASE_TABLE,column,null,null,null,null,null);
        List<Model_User> tokens=new ArrayList<>();

        cursor.moveToFirst();
        for (int i=0;i<cursor.getCount();i++){
            Model_User object=new Model_User(Integer.parseInt(cursor.getString(0)),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getString(4));

            tokens.add(object);
            cursor.moveToNext();


        }

        for(int i=0;i<tokens.size();i++){
            System.out.println(i+"name:"+tokens.get(i).getName()+"surname:"+tokens.get(i).getSurname()+"email:"+tokens.get(i).getMail()+"tokens:"+tokens.get(i).getToken());
        }
        return tokens;



    }

    public List<Model_User> getLastToken(){
        String[] column=new String[]{KEY_ROW_ID,KEY_TOKEN,KEY_EMAIL,KEY_FIRSTNAME,KEY_LASTNAME};
        Cursor cursor=database.query(DATABASE_TABLE,column,null,null,null,null,null);
        List<Model_User> tokens=new ArrayList<>();

        cursor.moveToLast();
            Model_User object=new Model_User(Integer.parseInt(cursor.getString(0)),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getString(4));

            tokens.add(object);


        for(int i=0;i<tokens.size();i++){
            System.out.println(tokens.get(i).getId()+"name:"+tokens.get(i).getName()+"surname:"+tokens.get(i).getSurname()+"email:"+tokens.get(i).getMail()+"tokens:"+tokens.get(i).getToken());
        }
        return tokens;



    }



}
