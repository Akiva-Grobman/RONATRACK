package com.akivagrobman.ronatrack.repository;

import android.app.Application;

import com.akivagrobman.ronatrack.database.QuestionDAO;
import com.akivagrobman.ronatrack.database.UserInfoDatabase;
import com.akivagrobman.ronatrack.models.Question;
import com.akivagrobman.ronatrack.models.UserInfo;
import com.akivagrobman.ronatrack.database.UserInfoDAO;

import java.util.List;

public class Repository {

    private final UserInfoDAO userInfoDAO;
    private final QuestionDAO questionDAO;

    public Repository(Application application) {
        UserInfoDatabase database = UserInfoDatabase.getDatabase(application);
        userInfoDAO = database.userInfoDAO();
        questionDAO = database.questionDAO();
    }

    public UserInfo getUserInfoById(int id) {
        return userInfoDAO.getUserInfo(id);
    }

    public void insertUser(UserInfo userInfo) {
        UserInfoDatabase.databaseWriteExecutor.execute(() -> userInfoDAO.insert(userInfo));
    }

    public void deleteUserInfo() {
        UserInfoDatabase.databaseWriteExecutor.execute(userInfoDAO::deleteUserInfo);
    }

    public void insertQuestion(Question question) {
        UserInfoDatabase.databaseWriteExecutor.execute(() -> questionDAO.insert(question));
    }

    public Question getQuestionById(int id) {
        return questionDAO.getQuestion(id);
    }

    public List<Question> getAllQuestions() {
        return questionDAO.getAllQuestions();
    }

    public void deleteQuestionById(int id) {
        UserInfoDatabase.databaseWriteExecutor.execute(() -> questionDAO.delete(id));
    }

    public void deleteAllQuestions() {
        UserInfoDatabase.databaseWriteExecutor.execute(questionDAO::deleteAllQuestions);
    }


}
