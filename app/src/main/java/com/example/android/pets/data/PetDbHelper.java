package com.example.android.pets.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.android.pets.data.PetContract.PetEntry;

/**
 * Created by hjalmar
 * On 11/07/2018.
 */
public class PetDbHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "shelter.db";

    public PetDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL_CREATE_PETS_TABLE = buildSchema();
        db.execSQL(SQL_CREATE_PETS_TABLE);
    }

    /**
     * Create a String that contains the SQL statement to create the pets table
     */
    private String buildSchema() {
        StringBuilder sb = new StringBuilder();
        sb.append("CREATE TABLE ");
        sb.append(PetEntry.TABLE_NAME);
        sb.append(" (");
        sb.append(PetEntry._ID);
        sb.append(" INTEGER PRIMARY KEY AUTOINCREMENT,");
        sb.append(PetEntry.COLUMN_PET_NAME);
        sb.append(" TEXT NOT NULL,");
        sb.append(PetEntry.COLUMN_PET_BREED);
        sb.append(" TEXT,");
        sb.append(PetEntry.COLUMN_PET_GENDER);
        sb.append(" INTEGER NOT NULL,");
        sb.append(PetEntry.COLUMN_PET_WEIGHT);
        sb.append(" INTEGER NOT NULL DEFAULT 0);");
        return sb.toString();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Do nothing for now
    }

}
