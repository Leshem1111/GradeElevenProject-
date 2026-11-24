
package com.katza.yehonatanleshemproject;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SwitchCompat mySwitch = findViewById(R.id.mySwitch);

        Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);
        button1.setOnClickListener(v -> {
            Toast.makeText(this, "Button 1",
                    Toast.LENGTH_SHORT).show();
        });

        button2.setOnClickListener(v -> {
            Toast.makeText(this, "Button 2",
                    Toast.LENGTH_SHORT).show();
        });
        SeekBar seekBar = findViewById(R.id.seekBar);
        ImageView myImage = findViewById(R.id.myImage);
        button1.setVisibility(View.GONE);
        button2.setVisibility(View.GONE);

        myImage.setAlpha(0f);
        seekBar.setProgress(0);
        mySwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {

            if (isChecked) {
                button1.setVisibility(View.VISIBLE);
                button2.setVisibility(View.VISIBLE);
            } else {
                button1.setVisibility(View.GONE);
                button2.setVisibility(View.GONE);
            }

        });
        seekBar.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {

                    @Override
                    public void onProgressChanged(
                            SeekBar seekBar,
                            int progress,
                            boolean fromUser) {

                        float alpha = progress / 100f;
                        myImage.setAlpha(alpha);
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {
                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {
                    }
                }
        );
    }
}
