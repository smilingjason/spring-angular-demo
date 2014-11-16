package demo.jason.springhello.dao;

import java.util.List;

import demo.jason.springhello.entity.Resource;

public interface ResourceDAO {

	List<Resource> findAll();
}
