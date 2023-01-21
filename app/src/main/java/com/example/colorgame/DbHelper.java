package com.example.colorgame;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DbHelper extends SQLiteOpenHelper {
    public DbHelper(@Nullable Context context) {
        super(context, "GameResule.db",null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String createTableSTatement1 = "CREATE TABLE Player (ID Integer PRIMARY KEY AUTOINCREMENT," +
                "NAME Text);";
        String createTableSTatement = "CREATE TABLE Result (ID Integer PRIMARY KEY AUTOINCREMENT," +
                "SelectedAns Text," +
                "CorrectAns Text," +
                 "Color Integer," +
                "userID Integer," +
                "FOREIGN KEY(userID) REFERENCES Player(ID));";
        sqLiteDatabase.execSQL(createTableSTatement);
        sqLiteDatabase.execSQL(createTableSTatement1);
    }
    public void AddPlayer(Player player)
    {
        SQLiteDatabase MyConn = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("NAME" , player.getName());
        MyConn.insert("Player",null,cv);
        MyConn.close();
//        SQLiteDatabase db = this.getWritableDatabase();
//        String insertStatement = "INSERT INTO Player NAME VALUES (player.getName());";
//        db.execSQL(insertStatement);
//        db.close();
    }
    public List<Player> GetAllPlayer()
    {
        SQLiteDatabase MyConn = this.getReadableDatabase();
        String sql = "SELECT * FROM Player;";
        Cursor cursor = MyConn.rawQuery(sql,null);
        ArrayList<Player> PlayerList = new ArrayList<>();
        do {
            int id = cursor.getInt(0);
            String name = cursor.getString(1);
            PlayerList.add(new Player(id,name));
        }
        while (cursor.moveToNext());
        cursor.close();
        MyConn.close();
        return PlayerList;
    }
    public Player GetPlayer(int id)
    {
        SQLiteDatabase MyConn = this.getReadableDatabase();
        String sql = "SELECT * FROM Player WHERE ID="+"id"+";";
        Cursor cursor = MyConn.rawQuery(sql,null);
        Player player = new Player();
        int d = cursor.getInt(0);
        String name = cursor.getString(1);
        player.setName(name);
        player.setID(d);
        cursor.close();
        MyConn.close();
        return player;
    }
    public Player GetPlayerId(String name)
    {
        SQLiteDatabase MyConn = this.getReadableDatabase();
        SQLiteDatabase MyConn1 = this.getWritableDatabase();
        MyConn.execSQL("DROP TABLE IF EXISTS Result");
        String createTableSTatement = "CREATE TABLE Result (ID Integer PRIMARY KEY AUTOINCREMENT," +
                "SelectedAns Text," +
                "CorrectAns Text," +
                "Color Integer," +
                "userID Integer," +
                "FOREIGN KEY(userID) REFERENCES Player(ID));";
        MyConn1.execSQL(createTableSTatement);
        String sql = "SELECT * FROM Player WHERE Name="+"name"+";";
        Cursor cursor = MyConn.rawQuery(sql,null);
        Player player = new Player();
        if(cursor.moveToFirst())
        {
            do {
                int d = cursor.getInt(0);
                String n = cursor.getString(1);
                player.setName(n);
                player.setID(d);
            } while (cursor.moveToNext());
        }
        cursor.close();
        MyConn.close();
        return player;
    }
    public void AddResult(Result rt) {
        SQLiteDatabase MyConn = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("userId" , rt.getUserId());
        cv.put("SelectedAns" , rt.SelectedAns);
        cv.put("CorrectAns" , rt.getCorrectAns());
        cv.put("Color" , rt.getColor());
        MyConn.insert("Result",null,cv);

        MyConn.close();
    }
    public ArrayList<Result> Getresult(int id)
    {

        String aad=Integer.toString(id);
        SQLiteDatabase MyConn = this.getReadableDatabase();
        String sql = "SELECT * FROM Result";
        Cursor cursor = MyConn.rawQuery(sql,null);
        ArrayList<Result> resultList = new ArrayList<>();
        if(cursor.moveToFirst()) {
            do {
                int color = cursor.getInt(3);
                int aid = cursor.getInt(0);
                int userid = cursor.getInt(4);
                String select = cursor.getString(1);
                String correct = cursor.getString(2);
                resultList.add(new Result(aid, userid, select, correct, color));
            } while (cursor.moveToNext());
        }
        cursor.close();
        MyConn.close();

        return resultList;
    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS Result");
        onCreate(sqLiteDatabase);
    }
}
