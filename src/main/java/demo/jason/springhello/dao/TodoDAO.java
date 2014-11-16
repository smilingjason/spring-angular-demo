package demo.jason.springhello.dao;

import java.util.List;

import demo.jason.springhello.entity.Todo;

public interface TodoDAO {

	public List<Todo> findAllTodos();
}
