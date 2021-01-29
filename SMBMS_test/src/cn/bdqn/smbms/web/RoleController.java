package cn.bdqn.smbms.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;


import cn.bdqn.smbms.pojo.Role;
import cn.bdqn.smbms.service.roleservice.RoleService;

@Controller
@RequestMapping("/role")
public class RoleController {
	@Autowired
	private RoleService roleService;
	//¼ìË÷ÏÂÀ­²Ëµ¥
	@ResponseBody
	@RequestMapping("/login")
	public String getrole(Model model) {
		List<Role> getrole = roleService.getRole();
		return JSON.toJSONString(getrole);

	}
	
}
