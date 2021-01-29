package cn.bdqn.smbms.web;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

import cn.bdqn.smbms.pojo.Bill;
import cn.bdqn.smbms.pojo.Provider;
import cn.bdqn.smbms.service.providerservice.ProviderService;



@Controller
@RequestMapping("/provider")
public class ProviderController {
	
	@Autowired
	private ProviderService providerService;
	//查询
	@RequestMapping("/login")
	public String getProvider(Model model){
		List<Provider> provider = providerService.getProvider();
		model.addAttribute("providerList", provider);
		return "providerlist";
	}
	
	//检索下拉菜单
	
	@ResponseBody
	@RequestMapping("/showName")
	public String getProviderProName(Model model){
		List<Provider> getProviderProName = providerService.getProviderProName();
		return JSON.toJSONString(getProviderProName);
	}
	
	//删除
	@ResponseBody
	@RequestMapping(value="/delete")
	public String del(Integer providerid){
		int provider = providerService.deleteProviderById(providerid);
		String flag = null;
		if(provider>0){
			flag="true";
		}else{
			flag="flase";
		}
		
		return JSON.toJSONString(flag);
		
	}
	
	//修改
	@RequestMapping("/update")
	public String toUpdate(@ModelAttribute("provider")Provider provider,Model model){
		Provider providerById = providerService.getProviderById(provider.getId());
		model.addAttribute("provider", providerById);
		return "providermodify";
	}
	@RequestMapping("/updateprovider")
	public String updateprovider(Provider provider){
		int modify = providerService.modify(provider);
		if(modify>0){
			return "redirect:login";
		}else{
			return "providermodify";
		}
		
		
	}
	
	
	//查看详细信息
	@RequestMapping(value="/getpro")
	public String getUserById(Model model,Integer proid){
		
		try {
			Provider providerid = providerService.getProviderById(proid);
			model.addAttribute("provider", providerid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "providerview";
	}
	
	//新增
	
	@RequestMapping(value="/provideradd",method = RequestMethod.GET)
	public String addbill(@ModelAttribute("provider")Provider provider) {
		return "provideradd";
	}
	
	
	
	@RequestMapping(value="/add",method = RequestMethod.POST)
	public String addProvider(Provider provider,HttpSession session){
		try {
			provider.setCreationDate(new Date());
			if(providerService.addProvider(provider)>0){
				return "redirect:login";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "provideradd";
	
	}
}
