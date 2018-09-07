package com.example.tobias.welcometohollywoodtobi;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView lftImg;
    ImageView rgtImg;
    boolean isDongerRight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState != null)
        {
            isDongerRight = savedInstanceState.getBoolean("SOME_KEY", false);

        }

        setContentView(R.layout.activity_main);

        lftImg = findViewById(R.id.DongerImg);
        rgtImg = findViewById(R.id.OdderImg);
        if (isDongerRight)
        {
            rgtImg.setImageResource(R.drawable.ddonger);
            lftImg.setImageResource(R.drawable.oodder);
            isDongerRight = false;
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putBoolean("SOME_KEY", isDongerRight);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        isDongerRight  = savedInstanceState.getBoolean("SOME_KEY");
    }

    public void swapImage(View view)
    {
        swapIt();
    }

    private void swapIt()
    {
        if (isDongerRight)
        {
            lftImg.setImageResource(R.drawable.ddonger);
            rgtImg.setImageResource(R.drawable.oodder);
            isDongerRight = false;
        }
        else
        {
            lftImg.setImageResource(R.drawable.oodder);
            rgtImg.setImageResource(R.drawable.ddonger);
            isDongerRight = true;
        }
    }
}
