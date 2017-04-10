package com.example.android.oceanquiznew;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText name = (EditText) findViewById(R.id.name);
    }
// Opens quiz activity once the player inputs name
    public void toQuiz(View view) {
        EditText name = (EditText) findViewById(R.id.name);
        String playerName = name.getText().toString();
        if (playerName.isEmpty()) {
            Toast.makeText(this, getString(R.string.name_prompt), Toast.LENGTH_SHORT).show();
        } else {
            Intent intent = new Intent(this, Quiz.class);
            startActivity(intent);
        }

    }
}
