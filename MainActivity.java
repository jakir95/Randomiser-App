package com.example.jakir.randomiser;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Create the buttons and variables
        Button rollButton = (Button) findViewById(R.id.rollButton);
        final TextView resultsTextView = (TextView) findViewById(R.id.resultsTextView);
        final SeekBar seekBar = (SeekBar) findViewById(R.id.seekBar);

        //create listener for button
        rollButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int rand = new Random().nextInt(seekBar.getProgress()) + 1;
                resultsTextView.setText(Integer.toString(rand));
            }
        });

        // Initialize the textview with '0'.
        resultsTextView.setText("Range: 0-" + seekBar.getProgress());

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progressValue = 0;

            // when it getting changed
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progressValue = progress;
                resultsTextView.setText("Range: 0-" + seekBar.getProgress());
                //Toast.makeText(MainActivity.this, "Changing max value!", Toast.LENGTH_SHORT).show();
            }

            //while its getting changed
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                resultsTextView.setText("Range: 0-" + seekBar.getProgress());
            }

            //after its changed
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                resultsTextView.setText("Range: 0-" + seekBar.getProgress());
                Toast.makeText(MainActivity.this, "Max value Changed", Toast.LENGTH_SHORT).show();
            }
        });


/*        //Create the button
        Button calcButton = (Button) findViewById(R.id.calcButton);
        //Create Listener for button
        calcButton.setOnClickListener(new View.OnClickListener() {
            @Override
            //Override what happens when the button is pressed
            public void onClick(View view) {
                //Get text from field then convert to string then parse it to a Float and save it as a float
                float percentage = Float.parseFloat(percentagefield.getText().toString());
                float decimal = percentage/100;
                float number = Float.parseFloat(numberField.getText().toString());
                float total = number * decimal;

                //Set the new answer in the answer text view
                answerTextView.setText(Float.toString(total));
            }
        });*/





    }
}
