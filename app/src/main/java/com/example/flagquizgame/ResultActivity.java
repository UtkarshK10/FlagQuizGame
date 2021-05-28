package com.example.flagquizgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    private TextView textViewTotalCorrect,textViewTotalWrong,textViewTotalEmpty,textViewTotalSuccess;
    private Button buttonAgain,buttonStart;
    int correct, wrong,empty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        textViewTotalCorrect = findViewById(R.id.textViewCorrect);
        textViewTotalWrong = findViewById(R.id.textViewTotalWrong);
        textViewTotalEmpty = findViewById(R.id.textViewTotalEmpty);
        textViewTotalSuccess = findViewById(R.id.textViewSuccess);

        buttonAgain = findViewById(R.id.buttonAgain);
        buttonStart = findViewById(R.id.buttonStart);

        correct = getIntent().getIntExtra("correct",0);
        wrong = getIntent().getIntExtra("wrong",0);
        empty = getIntent().getIntExtra("empty",0);

        textViewTotalCorrect.setText("Total Correct Answer: "+correct);
        textViewTotalCorrect.setText("Total Wrong Answer : "+wrong);
        textViewTotalCorrect.setText("Total Empty Answer : "+empty);
        textViewTotalCorrect.setText("Total Success Answer : "+correct*10 +"%");

        buttonAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ResultActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newIntent = new Intent(Intent.ACTION_MAIN);
                newIntent.addCategory(Intent.CATEGORY_HOME);
                newIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(newIntent);
                finish();
            }
        });

    }
}