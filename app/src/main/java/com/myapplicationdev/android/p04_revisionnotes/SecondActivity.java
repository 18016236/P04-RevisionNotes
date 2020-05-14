package com.myapplicationdev.android.p04_revisionnotes;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {
	ListView lv;
	ArrayAdapter aa;
	ArrayList<Note> notesList;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
		//TODO implement the Custom ListView

		lv = findViewById(R.id.lv);

		notesList = new ArrayList<Note>();
		DBHelper db = new DBHelper(SecondActivity.this);
		notesList = db.getAllNotes();
		db.close();


		aa = new RevisionNotesArrayAdapter(this, R.layout.row, notesList);
		lv.setAdapter(aa);


	}
}
