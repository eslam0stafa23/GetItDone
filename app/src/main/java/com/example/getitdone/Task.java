package com.example.getitdone;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/*
This file is the entity file which contains the Entity (Table) name and its elements (Columns)
it also contains the getter method and the constructor and a setter method for the id (Primary Key) element
 */

@Entity(tableName = "task_table")
public class Task {
    @PrimaryKey(autoGenerate = true)
    private int id;

    private String title;

    private String description;

    private int priority;

    public Task(String title, String description, int priority) {
        this.title = title;
        this.description = description;
        this.priority = priority;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getPriority() {
        return priority;
    }
}
