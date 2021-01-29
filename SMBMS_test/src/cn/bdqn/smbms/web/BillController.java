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
import cn.bdqn.smbms.pojo.User;
import cn.bdqn.smbms.service.billservice.BillService;

@Controller
@RequestMapping("/bill")
public class BillController {
	@Autowired
	private BillService billService;
	//查询
	@RequestMapping("/login")
	public String getbill(Model model) {
		List<Bill> getbill = billService.getbill();
		model.addAttribute("billList", getbill);
		return "billlist";
	}
	
	//删除
	@ResponseBody
	@RequestMapping(value="/delete")
	public String del(Integer billid){
		String flag = null;
		try {
			int bill = billService.deleteBillById(billid);
			if(bill>0){
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
	
	//修改
	@RequestMapping("/update")
	public String toUpdate(Integer billid,Model model){
		try {
			Bill billById = billService.getBillById(billid);
			model.addAttribute("bill", billById);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "billmodify";
	}
	
	@RequestMapping("/updatebill")
	public String updateBill(Bill bill){
		try {
			int modify = billService.modify(bill);
			if(modify>0){
				return "redirect:login";
			}else{
				return "billmodify";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
	//显示详细信息
	@RequestMapping(value="/getbill")
	public String getUserById(Model model,Integer billid){
		Bill billById;
		try {
			billById = billService.getBillCountByProviderId(billid);
			model.addAttribute("bill", billById);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "billview";
	}
	
	//增加
	@RequestMapping(value="/billadd",method = RequestMethod.GET)
	public String addbill(@ModelAttribute("bill")Bill bill) {
		return "billadd";
	}
	
	@RequestMapping(value="/add",method = RequestMethod.POST)
	public String add(Bill bill,HttpSession session){
		try {
			bill.setCreationDate(new Date());
			if(billService.add(bill)>0){
				return "redirect:login";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "billadd";
	}
	

}