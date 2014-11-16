package demo.jason.springhello;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import demo.jason.springhello.dao.TodoDAO;
import demo.jason.springhello.entity.Todo;

@RestController
public class TodoController {

	@Autowired
	private TodoDAO todoDAO;
	
	@RequestMapping(
			value = "/todos",
			method = RequestMethod.GET
			)
	public @ResponseBody List<Todo> todos() {		
		return todoDAO.findAllTodos();
	}
	
	@RequestMapping(
			value = "/todos/{id}",
			method = RequestMethod.DELETE
			)	
	public @ResponseBody Result delete(@PathVariable int id) {	
		Result result = new Result();
		System.out.println("deleting todo with id: " + id);
		return result;
	}
	
	@RequestMapping(
			value = "/todos",
			method = RequestMethod.POST
			)	
	public @ResponseBody Result modify(@RequestBody Todo todo) {	
		Result result = new Result();
		System.out.println("modifying todo with id: " + todo);
		return result;
	}
	
	@RequestMapping(
			value = "/todos",
			method = RequestMethod.PUT
			)	
	public @ResponseBody Result create(@RequestBody Todo todo) {	
		Result result = new Result();
		System.out.println("creating todo: " + todo.getTitle());
		return result;
	}
}
