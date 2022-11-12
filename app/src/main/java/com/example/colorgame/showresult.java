package com.example.colorgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class showresult extends AppCompatActivity {

    TableRow tableRow1;
    TextView textView,testing;TableLayout tableLayout;
    int RightCount=0,WrongCount=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showresult);
        tableLayout=findViewById(R.id.tableLayout2);
        testing=findViewById(R.id.WrongAndRight);
        ArrayList<String> SelectedRes = getIntent().getStringArrayListExtra("Selected Ans");
        for(int i=0;i<10;i++)
        {
            String[] tempDta= SelectedRes.get(i).split(",");
            tableRow1 = new TableRow(getApplicationContext());
            for(int j=0;j<4;j++)
            {
                textView=new TextView(getApplicationContext());
                textView.setId(i+j);
                textView.setPadding(20,20,20,20);
                textView.setGravity(Gravity.CENTER);
                    if (j == 0)
                        textView.setBackgroundColor(Integer.parseInt(tempDta[0]));
                    else if (j == 1)
                        textView.setText(tempDta[1].toString());
                    else if (j == 2)
                        textView.setText(tempDta[2].toString());
                    else if (j == 3)
                        textView.setText(tempDta[3].toString());
                textView.setTextColor( Color.rgb(0,0,0));
                tableRow1.addView(textView);

            }
            CountWrongAndRight(tempDta);
            tableLayout.addView(tableRow1);
        }
        testing.setText("Wrong:" + WrongCount + "\nRight: " + RightCount);
    }
    private void CountWrongAndRight(String[] Res)
    {
        for(int j=0;j<4;j++)
        {
            if(j==3) {
                if (Res[3].toString().equals("Right"))
                {
                    RightCount++;
                }
                else
                {
                    WrongCount++;
                }
            }
        }
    }
}