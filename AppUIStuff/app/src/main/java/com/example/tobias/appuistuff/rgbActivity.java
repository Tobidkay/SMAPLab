package com.example.tobias.appuistuff;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

public class rgbActivity extends AppCompatActivity {

    SeekBar seekBarRed;
    SeekBar seekBarGreen;
    SeekBar seekBarBlue;
    View activeView;
    TextView textViewRGB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rgb);

        activeView = this.getWindow().getDecorView();

        seekBarRed = findViewById(R.id.seekBarRed);
        seekBarGreen = findViewById(R.id.seekBarGreen);
        seekBarBlue = findViewById(R.id.seekBarBlue);

        seekBarRed.setOnSeekBarChangeListener(onSeekBarChangeListener);
        seekBarGreen.setOnSeekBarChangeListener(onSeekBarChangeListener);
        seekBarBlue.setOnSeekBarChangeListener(onSeekBarChangeListener);

        textViewRGB = findViewById(R.id.textViewRGB);
    }

    SeekBar.OnSeekBarChangeListener onSeekBarChangeListener = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            activeView.setBackgroundColor(Color.rgb(seekBarRed.getProgress(), seekBarGreen.getProgress(), seekBarBlue.getProgress()));
            String rgbValue = "Red: " + Integer.toString(seekBarRed.getProgress()) + " Green: " + Integer.toString(seekBarGreen.getProgress()) + " Blue: " + Integer.toString(seekBarBlue.getProgress());
            textViewRGB.setText(rgbValue);
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    };

    public void goBackrgb(View view)
    {
        setResult(RESULT_CANCELED);
        finish();
    }

    public void sendRgbValueBack(View view)
    {
        String returnValue = textViewRGB.getText().toString();
        Intent data = new Intent();
        data.putExtra("RGB", returnValue);
        setResult(RESULT_OK, data);
        finish();
    }
}
