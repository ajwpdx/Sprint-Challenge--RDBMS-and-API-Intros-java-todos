package com.lambdaschool.todos.services;

import com.lambdaschool.todos.models.Todos;

public interface TodosService
{
    Todos findTodoById(long id);

    void markComplete(long todoid);

    Todos save(Todos todo);
}
