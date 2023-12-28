package todo.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;


import todo.dao.TodoDao;
import todo.dto.TodoTask;
import todo.dto.TodoUser;
import todo.helper.AES;

@Component
public class TodoService {
	
	@Autowired
	TodoDao dao;

	public String signup(TodoUser user, String date, ModelMap map) {
		user.setDob(LocalDate.parse(date));
		user.setAge(Period.between(user.getDob(), LocalDate.now()).getYears());
		user.setPassword(AES.encrypt(user.getPassword(), "123"));
		;
		if (user.getAge() < 18) {
			map.put("dob", "* You have to be 18+ to create Account");
			return "Signup";
		} else {
			List<TodoUser> list = dao.findByEmail(user.getEmail());
			if (list.isEmpty()) {
				dao.save(user);
				map.put("pass", "Account Created Success");
				return "Login";
			} else {
				map.put("email", "* Email Should be Unique");
				return "Signup";
			}
		}
	}

	public String login(String email, String password, ModelMap map, HttpSession session) {
		List<TodoUser> list = dao.findByEmail(email);
		if (list.isEmpty()) {
			map.put("email", "* Incorrect Email");
			return "Login";
		} else {
			if (password.equals(AES.decrypt(list.get(0).getPassword(), "123"))) {
				session.setAttribute("todouser", list.get(0));

				map.put("list", dao.fetchAllTask(list.get(0).getId()));
				map.put("pass", "Login Success");
				return "Home";
			} else {
				map.put("password", "* Incorrect Password");
				return "login";
			}
		}
	}

	public String loadHome(HttpSession session, ModelMap map) {
		TodoUser user = (TodoUser) session.getAttribute("todouser");
		if (user == null) {
			map.put("fail", "Invalid Session");
			return "login";
		} else {
			map.put("list", dao.fetchAllTask(user.getId()));
			return "Home";
		}
	}

	public String logout(HttpSession session, ModelMap map) {
		session.invalidate();
		map.put("pass", "Logout Success");
		return "login";
	}

	public String addTask(HttpSession session, ModelMap map) {
		TodoUser user = (TodoUser) session.getAttribute("todouser");
		if (user == null) {
			map.put("fail", "Invalid Session");
			return "login";
		} else {
			return "AddTask";
		}
	}

	public String addTask(TodoTask task, HttpSession session, ModelMap map) {
		TodoUser user = (TodoUser) session.getAttribute("todouser");
		if (user == null) {
			map.put("fail", "Invalid Session");
			return "login";
		} else {
			task.setCreatedTime(LocalDateTime.now());
			task.setUser(user);
			dao.save(task);
			
			map.put("list", dao.fetchAllTask(user.getId()));
			map.put("pass", "Data Saved Success");
			return "Home";
		}
	}

	public String changeStatus(int id, HttpSession session, ModelMap map) {
		TodoUser user = (TodoUser) session.getAttribute("todouser");
		if (user == null) {
			map.put("fail", "Invalid Session");
			return "login";
		} else {
			TodoTask task=(TodoTask)dao.findById(id);
			task.setStatus(true);
			dao.update(task);
			
			map.put("list", dao.fetchAllTask(user.getId()));
			map.put("pass", "Status change");
			return "Home";
			
		}
	}

	public String deleteTask(int id, HttpSession session, ModelMap map) {
		TodoUser user = (TodoUser) session.getAttribute("todouser");
		if (user == null) {
			map.put("fail", "Invalid Session");
			return "login";
		} else {
			TodoTask task=(TodoTask)dao.findById(id);
			task.setStatus(true);
			dao.delete(task);
			
			map.put("list", dao.fetchAllTask(user.getId()));
			map.put("pass", "Delete Task");
			return "Home";
			
		}
	}

	public String updateTask(TodoTask task, HttpSession session, ModelMap map) {
		TodoUser user = (TodoUser) session.getAttribute("todouser");
		if (user == null) {
			map.put("fail", "Invalid Session");
			return "login";
		} else {
			task.setUser(user);
			task.setCreatedTime(LocalDateTime.now());
			dao.update(task);
			map.put("list", dao.fetchAllTask(user.getId()));
			map.put("pass", "Update  Task");
			return "Home";
			
			
		}
		
	}

	public String editTask(int id, HttpSession session, ModelMap map) {
		TodoUser user = (TodoUser) session.getAttribute("todouser");
		if (user == null) {
			map.put("fail", "Invalid Session");
			return "login";
		} else {
			TodoTask task = dao.findById(id);
			map.put("task", task);
			return "EditTask";
				
	}
	}

}
