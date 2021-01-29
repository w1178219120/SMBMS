package cn.bdqn.smbms.service.roleservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.bdqn.smbms.dao.provider.ProviderMapper;
import cn.bdqn.smbms.dao.role.RoleMapper;
import cn.bdqn.smbms.pojo.Role;
@Service
public class RoleServiceImpl implements RoleService{
	@Autowired
	private RoleMapper roleMapper;
	@Override
	public List<Role> getRole() {
		// TODO Auto-generated method stub
		return roleMapper.getRole();
	}

}
