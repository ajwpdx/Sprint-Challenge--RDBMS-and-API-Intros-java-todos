package com.lambdaschool.todos.repository;

import com.lambdaschool.todos.models.Todos;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface TodosRepository extends CrudRepository<Todos, Long>
{
    @Modifying
    @Query (value = "UPDATE todos " +
            "SET completed = :completed, " +
            "    last_modified_date = CURRENT_TIMESTAMP " +
            "    last_modified_by = :uname " +
            "WHERE todoid = :todoid", nativeQuery = true)
    void updateCompleted(long todoid, boolean completed, String uname);
}
