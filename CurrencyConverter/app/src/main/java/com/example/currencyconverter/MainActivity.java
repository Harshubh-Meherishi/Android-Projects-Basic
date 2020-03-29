package com.example.currencyconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public void clickFunction(View view) {
        Log.i("Info","Button Pressed");
        EditText Currency = (EditText)findViewById(R.id.editText2);
        double Value = 74.88 * Integer.parseInt(Currency.getText().toString());
        String Val = String.format("%.2f",Value);

        Toast.makeText(this, Currency.getText().toString()+"$ is "+ Val + " ₹", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
