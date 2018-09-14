package com.example.tobias.multipleactivities;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Intent intent;
    TextView editableTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goToSeconcScreen(View view)
    {
        intent = new Intent(this, the2ndScreen.class);
        startActivityForResult(intent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        if (resultCode == RESULT_OK)
        {
            if (data != null)
            {
                String myData = data.getStringExtra("DataToParse");
                editableTextView = findViewById(R.id.editableTextView);
                editableTextView.setText(myData);
            }

        }
        else
        {

        }
    }
}
