package ser210.quinnipiac.edu.triviaapinavdrawer;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import org.w3c.dom.Comment;

/**
 * Created by markrusso on 4/2/18.
 * Assignment 3 Part 2
 * SER210
 * this class is an SQLite data base
 */

public class SQLiteFavorites extends SQLiteOpenHelper {
    private static final String TAG = "DatabaseHelper";
    public static final String MY_TABLE = "peoplE_table";
    public static final String COL1 = "ID";
    private static final String COL2 = "name";
    private SQLiteDatabase database;


    //constructed *required
    public SQLiteFavorites(Context context) {
        super(context, MY_TABLE, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + MY_TABLE + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL2 +" TEXT)";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP IF TABLE EXISTS " + MY_TABLE);
        onCreate(db);
    }

    // adds data to the SQL data base. Called in Trivia activity
    public boolean addData(String item) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL2, item);

        Log.d(TAG, "addData: Adding " + item + " to " + MY_TABLE);
        long result = db.insert(MY_TABLE, null, contentValues);

        //if date as inserted incorrectly it will return -1
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * Returns all data from database
     */
    public Cursor getData(){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + MY_TABLE;
        Cursor data = db.rawQuery(query, null);
        return data;
    }

    /**
     * Returns only the ID that matches the name passed
     */
    public Cursor getItemID(String name){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT " + COL1 + " FROM " + MY_TABLE +
                " WHERE " + COL2 + " = '" + name + "'";
        Cursor data = db.rawQuery(query, null);
        return data;
    }

    /**
     * Updates the name field
     * not yet used or called
     */
    public void updateName(String newName, int id, String oldName){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "UPDATE " + MY_TABLE + " SET " + COL2 +
                " = '" + newName + "' WHERE " + COL1 + " = '" + id + "'" +
                " AND " + COL2 + " = '" + oldName + "'";
        Log.d(TAG, "updateName: query: " + query);
        Log.d(TAG, "updateName: Setting name to " + newName);
        db.execSQL(query);
    }

    /**
     * Delete from database
     * not yet called or used anywhere
     */
    public void deleteName(String item){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.remove(COL2);
        Log.d(TAG, "addData: Adding " + item + " to " + MY_TABLE);
        long result = db.insert(MY_TABLE, null, contentValues);

        String query = "DELETE FROM " + MY_TABLE + " WHERE "
                + COL1 + " = '" + "'" +
                " AND " + COL2 + " = '" + "'";
        Log.d(TAG, "deleteName: query: " + query);
        Log.d(TAG, "deleteName: Deleting " + " from database.");
        db.execSQL(query);
    }

    public void deleteEntry(String TABLE, int pos) {
        SQLiteDatabase database = this.getWritableDatabase();
        database.delete(TABLE, COL1 + "=?" , new String[] { String.valueOf(pos)});

        // also tryed this code
        database.delete(TABLE, COL1 + "= '" + pos +"'",null);
    }
}