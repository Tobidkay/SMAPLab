package com.example.tobias.appuistuff;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.NumberPicker;
import android.widget.TextView;

public class PickyActivity extends AppCompatActivity {

    Intent intent;
    NumberPicker numberPicker1;
    NumberPicker numberPicker2;
    NumberPicker numberPicker3;
    TextView numberView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picky);

        numberPicker1 = findViewById(R.id.numberPicker1);
        numberPicker2 = findViewById(R.id.numberPicker2);
        numberPicker3 = findViewById(R.id.numberPicker3);

        numberPicker1.setMinValue(0);
        numberPicker1.setMaxValue(9);
        numberPicker1.setValue(0);
        numberPicker1.setOnValueChangedListener(onValueChangeListener);
        numberPicker2.setMinValue(0);
        numberPicker2.setMaxValue(9);
        numberPicker2.setValue(0);
        numberPicker2.setOnValueChangedListener(onValueChangeListener);
        numberPicker3.setMinValue(0);
        numberPicker3.setMaxValue(9);
        numberPicker3.setValue(0);
        numberPicker3.setOnValueChangedListener(onValueChangeListener);

        numberView = findViewById(R.id.numberValue);
        String update = Integer.toString(numberPicker1.getValue()) + Integer.toString(numberPicker2.getValue()) + Integer.toString(numberPicker3.getValue());
        numberView.setText(update);



    }

    NumberPicker.OnValueChangeListener onValueChangeListener = new NumberPicker.OnValueChangeListener() {
        @Override
        public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
            String stringToUpdate;
            stringToUpdate = Integer.toString(numberPicker1.getValue()) + Integer.toString(numberPicker2.getValue()) + Integer.toString(numberPicker3.getValue());
            numberView = findViewById(R.id.numberValue);
            numberView.setText(stringToUpdate);
        }
    };

    public void goBack(View view)
    {
        setResult(RESULT_CANCELED);
        finish();
    }

    public void sendNumberBack(View view)
    {
        String returnValue = numberView.getText().toString();
        Intent data = new Intent();
        data.putExtra("NUMBER", returnValue);
        setResult(RESULT_OK, data);
        finish();
    }
}
