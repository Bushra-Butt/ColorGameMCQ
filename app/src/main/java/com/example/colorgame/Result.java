package com.example.colorgame;

public class Result {
    int ID;
    int userId;
    String SelectedAns;
    String CorrectAns;
    int color;

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public Result(int ID, int userId, String selectedAns, String correctAns, int color) {
        this.ID = ID;
        this.userId = userId;
        SelectedAns = selectedAns;
        CorrectAns = correctAns;
        this.color = color;
    }

    public Result() {
    }

    public int getID() {
        return ID;
    }
    public void setID(int ID) {
        this.ID = ID;
    }

    public String getSelectedAns() {
        return SelectedAns;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getUserId() {
        return userId;
    }

    public void setSelectedAns(String selectedAns) {
        SelectedAns = selectedAns;
    }
    public String getCorrectAns() {
        return CorrectAns;
    }
    public void setCorrectAns(String correctAns) {
        CorrectAns = correctAns;
    }
}
