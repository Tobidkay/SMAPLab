package com.example.tobias.appuistuff;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class EditActivity extends AppCompatActivity {

    EditText editTextName;
    EditText editTextEmail;
    EditText editTextPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        editTextName = findViewById(R.id.editTextName);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPhone = findViewById(R.id.editTextPhone);
    }


    public void sendEditText(View view){
        Intent data = new Intent();
        data.putExtra("NAME",editTextName.getText().toString());
        data.putExtra("EMAIL", editTextEmail.getText().toString());
        data.putExtra("PHONE", editTextPhone.getText().toString());
        setResult(RESULT_OK, data);
        finish();
    }

    public void goBackEdit(View view){
        setResult(RESULT_CANCELED);
        finish();
    }
}
