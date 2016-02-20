package uofm.software_engineering.group7.to_do_bot.models;

import uofm.software_engineering.group7.to_do_bot.services.TaskListDBHelper;

/**
 * Created by Faye on 1/22/2016.
 *
 * This is what goes on in the list.
 */
public class TaskListItem implements ListItem {
    private TaskListDBHelper taskListDB;
    private String taskDescription;
    private boolean checked = false;
    private long id;

    public TaskListItem(TaskListDBHelper dbHelper, long itemID, String newTaskDescription) {
        id = itemID;
        taskListDB = dbHelper;
        taskDescription = newTaskDescription;
    }

    public void editTaskDescription(String newTaskDescription) {
        taskDescription = newTaskDescription;
        // TODO: DB Integration
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void clearTaskDescription() {
        taskDescription = "";
        // TODO: DB Integration
    }

    public void check() {
        checked = true;
        // TODO: DB Integration
    }

    public long getId() {
        return id;
    }
}
