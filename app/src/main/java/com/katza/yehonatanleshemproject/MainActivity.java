
package com.katza.yehonatanleshemproject;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    int number;
    int SelectedNumber = 1;
    int attempts = 0;
    String history = "";

    TextView numberText;
    TextView resultText;
    TextView attemptsText;
    TextView historyText;
    Button plus;
    Button minus;
    Button check;
    Button restart;

    Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numberText = findViewById(R.id.numberText);
        resultText = findViewById(R.id.resultText);
        attemptsText = findViewById(R.id.attemptsText);
        historyText = findViewById(R.id.historyText);

        plus = findViewById(R.id.plusButton);
        minus = findViewById(R.id.minusButton);
        check = findViewById(R.id.checkButton);
        restart = findViewById(R.id.playAgainButton);

        startNewGame();

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (SelectedNumber < 100) {
                    SelectedNumber++;
                    updateNumber();
                }
            }
        });

        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (SelectedNumber > 1) {
                    SelectedNumber--;
                    updateNumber();
                }
            }
        });

        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkGuess();
            }
        });

        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startNewGame();
            }
        });
    }

    private void updateNumber() {
        numberText.setText(String.valueOf(SelectedNumber));
    }

    private void startNewGame() {

        number = random.nextInt(100) + 1;

        SelectedNumber = 1;
        attempts = 0;
        history = "";

        updateNumber();

        attemptsText.setText("0 ניסיונות");
        resultText.setText("זמן לנחש");
        historyText.setText("ניחושים קודמים");

    }

    private void checkGuess() {

        attempts++;

        attemptsText.setText("ניסיונות" + attempts);

        history = history + SelectedNumber + " ";
        historyText.setText("ניחושים קודמים" + history);

        if (SelectedNumber > number) {

            resultText.setText("גדול מדי");

        } else if (SelectedNumber < number) {

            resultText.setText("קטן מדי");

        } else {

            resultText.setText("מצאת את המספר בכמות ניסיונות" + attempts);

        }
    }
}
