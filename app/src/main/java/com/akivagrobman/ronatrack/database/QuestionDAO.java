package com.akivagrobman.ronatrack.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.akivagrobman.ronatrack.models.Question;

import java.util.List;

@Dao
public interface QuestionDAO {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Question question);

    @Query("SELECT * FROM questions_table WHERE id = :questionId")
    Question getQuestion(int questionId);

    @Query("DELETE FROM questions_table WHERE id = :questionId")
    void delete(int questionId);

    @Query("SELECT * FROM questions_table")
    List<Question> getAllQuestions();

    @Query("DELETE FROM questions_table")
    void deleteAllQuestions();

}
