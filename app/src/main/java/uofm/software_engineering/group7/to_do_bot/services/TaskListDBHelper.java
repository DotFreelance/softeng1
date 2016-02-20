package uofm.software_engineering.group7.to_do_bot.services;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;

/**
 * Created by Paul J on 2016-02-18.
 */
public class TaskListDBHelper extends SQLiteOpenHelper{
    private static final String DATABASE_NAME = "to-do-bot";
    private static final int DATABASE_VERSION = 3;

    private String tableName;
    private String tableCreateQuery;

    public TaskListDBHelper(Context context, String newTableName){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.tableName = newTableName;
        // The table name is dynamic, so we need to assign at run-time
        this.tableCreateQuery = "CREATE TABLE " + tableName + " (" +
            TaskListContract.TaskListItemSchema._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            TaskListContract.TaskListItemSchema.COL_NAME_CREATED + " DATETIME DEFAULT CURRENT_TIMESTAMP," +
            TaskListContract.TaskListItemSchema.COL_NAME_DESCRIPTION + " TEXT NOT NULL," +
            TaskListContract.TaskListItemSchema.COL_NAME_CHECKED + " BOOLEAN NOT NULL" +
            " CHECK (" + TaskListContract.TaskListItemSchema.COL_NAME_CHECKED + " IN (0,1))," +
            TaskListContract.TaskListItemSchema.COL_NAME_ALARM + " DATETIME DEFAULT NULL" +
        ");";
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL(tableCreateQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        // Required concrete method does not require implementation for Software Engineering 1
        // - Paul J
    }
}
