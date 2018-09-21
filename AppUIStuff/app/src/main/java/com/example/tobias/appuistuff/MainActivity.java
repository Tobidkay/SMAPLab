package com.example.tobias.appuistuff;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Intent intent;

    public static final int REQUEST_CODE_PICKY_VIEW = 100;
    public static final int REQUEST_CODE_EDIT_VIEW = 101;
    public static final int REQUEST_CODE_RGB_VIEW = 102;

    TextView numberView;
    TextView nameView;
    TextView emailView;
    TextView phoneView;
    TextView rgbView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numberView = findViewById(R.id.numberText);
        nameView = findViewById(R.id.EnameText);
        emailView = findViewById(R.id.EemailText);
        phoneView = findViewById(R.id.EphoneText);
        rgbView = findViewById(R.id.rgbText);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent Data) {

        switch (requestCode) {
            case REQUEST_CODE_PICKY_VIEW:
                if(resultCode == RESULT_OK)
                {
                    numberView.setText(Data.getStringExtra("NUMBER"));
                }
                break;
            case REQUEST_CODE_EDIT_VIEW:
                if (resultCode == RESULT_OK)
                {
                    nameView.setText(Data.getStringExtra("NAME"));
                    emailView.setText(Data.getStringExtra("EMAIL"));
                    phoneView.setText(Data.getStringExtra("PHONE"));
                }
                break;
            case REQUEST_CODE_RGB_VIEW:
                if (resultCode == RESULT_OK)
                {
                    rgbView.setText(Data.getStringExtra("RGB"));
                }
                break;
        }
    }

    public void goToPicky(View view) {
        intent = new Intent(this, PickyActivity.class);
        startActivityForResult(intent, REQUEST_CODE_PICKY_VIEW);
    }

    public void goToEdit(View view) {
        intent = new Intent(this, EditActivity.class);
        startActivityForResult(intent, REQUEST_CODE_EDIT_VIEW);
    }

    public void goToRGB(View view) {
        intent = new Intent(this,rgbActivity.class);
        startActivityForResult(intent, REQUEST_CODE_RGB_VIEW);
    }
}
