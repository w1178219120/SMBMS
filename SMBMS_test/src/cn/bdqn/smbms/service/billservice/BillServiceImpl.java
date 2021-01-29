package cn.bdqn.smbms.service.billservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.bdqn.smbms.dao.bill.BillMapper;
import cn.bdqn.smbms.pojo.Bill;


@Service
public class BillServiceImpl implements BillService{
	@Autowired
	private BillMapper billMapper;
	@Override
	public int add(Bill bill) throws Exception {
		// TODO Auto-generated method stub
		return billMapper.add(bill);
	}

	@Override
	public List<Bill> getBillList(Bill bill) throws Exception {
		// TODO Auto-generated method stub
		return billMapper.getBillList(bill);
	}

	@Override
	public int deleteBillById(Integer delId) throws Exception {
		// TODO Auto-generated method stub
		return billMapper.deleteBillById(delId);
	}

	@Override
	public Bill getBillById(int id) throws Exception {
		// TODO Auto-generated method stub
		return billMapper.getBillById(id);
	}

	@Override
	public int modify(Bill bill) throws Exception {
		// TODO Auto-generated method stub
		return billMapper.modify(bill);
	}

	

	@Override
	public List<Bill> getbill() {
		// TODO Auto-generated method stub
		return billMapper.getBill();
	}

	@Override
	public Bill getBillCountByProviderId(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return billMapper.getBillCountByProviderId(id);
	}

}
