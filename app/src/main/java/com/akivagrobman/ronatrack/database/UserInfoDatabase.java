package com.akivagrobman.ronatrack.database;

import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.akivagrobman.ronatrack.repository.Repository;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {UserInfo.class}, version = 1)
public abstract class UserInfoDatabase extends RoomDatabase {

    public static final String TAG = UserInfoDatabase.class.getSimpleName();

    public abstract UserInfoDAO userInfoDAO();
    private static volatile UserInfoDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    public static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public static UserInfoDatabase getDatabase(final Context context) {
        if(INSTANCE == null) {
            synchronized (UserInfoDatabase.class) {
                if(INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            UserInfoDatabase.class,
                            "user_info_table")
                            .build();
                }
            }
        }
        return INSTANCE;
    }

}