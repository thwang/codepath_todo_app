package com.example.android.todoapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import static com.example.android.todoapp.R.id.etEditText;
import static com.example.android.todoapp.R.id.todoEditText;

public class ToDoDetailActivity extends AppCompatActivity {

    int position;
    EditText todoEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_do_detail);

        Intent i = getIntent();
        String currentString = i.getStringExtra("currentString");
        position = i.getIntExtra("position", 0);

        todoEditText = (EditText) findViewById(R.id.todoEditText);
        todoEditText.setText(currentString);
    }

    public void onButtonClick(View view) {
        String stringToPassBack = todoEditText.getText().toString();

        Intent intent = new Intent();
        intent.putExtra("editedString", stringToPassBack);
        intent.putExtra("pos", position);
        setResult(RESULT_OK, intent);
        finish();
    }
}
