package todo.controller;




import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import todo.dto.TodoTask;
import todo.dto.TodoUser;
import todo.service.TodoService;


@Controller
public class TodoController {
	@Autowired
	TodoService service;

	@GetMapping({ "/", "/login" })
	public String loadLogin() {
		return "login";
	}

	@GetMapping("/Signup")
	public String loadSignup() {
		return "Signup";
	}

	@GetMapping("/home")
	public String loadHome(HttpSession session, ModelMap map) {
		return service.loadHome(session,map);
	}

	@PostMapping("/signup")
	public String signup(TodoUser user, @RequestParam String date, ModelMap map) {
		return service.signup(user, date, map);
	}

	@PostMapping("/login")
	public String login(@RequestParam String email, String password, ModelMap map, HttpSession session) {
		return service.login(email, password, map, session);
	}

	@GetMapping("/logout")
	public String logout(HttpSession session, ModelMap map) {
		return service.logout(session,map);
	}

	@GetMapping("/add-task")
	public String loadAddTask(HttpSession session, ModelMap map) {
		return service.addTask(session,map);
	}
	
	@PostMapping("/add-task")
	public String addTask(TodoTask task,HttpSession session, ModelMap map) {
		return service.addTask(task,session,map);
	}
    @GetMapping("/change-status")
	public String changeStatus(@RequestParam int id,HttpSession session, ModelMap map ) {
    	
    	return service.changeStatus(id,session,map);
    }
    @GetMapping("/delete")
   	public String deleteTask(@RequestParam int id,HttpSession session, ModelMap map ) {
       	
       	return service.deleteTask(id,session,map);
       }
    @GetMapping("/Edit")
    public String EditTask(@RequestParam int id,HttpSession session, ModelMap map) {
    	return service.editTask(id,session ,map);
    }
    @PostMapping("/update-task")
    public String updatetask( TodoTask task ,HttpSession session, ModelMap map ) {
    	return service.updateTask(task,session,map);
    }
	 
}
	
	

