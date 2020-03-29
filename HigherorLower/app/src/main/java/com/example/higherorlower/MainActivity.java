package com.example.higherorlower;

import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int randomNumber;

    public void generateRandomNumber() {
        Random rand = new Random();
        randomNumber = rand.nextInt(20)+1;
    }

    public void clickFunction(View view){
        Log.i("Info","Button Pressed");
        Log.i("Number",Integer.toString(randomNumber));
        EditText guess = (EditText) findViewById(R.id.editText);
        int guessval = Integer.parseInt(guess.getText().toString());
        String message;
        if(guessval>randomNumber){
            message = "Lower!!";
        }
        else if(guessval<randomNumber){
            message = "Higher!!";
        }
        else{
            message = "You got it!! Try Again.";
            generateRandomNumber();
        }
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        generateRandomNumber();

    }
}
