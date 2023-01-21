package com.example.colorgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class showresult extends AppCompatActivity {

    TableRow tableRow1;
    TextView textView,testing;TableLayout tableLayout;
    int RightCount=0,WrongCount=0;
    DbHelper dbHelper=new DbHelper(showresult.this);
    Button btn,whatsappbutton;
    String list="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showresult);
        tableLayout=findViewById(R.id.tableLayout2);
        testing=findViewById(R.id.WrongAndRight);
        int idplayer=getIntent().getIntExtra("IDPLAYER",-1);
        btn=findViewById(R.id.commit);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri webpage=Uri.parse("https://github.com/Bushra-Butt/ColorGameMCQ.git");
                Intent intent=new Intent(Intent.ACTION_VIEW,webpage);
                startActivity(intent);
            }
        });
        ArrayList<Result> arrayList=dbHelper.Getresult(idplayer);
        whatsappbutton=findViewById(R.id.Whatsappbutton);
        Intent whatsappIntent = new Intent(Intent.ACTION_SEND);
        whatsappbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                whatsappIntent.setType("text/plain");
                whatsappIntent.setPackage("com.whatsapp");
                whatsappIntent.putExtra(Intent.EXTRA_TEXT, list);
                try {
                    startActivity(whatsappIntent);
                } catch (android.content.ActivityNotFoundException ex) {
//                    ToastHelper.MakeShortText("Whatsapp have not been installed.");
                }
            }
        });
//        ArrayList<String> SelectedRes = getIntent().getStringArrayListExtra("Selected Ans");
//        for(int i=0;i<10;i++)
//        {
//            String[] tempDta= SelectedRes.get(i).split(",");
//            tableRow1 = new TableRow(getApplicationContext());
//            for(int j=0;j<4;j++)
//            {
//                textView=new TextView(getApplicationContext());
//                textView.setId(i+j);
//                textView.setPadding(20,20,20,20);
//                textView.setGravity(Gravity.CENTER);
//                    if (j == 0)
//                        textView.setBackgroundColor(Integer.parseInt(tempDta[0]));
//                    else if (j == 1)
//                        textView.setText(tempDta[1].toString());
//                    else if (j == 2)
//                        textView.setText(tempDta[2].toString());
//                    else if (j == 3)
//                        textView.setText(tempDta[3].toString());
//                textView.setTextColor( Color.rgb(0,0,0));
//                tableRow1.addView(textView);
//
//            }
//            CountWrongAndRight(tempDta);
//            tableLayout.addView(tableRow1);
//        }
        for(int i=0;i<10;i++)
        {
//            String[] tempDta= SelectedRes.get(i).split(",");
            tableRow1 = new TableRow(getApplicationContext());
            for(int j=0;j<4;j++)
            {
                textView=new TextView(getApplicationContext());
                textView.setId(i+j);
                textView.setPadding(20,20,20,20);
                textView.setGravity(Gravity.CENTER);
                if (j == 0) {
                    textView.setBackgroundColor(arrayList.get(i).getColor());
//                    list+="Coolor"+arrayList.get(i).getColor();
                }else if (j == 1) {
                    textView.setText(arrayList.get(i).getSelectedAns().toString());
                    list+="Selected: "+arrayList.get(i).getSelectedAns().toString()+"\n";
                }else if (j == 2) {
                    textView.setText(arrayList.get(i).getCorrectAns().toString());
                    list+="Correct: "+arrayList.get(i).getCorrectAns().toString()+"\n";
                }
                    else if (j == 3)
                    if(arrayList.get(i).getCorrectAns().toString().equals(arrayList.get(i).getSelectedAns().toString()))
                    {
                        textView.setText("Right");
                        RightCount++;
                        list+="Status: Right \n -----------------------\n";
                    }
                    else {
                        textView.setText("Wrong");
                        WrongCount++;
                        list+="Status: Wrong \n -----------------------\n";
                    }

                    textView.setTextColor( Color.rgb(0,0,0));
                tableRow1.addView(textView);
            }
//            CountWrongAndRight(tempDta);
            tableLayout.addView(tableRow1);
        }
        testing.setText("Wrong:" + WrongCount + "\nRight: " + RightCount);
    }
//    private void CountWrongAndRight(String[] Res)
//    {
//        for(int j=0;j<4;j++)
//        {
//            if(j==3) {
//                if (Res[3].toString().equals("Right"))
//                {
//                    RightCount++;
//                }
//                else
//                {
//                    WrongCount++;
//                }
//            }
//        }
//    }
}