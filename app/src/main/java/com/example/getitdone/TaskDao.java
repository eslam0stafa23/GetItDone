package com.example.getitdone;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;


/*
This is the Data Access Object file of the entity Task which all define all the
database operations which we will preform the the Task entity, it contains three
operations Insert, Delete, and Update and two Queries one to delete all the tasks
and the other is to return all the tasks to show it in the recycler view
 */
public interface TaskDao {

    @Insert
    void insert(Task task);

    @Delete
    void delete(Task task);

    @Update
    void update(Task task);

    @Query("DELETE FROM task_table")
    void deleteAllTasks();

    @Query("SELECT * FROM task_table ORDER BY priority DESC")
    LiveData<List<Task>> getAllTasks();

}
