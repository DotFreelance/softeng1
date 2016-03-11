package uofm.software_engineering.group7.to_do_bot.models;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import uofm.software_engineering.group7.to_do_bot.services.TaskListContract;
import uofm.software_engineering.group7.to_do_bot.services.TaskListDBHelper;

/**
 * Created by Faye on 1/22/2016.
 *
 * This is what goes on in the list.
 */
public class TaskListItem implements ListItem {
    // References to containing objects required for category and DB integration
    private TaskListDBHelper taskListDB;

    // User values for this TaskListItem
    private long id;
    private String dateCreated;
    private String taskDescription;
    private boolean checked = false;
    private String alarmTime = null;

    public TaskListItem(TaskListManager listManager, TaskListDBHelper dbHelper,
                        long itemID,
                        String dateCreated,
                        String newTaskDescription,
                        boolean isChecked,
                        String alarmTime) {
        // Set the reference values
        taskListDB = dbHelper;
        // Set the user values
        this.id = itemID;
        this.dateCreated = dateCreated;
        this.taskDescription = newTaskDescription;
        this.checked = isChecked;
        this.alarmTime = alarmTime;
    }

    // Getters
    public long getId() {
        return id;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public boolean getChecked(){
        return checked;
    }

    // Setters
    public void setTaskDescription(String newTaskDescription) {
        taskDescription = newTaskDescription;

        // Apply the changes to the database
        SQLiteDatabase db = taskListDB.getWritableDatabase();

        ContentValues dbValues = new ContentValues();
        dbValues.put(TaskListContract.TaskListItemSchema.COL_NAME_DESCRIPTION, newTaskDescription);

        db.update(TaskListContract.TABLE_NAME, dbValues, TaskListContract.TaskListItemSchema._ID + "=?", new String[]{ Long.toString(this.getId()) });

        taskListDB.close();
    }

    // Utility methods
    public void clearTaskDescription() {
        taskDescription = "";
        // TODO: DB Integration
    }

    public void check(boolean checked) {
        this.checked = checked;
        SQLiteDatabase db = taskListDB.getWritableDatabase();
        ContentValues dbValues = new ContentValues();
        // Set the checked value
        if(checked) {
            dbValues.put(TaskListContract.TaskListItemSchema.COL_NAME_CHECKED, TaskListContract.TaskListItemSchema.CHECKED_TRUE);
        } else {
            dbValues.put(TaskListContract.TaskListItemSchema.COL_NAME_CHECKED, TaskListContract.TaskListItemSchema.CHECKED_FALSE);
        }
        // Perform the database insert
        db.update(TaskListContract.TABLE_NAME, dbValues, TaskListContract.TaskListItemSchema._ID + "=?", new String[]{ Long.toString(this.getId()) });
        // Update the adapter
        this.taskListManager.getAdapter().notifyDataSetChanged();

        db.close();
    }


}
