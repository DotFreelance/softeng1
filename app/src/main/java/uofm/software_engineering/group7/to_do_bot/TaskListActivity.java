package uofm.software_engineering.group7.to_do_bot;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


public class TaskListActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_list);

        ComponentsCreator creator = new ComponentsCreator();
        creator.run();
    }

    //@Override
    public void onClick(View v) {
       /* if (v == add_butn){
            //add stuf
        }
        else if (v == delet_butn){
            //delet stuf
        }

        return;*/
    }
}
