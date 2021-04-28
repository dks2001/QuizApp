package com.example.quizapp;

public class QuizModel {

    private int mQuestion;
    private boolean manswer;

    public QuizModel(int mQuestion, boolean manswer) {
        this.mQuestion = mQuestion;
        this.manswer = manswer;
    }

    public int getmQuestion() {
        return mQuestion;
    }

    public void setmQuestion(int mQuestion) {
        this.mQuestion = mQuestion;
    }

    public boolean isManswer() {
        return manswer;
    }

    public void setManswer(boolean manswer) {
        this.manswer = manswer;
    }
}
