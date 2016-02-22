package uofm.software_engineering.group7.to_do_bot.models;

import uofm.software_engineering.group7.to_do_bot.models.ListItem;

/**
 * Created by Faye on 1/22/2016.
 *
 * This is what goes on in the list.
 */
public class TaskListItem implements ListItem {
    private String value;
    private int id;
    private boolean checked;

    public TaskListItem(int newId, String newValue) {
        value = newValue;
        id = newId;
        checked = false;
    }

    public void editValue(String newValue) {
        value = newValue;
    }

    public String getValue() {
        return value;
    }

    public void clear() {
        value = "";
    }

    public void check() {
        checked = !checked;
    }

    public int getId(){
        return id;
    }
}
