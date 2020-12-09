package com.akivagrobman.ronatrack.models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "questions_table")
public class Question {

    @PrimaryKey
    @ColumnInfo(name = "id")
    private final int questionId;

    @ColumnInfo(name = "answer")
    private final int answer;

    public Question(int questionId, int answer) {
        this.questionId = questionId;
        this.answer = answer;
    }

    public int getQuestionId() {
        return questionId;
    }

    public int getAnswer() {
        return answer;
    }
}
