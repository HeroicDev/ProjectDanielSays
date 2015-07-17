package com.comp380.group3.forthequeen;

import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {


    private Button [] buttons = new Button[6];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //makes the buttons
        castButtons();
    }

    private void castButtons() {

        buttons[0] = (Button) findViewById(R.id.first_button);
        buttons[1] = (Button) findViewById(R.id.second_button);
        buttons[2] = (Button) findViewById(R.id.third_button);
        buttons[3] = (Button) findViewById(R.id.fourth_button);
        buttons[4] = (Button) findViewById(R.id.fifth_button);
        buttons[5] = (Button) findViewById(R.id.sixth_button);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    //should do the generation of buttons to press
    private void patterns() {
        //TO-DO
        //we should have a way to store the random values we generate

        Handler handler = new Handler();
        final int ranArray [] = new int[3];

        //executes first button animation
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                final int ranVal = (int) (Math.random() * 6);
                ranArray[0] = ranVal;
                buttons[ranVal].setBackgroundColor(Color.RED);
            }
        }, 2000);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                cleanUp(buttons[ranArray[0]]); //resets back to default
            }
        }, 3000);

        //second button animation
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                final int ranVal = (int) (Math.random() * 6);
                ranArray[1] = ranVal;
                buttons[ranVal].setBackgroundColor(Color.RED);
            }
        }, 4500);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                cleanUp(buttons[ranArray[1]]);
            }
        }, 5500);

        //third button animation
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                final int ranVal = (int) (Math.random() * 6);
                ranArray[2] = ranVal;
                buttons[ranVal].setBackgroundColor(Color.RED);
            }
        }, 6500);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                cleanUp(buttons[ranArray[2]]);
            }
        }, 7500);

    }

    //returns everything back to the default state
    private void cleanUp(Button buttonToBeCleared) {

        buttonToBeCleared.setBackgroundColor(Color.BLUE);
        //Toast.makeText(getApplicationContext(), "It works? ", Toast.LENGTH_SHORT).show();

    }

    //activated when the fist button is pressed
    public void button1Clicked(View view) {
       // button1.setBackgroundColor(Color.RED);
        Toast.makeText(getApplicationContext(), "Stop pressing me man", Toast.LENGTH_LONG);
    }

    //starts the game. it is only there for debugging purposes
    public void playGame(View view) {
        patterns();
    }
}
