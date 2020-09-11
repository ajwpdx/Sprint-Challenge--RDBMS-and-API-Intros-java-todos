package com.lambdaschool.todos.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;


@Entity
@Table(name = "todos")
public class Todos extends Auditable
{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long todoid;

    @Column(nullable = false, unique = true)
    private String description;

    private boolean completed;

    @ManyToOne
    @JoinColumn(name = "userid")
//    @JsonIgnoreProperties(value = "todos", allowSetters = true)
    private User user;

    public Todos()
    {
    }

    public Todos(User user, String description)
    {
        this.user = user;
        this.description = description;
        this.completed = false;

    }

    public long getTodoid()
    {
        return todoid;
    }

    public void setTodoid(long todoid)
    {
        this.todoid = todoid;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public boolean isCompleted()
    {
        return completed;
    }

    public void setCompleted(boolean completed)
    {
        this.completed = completed;
    }

    public User getUser()
    {
        return user;
    }

    public void setUser(User user)
    {
        this.user = user;
    }
}
