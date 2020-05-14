package com.myapplicationdev.android.p04_revisionnotes;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button btnInsertNote,btnShowList;
    TextView tvNote,tv2;
    EditText etNote;
    RadioGroup rgStars;
    RadioButton rb1,rb2,rb3,rb4,rb5;
    ListView lv;
    ArrayAdapter aa;
    ArrayList<Note> notes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnInsertNote = findViewById(R.id.buttonInsertNote);
        btnShowList = findViewById(R.id.buttonShowList);
        tvNote = findViewById(R.id.textViewNote);
        etNote = findViewById(R.id.editTextNote);
        tv2 = findViewById(R.id.textView2);
        rgStars = findViewById(R.id.radioGroupStars);
        rb1 = findViewById(R.id.radio1);
        rb2 = findViewById(R.id.radio2);
        rb3 = findViewById(R.id.radio3);
        rb4 = findViewById(R.id.radio5);
        rb5 = findViewById(R.id.radio5);

        DBHelper db = new DBHelper(MainActivity.this);
        notes = db.getAllNotes();
        db.close();

        aa = new RevisionNotesArrayAdapter(this, R.layout.row, notes);
        lv.setAdapter(aa);

        btnInsertNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create the DBHelper object, passing in the
                // activity's Context
                DBHelper db = new DBHelper(MainActivity.this);

                // Insert a task
                db.insertNote("#Revision notes 1", 3);
                db.insertNote("#Revision notes 2", 4);
                db.insertNote("#Revision notes 3", 5);

                Toast.makeText(MainActivity.this, "Inserted", Toast.LENGTH_SHORT).show();

                db.close();
            }
        });

        btnShowList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create the DBHelper object, passing in the
                // activity's Context
                Intent i = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(i);


            }
        });
    }}

