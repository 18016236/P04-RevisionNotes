package com.myapplicationdev.android.p04_revisionnotes;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {
	ListView lv;
	ArrayAdapter aa;
	ArrayList<String> NotesList;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.row);
		//TODO implement the Custom ListView

		lv = findViewById(R.id.lv);

		NotesList = new ArrayList<String>();

		Intent i = getIntent();
		int number = i.getIntExtra("humanities", 0);

		ArrayAdapter<String> adapter = new ArrayAdapter<String>(SecondActivity.this,
				android.R.layout.simple_list_item_1, android.R.id.text1, NotesList);
		lv.setAdapter(adapter);
	}


}
