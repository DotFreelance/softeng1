package uofm.software_engineering.group7.to_do_bot.models;


/*
 * Created by Faye on 1/22/2016.
 */

public class TaskListManager {
    private String category;
    private TaskList list;
    private int counter; //TODO: keep or not? for ID

    public TaskListManager(String newName) {
        category = newName;
        counter = 0;
        list = new TaskList();
    }

    public void editCategoryName(String newName) {
        category = newName;
    }

    public void addTask(String value) {
        counter ++;

        ListItem item = new TaskListItem(counter, value);
        list.add(counter, item);
    }

    public void removeTask(String id) {
        list.remove(id);
    }

    public void checkTask(String id) {
        int currId = Integer.parseInt(id);
        TaskListItem temp = (TaskListItem) list.get(currId);
        temp.check();
    }
}
