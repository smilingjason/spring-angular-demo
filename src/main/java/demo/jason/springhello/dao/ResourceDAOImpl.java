package demo.jason.springhello.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import demo.jason.springhello.entity.Resource;

@Component
public class ResourceDAOImpl implements ResourceDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Resource> findAll() {
		Session session = sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		List<Resource> resources = (List<Resource>) session.createQuery("from Resource").list();
		System.out.println("Count of resources: "
				+ resources.size());
		session.close();
		return resources;
	}

}
