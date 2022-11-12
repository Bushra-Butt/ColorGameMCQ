package com.example.colorgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    EditText nameField; Button cancelbutton; Button PlayButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nameField=findViewById(R.id.editTextTextName);
        cancelbutton=findViewById(R.id.Cancel);
        PlayButton=findViewById(R.id.Play);
        cancelbutton.setOnClickListener(this);
        PlayButton.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        Intent intents=new Intent(getApplicationContext(),game.class);
        switch (view.getId())
        {
            case R.id.Cancel:
                nameField.setHint("Enter your Name");
                nameField.setHintTextColor(getResources().getColor(R.color.black));
                nameField.setText("");
                break;
            case R.id.Play:
                if(nameField.getText().length()!=0) {
                    intents.putExtra("Name", nameField.getText().toString());
                    startActivity(intents);
                }
                else
                    nameField.setHintTextColor(getResources().getColor(R.color.Cgreen));
                break;
            default:
                break;
        }
    }
}