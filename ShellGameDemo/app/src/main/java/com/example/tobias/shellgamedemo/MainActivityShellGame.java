package com.example.tobias.shellgamedemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivityShellGame extends AppCompatActivity {
    int myInt;
    TextView counterView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState != null)
        {
            myInt = savedInstanceState.getInt("SOME_KEY", 0);
            displayInt(myInt);
        }

        setContentView(R.layout.activity_main_shell_game);

        counterView = (TextView) findViewById(R.id.counterView);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt("SOME_KEY", myInt);
        outState.putString("SOME_OTHER_KEY", counterView.getText().toString());
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        counterView.setText(savedInstanceState.getString("SOME_OTHER_KEY"));
        myInt = savedInstanceState.getInt("SOME_KEY");
    }

    public void increaseInt(View view)
    {
        myInt = myInt + 1;
        displayInt(myInt);
    }
    public void resetCounter(View view)
    {
        myInt = 0;
        displayInt(myInt);
    }

    private void displayInt(int number)
    {
        try{
            counterView = (TextView) findViewById(R.id.counterView);
            counterView.setText(Integer.toString(number));
        }
        catch (Exception e)
        {
            myInt = 0;
            //donger
        }

    }
}
