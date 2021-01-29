package cn.bdqn.smbms.service.providerservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.bdqn.smbms.dao.bill.BillMapper;
import cn.bdqn.smbms.dao.provider.ProviderMapper;
import cn.bdqn.smbms.pojo.Provider;
@Service("providerService")
public class ProviderServiceImpl implements ProviderService{
	@Autowired
	private ProviderMapper providerMapper;
	
	@Override
	public int addProvider(Provider provider) {
		// TODO Auto-generated method stub
		return providerMapper.addProvider(provider);
	}

	@Override
	public List<Provider> getProviderList(String proName, String proCode) {
		// TODO Auto-generated method stub
		return providerMapper.getProviderList(proName, proCode);
	}

	@Override
	public int deleteProviderById(Integer delId) {
		// TODO Auto-generated method stub
		return providerMapper.deleteProviderById(delId);
	}



	@Override
	public int modify(Provider provider) {
		// TODO Auto-generated method stub
		return providerMapper.modify(provider);
	}

	@Override
	public List<Provider> getProvider() {
		// TODO Auto-generated method stub
		return providerMapper.getProvider();
	}

	@Override
	public List<Provider> getProviderProName() {
		// TODO Auto-generated method stub
		return providerMapper.getProviderProName();
	}

	@Override
	public Provider getProviderById(Integer id) {
		// TODO Auto-generated method stub
		return providerMapper.getProviderById(id);
	}

}
