package com.myapplicationdev.android.p04_revisionnotes;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {

	//TODO Define the Database properties
	private static final String DATABASE_NAME = "MiniPS.db";
	private static final int DATABASE_VERSION = 1;

	private static final String TABLE_NOTE = "note";
	private static final String COLUMN_ID = "_id";
	private static final String COLUMN_NOTECONTENT = "noteContent";
	private static final String COLUMN_STARS = "stars";

	public DBHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		//TODO CREATE TABLE Note
		String createTableSql = "CREATE TABLE " + TABLE_NOTE +  "("
				+ COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
				+ COLUMN_NOTECONTENT + " TEXT,"
				+ COLUMN_STARS + " TEXT )";
		db.execSQL(createTableSql);
		Log.i("info" ,"created tables");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_NOTE);
		onCreate(db);
	}

	public void insertNote(String noteContent, int stars) {
		//TODO insert the data into the database

		// Get an instance of the database for writing
		SQLiteDatabase db = this.getWritableDatabase();
		// We use ContentValues object to store the values for
		//  the db operation
		ContentValues values = new ContentValues();
		// Store the column name as key and the description as value
		values.put(COLUMN_NOTECONTENT, noteContent);
		// Store the column name as key and the date as value
		values.put(COLUMN_STARS, stars);
		// Insert the row into the TABLE_TASK
		db.insert(TABLE_NOTE, null, values);
		// Close the database connection
		db.close();
	}

	public ArrayList<String> getEveryNotes() {
		//TODO return records in Java objects
		// Create an ArrayList that holds String objects
		ArrayList<String> tasks = new ArrayList<String>();
		// Select all the tasks' description
		String selectQuery = "SELECT " + COLUMN_NOTECONTENT
				+ " FROM " + TABLE_NOTE;

		// Get the instance of database to read
		SQLiteDatabase db = this.getReadableDatabase();
		// Run the SQL query and get back the Cursor object
		Cursor cursor = db.rawQuery(selectQuery, null);

		// moveToFirst() moves to first row, null if no records
		if (cursor.moveToFirst()) {
			// Loop while moveToNext() points to next row
			//  and returns true; moveToNext() returns false
			//  when no more next row to move to
			do {
				// Add the task content to the ArrayList object
				//  getString(0) retrieves first column data
				//  getString(1) return second column data
				//  getInt(0) if data is an integer value
				tasks.add(cursor.getString(0));
			} while (cursor.moveToNext());
	}
		// Close connection
		cursor.close();
		db.close();

		return tasks;
	}

    public ArrayList<Note> getAllNotes() {
        //TODO return records in Strings

		// Create an ArrayList that holds String objects
        ArrayList<Note> notes = new ArrayList<Note>();
        // Select all the notes' content
        String selectQuery = "SELECT "+COLUMN_ID+" , "
				+COLUMN_NOTECONTENT+" , "
				+COLUMN_STARS
				+" FROM "+TABLE_NOTE;

        // Get the instance of database to read
        SQLiteDatabase db = this.getReadableDatabase();
        // Run the SQL query and get back the Cursor object
        Cursor cursor = db.rawQuery(selectQuery, null);
        // moveToFirst() moves to first row
        if (cursor.moveToFirst()) {
            // Loop while moveToNext() points to next row and returns true;
            // moveToNext() returns false when no more next row to move to
            do {
				int id = cursor.getInt(0);
				String stars = cursor.getString(2);
				String noteContent = cursor.getString(1);
				Note obj = new Note(id,stars, noteContent );
				notes.add(obj);

            } while (cursor.moveToNext());
        }
        // Close connection
        cursor.close();
        db.close();

        return notes;
    }
}
