package com.lambdaschool.todos.services;


import com.lambdaschool.todos.models.Todos;
import com.lambdaschool.todos.repository.TodosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;

@Transactional
@Service
public class TodosServiceImpl implements TodosService
{
    @Autowired
    TodosRepository todosrepos;

    @Autowired
    UserAuditing userAuditing;

    @Override
    public Todos findTodoById(long id)
    {
        return todosrepos.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Todo id " + id + " not found!"));
    }


    @Transactional
    @Override
    public void markComplete(long todoid)
    {
        Todos updatedTodo = findTodoById(todoid);
        todosrepos.updateCompleted(todoid, updatedTodo.isCompleted(), userAuditing.getCurrentAuditor().get());

    }

    @Transactional
    @Override
    public Todos save(Todos todo)
    {

        return todosrepos.save(todo);
    }

}
