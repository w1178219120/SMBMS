package cn.bdqn.smbms.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.ProcessBuilder.Redirect;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

import cn.bdqn.smbms.pojo.User;
import cn.bdqn.smbms.service.userservice.UserService;



@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
	
	//查看
	@RequestMapping("/show")
	public String getUser(Model model){
		List<User> user2 = userService.getUser();
		model.addAttribute("userList", user2);
		return "userlist";
	}
	@RequestMapping(value="/login" , method = RequestMethod.POST)
	public String login(Model model,@RequestParam("userCode") String userName,@RequestParam("userPassword")String passWord){
		User user = userService.login(userName, passWord);
		if(user != null){
			
			return "redirect:show";
		}else{
			throw new RuntimeException("出错啦");
			
		}
	
		}
	
	//增加
	@RequestMapping(value="/useradd",method = RequestMethod.GET)
	public String useradd(@ModelAttribute("user")User user){
		return "useradd";
		
	}
	
	@RequestMapping(value="/add",method = RequestMethod.POST)
	public String add(User user,HttpSession session){
		
		try {
			user.setCreationDate(new Date());
			if(userService.add(user)>0){
				return "redirect:show";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "useradd";
		
	}
	
	//修改
	@RequestMapping(value="/update")
	public String toUpdate(@ModelAttribute("user") User user,Model model){
			User userById = userService.getUserById(user.getId());
		model.addAttribute("user", userById);
		return "usermodify";
	}
	@RequestMapping(value="/updateuser")
	public String updateUser(User user){
		try {
			int modify = userService.modify(user);
			if(modify>0){
				return "redirect:show";
			}else{
				return "usermodify";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	//修改账户密码
	@RequestMapping(value="/updatepwd")
	public String updatepwd(User user,Model model){
		User updatepwd = userService.updatepwd(user.getId());
		model.addAttribute(arg0, updatepwd);
		return null;
		
	}
	
	//删除
	@ResponseBody
	@RequestMapping(value="/delete")
	public String del(Integer userid){
		String flag = null;
		try {
			int user = userService.deleteUserById(userid);
			if(user>0){
				flag="true";
				
			}else{
				flag="false";
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return JSON.toJSONString(flag);
		}
	
	
	
	//查询详细信息
	@RequestMapping(value="/getUser")
	public String getUserById(Model model,Integer uid){
		User userById = userService.getUserById(uid);
		model.addAttribute("user", userById);
		return "userview";
	}
	
	//账号检索
	@RequestMapping(value="/userCode")
	public void userCode(String userCode,HttpServletResponse response){
		User user = userService.getUserCode(userCode);
		
		boolean flag = false;
		if(user!=null){
			flag=true;
		}else{
			flag=false;
		}
		PrintWriter out = null;
		
		try {
			out=response.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		out.print(flag);
		
		
		
	}
	
	
	
	@RequestMapping("/")
	public String toIndex(){
		return "login";
	}
	
	/*@ExceptionHandler(value={RuntimeException.class,Exception.class})
	public String exceptionHandler(RuntimeException e,HttpServletRequest request){
		request.setAttribute("e", e.getMessage());
		return "error"; }*/

	
	
}
