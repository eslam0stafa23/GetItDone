package com.example.getitdone;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import butterknife.BindView;


public class MainActivity extends AppCompatActivity {
    @BindView(R.id.rv_taskslist)
    RecyclerView tasksList;
    private TaskViewModel taskViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tasksList.setLayoutManager(new LinearLayoutManager(this));
        tasksList.setHasFixedSize(true);

        final TaskAdapter adapter = new TaskAdapter();
        tasksList.setAdapter(adapter);

        taskViewModel = ViewModelProviders.of(this).get(TaskViewModel.class);
        taskViewModel.getAllTasks().observe(this, new Observer<List<Task>>() {
            @Override
            public void onChanged(@Nullable List<Task> tasks) {

                adapter.setTasks(tasks);
            }
        });
    }
}
