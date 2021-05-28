package com.example.flagquizgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ReportActivity extends AppCompatActivity {

    private TextView textViewTotalCorrect,textViewTotalWrong,textViewTotalEmpty,textViewTotalSuccess;
    private Button buttonAgain,buttonQuit;
    int correct, wrong,empty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);

        textViewTotalCorrect = findViewById(R.id.textViewTotalCorrect);
        textViewTotalWrong = findViewById(R.id.textViewTotalWrong);
        textViewTotalEmpty = findViewById(R.id.textViewTotalEmpty);
        textViewTotalSuccess = findViewById(R.id.textViewSuccess);

        buttonAgain = findViewById(R.id.buttonAgain);
        buttonQuit = findViewById(R.id.buttonQuit);


        correct = getIntent().getIntExtra("correct",0);
        wrong = getIntent().getIntExtra("wrong",0);
        empty = getIntent().getIntExtra("empty",0);

//
//        textViewTotalCorrect.setText(String.valueOf(correct));
          textViewTotalCorrect.setText("Total Correct Answer: "+correct);
          textViewTotalWrong.setText("Total Wrong Answer : "+ wrong);
          textViewTotalEmpty.setText("Total Empty Answer : "+ empty);
          textViewTotalSuccess.setText("Success Rate : "+ correct*10+"%");
//
        buttonAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(ReportActivity.this,MainActivity.class);
                startActivity(intent);
                finish();

            }
        });
//
        buttonQuit.setOnClickListener(new View.OnClickListener() {
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