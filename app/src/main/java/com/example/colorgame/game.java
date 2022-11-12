package com.example.colorgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.jar.Attributes;

public class game extends AppCompatActivity implements View.OnClickListener{

    int[] colors = {Color.rgb(255,0,0), Color.rgb(0,242,0),Color.rgb(0,0,255)
            ,Color.rgb(255,255,0),Color.rgb(228, 51, 255),Color.rgb(143, 97, 37),
            Color.rgb(250, 163, 50), Color.rgb(0,0,0),Color.rgb(255, 105, 180),Color.rgb(128,0,0)};
    String [] colorName = {"Red","Green","Blue","Yellow","Purple","Brown","Orange","Black","Pink","Maroon"};
    Button btnA, btnB, btnC,btnD,prev,close; TextView Colors,ResultText,NameText;
    int selectedColor = 0, left=10,CorrectCount, WrongCount,tempAns;
    String answer = "",WrongAns= "";int rendomNo1 =0, rendomNo2 =0,rendomNo3 =0;
    int counter =0;String name;int ColorBox;String selectedValue="";String Status="";String Correct= "";
    ArrayList<String> SelectedOption = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        Colors=findViewById(R.id.ColorBox);
        btnA=findViewById(R.id.A);
        btnB=findViewById(R.id.B);
        btnC=findViewById(R.id.C);
        btnD=findViewById(R.id.D);
        prev=findViewById(R.id.buttonPrevious);
        close=findViewById(R.id.buttonClose);
        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inte=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(inte);
            }
        });
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                System.exit(0);
            }
        });
        NameText=findViewById(R.id.editTextTextEmailAddress);
        Intent intent = getIntent();
        name=intent.getStringExtra("Name");
        NameText.setText(name);
        ResultText=findViewById(R.id.textViewResult);
        btnA.setOnClickListener(this);
        btnB.setOnClickListener(this);
        btnC.setOnClickListener(this);
        btnD.setOnClickListener(this);
        GenerateColorOfRectangle();
        GetTextOnButton();

    }
    private List<String> ArrayWithoutAns()
    {
        List<String> values = new ArrayList<String>();
        for (int i=0;i<colorName.length;i++)
        {
            if(colorName[i]!=answer)
            {
               values.add(colorName[i]);
            }
         }
         return values;
    }
    private void GetThreeRandomNumbers()
    {
        Random rnd=new Random();
        do {
            rendomNo1=rnd.nextInt(9);
            rendomNo2=rnd.nextInt(9);
            rendomNo3=rnd.nextInt(9);
        }
        while((rendomNo1 == rendomNo2 || rendomNo1 == rendomNo3 || rendomNo2 == rendomNo3));
    }
    private void setStatusRightWrong()
    {
        if(answer==selectedValue)
        {
            Status="Right";
        }
        else
        {
            Status="Wrong";
        }
    }
    private void GetTextOnButton()
    {
        Random rnd = new Random();
        tempAns = rnd.nextInt(4);
        //Random Numbers should not be same
        GetThreeRandomNumbers();
        List<String> temp=ArrayWithoutAns();
        switch (tempAns)
        {
            case 0:
                btnA.setText(answer);
                btnB.setText(temp.get(rendomNo1));
                btnC.setText(temp.get(rendomNo2));
                btnD.setText(temp.get(rendomNo3));
                break;
            case 1:
                btnB.setText(answer);
                btnA.setText(temp.get(rendomNo1));
                btnC.setText(temp.get(rendomNo2));
                btnD.setText(temp.get(rendomNo3));
                break;
            case 2:
                btnC.setText(answer);
                btnA.setText(temp.get(rendomNo1));
                btnB.setText(temp.get(rendomNo2));
                btnD.setText(temp.get(rendomNo3));
                break;
            case 3:
                btnD.setText(answer);
                btnA.setText(temp.get(rendomNo1));
                btnB.setText(temp.get(rendomNo2));
                btnC.setText(temp.get(rendomNo3));
                break;
        }
    }
    private void GenerateColorOfRectangle() {
        Random rnd = new Random();
        selectedColor = rnd.nextInt(10);
        Colors.setBackgroundColor(colors[selectedColor]);
        ColorBox=colors[selectedColor];
        if (selectedColor ==0){
            answer=colorName[0];
        } else if (selectedColor ==1){
            answer=colorName[1];
        }else if (selectedColor ==2){
            answer=colorName[2];
        }
        else if (selectedColor ==3){
            answer=colorName[3];
        }
        else if (selectedColor ==4){
            answer=colorName[4];
        }
        else if (selectedColor ==5){
            answer=colorName[5];
        }
        else if (selectedColor ==6){
            answer=colorName[6];
        }
        else if (selectedColor ==7){
            answer=colorName[7];
        }
        else if (selectedColor ==8){
            answer=colorName[8];
        }
        else if (selectedColor ==9){
            answer=colorName[9];
        }
        counter++;
        Correct=answer;
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.A:
                if (answer == btnA.getText()) {
                    CorrectCount++;
                } else {
                    WrongAns=btnA.getText().toString();
                    WrongCount++;
                }
                selectedValue=btnA.getText().toString();
                left--;
                ResultText.setText("\nRight:" + CorrectCount + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tTotal: 10\nWrong: " + WrongCount + "\t\t\t\t\t\t\t\t\t\t\t\t\t\tLeft: " + left + "");
                break;
            case R.id.B:
                if (answer == btnB.getText()) {
                    CorrectCount++;
                } else {
                    WrongAns=btnB.getText().toString();
                    WrongCount++;
                }
                selectedValue=btnB.getText().toString();
                left--;
                ResultText.setText("\nRight:" + CorrectCount + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tTotal: 10\nWrong: " + WrongCount + "\t\t\t\t\t\t\t\t\t\t\t\t\t\tLeft: " + left + "");
                break;
            case R.id.C:
                if (answer == btnC.getText()) {
                    CorrectCount++;
                } else {
                    WrongAns=btnC.getText().toString();
                    WrongCount++;
                }
                selectedValue=btnC.getText().toString();
                left--;
                ResultText.setText("\nRight:" + CorrectCount + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tTotal: 10\nWrong: " + WrongCount + "\t\t\t\t\t\t\t\t\t\t\t\t\t\tLeft: " + left + "");
                break;
            case R.id.D:
                if (answer == btnD.getText()) {
                    CorrectCount++;
                } else {
                    WrongAns=btnD.getText().toString();
                    WrongCount++;
                }
                selectedValue=btnD.getText().toString();
                left--;
                ResultText.setText("\nRight:" + CorrectCount + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tTotal: 10\nWrong: " + WrongCount + "\t\t\t\t\t\t\t\t\t\t\t\t\t\tLeft: " + left + "");
                break;
        }
        setStatusRightWrong();
        if (left == 0) {
            String temp=String.valueOf(ColorBox);
            SelectedOption.add((temp+","+selectedValue+","+Correct+","+Status));
            Intent intents2=new Intent(getApplicationContext(),showresult.class);
            intents2.putStringArrayListExtra("Selected Ans", SelectedOption);
            startActivity(intents2);
        }
        else {
            String temp=String.valueOf(ColorBox);
            SelectedOption.add((temp+","+selectedValue+","+Correct+","+Status));
            GenerateColorOfRectangle();
            GetTextOnButton();
        }
    }
}