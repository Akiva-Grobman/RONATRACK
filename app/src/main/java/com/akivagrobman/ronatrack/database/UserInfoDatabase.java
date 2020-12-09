package com.akivagrobman.ronatrack.database;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.akivagrobman.ronatrack.repository.Repository;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {UserInfo.class}, version = 1, exportSchema = false)
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
                            .addCallback(databaseCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    private static final RoomDatabase.Callback databaseCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase database) {
            super.onCreate(database);
            databaseWriteExecutor.execute(() -> {
                UserInfoDAO dao = INSTANCE.userInfoDAO();
                UserInfo userInfo = new UserInfo(132113, 39, 392, 23, "Male");
                dao.insert(userInfo);
                userInfo = new UserInfo(Repository.ID, 39, 238, 23, "Female");
                dao.insert(userInfo);
                Log.e(TAG, "Added Values to DB");
            });
        }
    };

}
