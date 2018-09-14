package com.example.tobias.multipleactivities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class the2ndScreen extends AppCompatActivity {

    EditText editTextBow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_the2nd_screen);
    }

    public void editText(View view)
    {
        editTextBow = findViewById(R.id.editText);
        String textToReturn = editTextBow.getText().toString();
        Intent data = new Intent();
        data.putExtra("DataToParse", textToReturn);
        setResult(RESULT_OK, data);
        finish();
    }

    public void goBack(View view)
    {
        setResult(RESULT_CANCELED);
        finish();
    }
}
