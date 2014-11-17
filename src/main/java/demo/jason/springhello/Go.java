package demo.jason.springhello;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import demo.jason.springhello.entity.Event;
import demo.jason.springhello.entity.Resource;
import demo.jason.springhello.entity.Todo;
import demo.jason.springhello.entity.User;

public class Go {

	public static void main(String[] args) {
		
		Configuration config = new Configuration();
		config.addAnnotatedClass(Event.class);
		config.addAnnotatedClass(Resource.class);
		config.addAnnotatedClass(User.class);
		config.addAnnotatedClass(Todo.class);
		
		config.configure();

		// A SessionFactory is set up once for an application
		StandardServiceRegistryBuilder ssrb 
			= new StandardServiceRegistryBuilder().applySettings(config.getProperties());
		SessionFactory sessionFactory = config.buildSessionFactory(ssrb.build());
		
		createTodos(sessionFactory);
		
		/*
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		
		Resource r = (Resource) session.createQuery("from Resource where id = 1").uniqueResult();
		
		Event e = r.getEvents().get(0);
		
		System.out.println(e.getTitle() + r.getEvents().getClass().getName());
		*/
		/*
		
		*/
		
		//session.getTransaction().commit();		
		Resource r = getResource(sessionFactory);
		test2(r, sessionFactory);
		sessionFactory.close();
	}
	
	private static void test1(SessionFactory sessionFactory) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		
		Resource r = new Resource();		
		r.setName("humility 2");
		for (int i = 0; i < 10; i++) {
			Event e = new Event();
			e.setTitle("Jason wakes up " + i);
			e.setTime(new java.util.Date());
			
			e.setResource(r);
			r.getEvents().add(e);
		}
		session.save(r);
		
		session.getTransaction().commit();
	}

	private static void test2(Resource r, SessionFactory sessionFactory) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.refresh(r);
		int size = r.getEvents().size();
		System.out.println(size);
		for(int i = 0; i < size; i++) {
			System.out.println(i + ": " + r.getEvents().get(i).getTitle());
		}
	}
	
	private static Resource getResource(SessionFactory sessionFactory) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		Resource r = (Resource) session.get(Resource.class, 3); 
				//(Resource) session.createQuery("from Resource where id = 3").uniqueResult();
		//Hibernate.initialize(r.getEvents());
		session.getTransaction().commit();
		return r;
	}
	
	private static void testOneToOne(SessionFactory sessionFactory) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		User user = new User();
		user.setName("JasonHuang2");
		
		Resource r = new Resource();
		r.setName("Resource 1");
		
		user.setResource(r);
		
		session.save(user);
		
		session.getTransaction().commit();
		
	}
	
	public static void createTodos(SessionFactory sessionFactory) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		Todo todo = new Todo();
		todo.setTitle("Play game hardly.");
		session.save(todo);
		
		session.getTransaction().commit();
	}
}
