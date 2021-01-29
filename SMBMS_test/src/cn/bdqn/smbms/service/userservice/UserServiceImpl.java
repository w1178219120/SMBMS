package cn.bdqn.smbms.service.userservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.bdqn.smbms.dao.role.RoleMapper;
import cn.bdqn.smbms.dao.user.UserMapper;
import cn.bdqn.smbms.pojo.User;
@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserMapper userMapper;
	@Override
	public int add(User user) throws Exception {
		// TODO Auto-generated method stub
		return userMapper.add(user);
	}

	@Override
	public User getLoginUser(String userCode) throws Exception {
		// TODO Auto-generated method stub
		return userMapper.getLoginUser(userCode);
	}

	@Override
	public List<User> getUserList(String userName, int userRole,
			int currentPageNo, int pageSize) throws Exception {
		// TODO Auto-generated method stub
		return userMapper.getUserList(userName, userRole, currentPageNo, pageSize);
	}

	@Override
	public int getUserCount(String userName, int userRole) throws Exception {
		// TODO Auto-generated method stub
		return userMapper.getUserCount(userName, userRole);
	}

	@Override
	public int deleteUserById(Integer delId) throws Exception {
		// TODO Auto-generated method stub
		return userMapper.deleteUserById(delId);
	}

/*	@Override
	public User getUserById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return userMapper.getUserById(id);
	}*/

	@Override
	public int modify(User user) throws Exception {
		// TODO Auto-generated method stub
		return userMapper.modify(user);
	}

	/*@Override
	public int updatePwd(int id, String userPassword) throws Exception {
		// TODO Auto-generated method stub
		return userMapper.updatePwd(id, userPassword);
	}*/

	@Override
	public User login(String userName, String passWord) {
		// TODO Auto-generated method stub
		return userMapper.getUserByUserNameAndPassword(userName, passWord);
	}

	@Override
	public List<User> getUser() {
		// TODO Auto-generated method stub
		return userMapper.getUser();
	}

	@Override
	public User getUserCode(String userCode) {
		// TODO Auto-generated method stub
		return userMapper.getUserCode(userCode);
	}

	@Override
	public User getUserById(Integer id) {
		// TODO Auto-generated method stub
		return userMapper.getUserById(id);
	}

	@Override
	public User updatepwd(Integer id) {
		// TODO Auto-generated method stub
		return userMapper.updatepwd(id);
	}

}
