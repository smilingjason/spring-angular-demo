package demo.jason.springhello.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import demo.jason.springhello.entity.Resource;
import demo.jason.springhello.entity.Todo;

@Component
public class TodoDAOImpl implements TodoDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Todo> findAllTodos() {
		Session session = sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		List<Todo> todos = (List<Todo>) session.createQuery("from Todo").list();
		System.out.println("Count of todos: "
				+ todos.size());
		session.close();
		return todos;
	}

}
