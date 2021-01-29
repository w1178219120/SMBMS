package cn.bdqn.smbms.service.userservice;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.bdqn.smbms.pojo.User;

public interface UserService {
	/**
	 * �����û���Ϣ
	 * @param connection
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public int add(User user)throws Exception;

	/**
	 * ͨ��userCode��ȡUser
	 * @param connection
	 * @param userCode
	 * @return
	 * @throws Exception
	 */
	public User getLoginUser(String userCode)throws Exception;

	/**
	 * ͨ��������ѯ-userList
	 * @param connection
	 * @param userName
	 * @param userRole
	 * @return
	 * @throws Exception
	 */
	public List<User> getUserList(@Param("userName")String userName,@Param("userRole")int userRole,@Param("currentPageNo")int currentPageNo,@Param("pageSize") int pageSize)throws Exception;
	/**
	 * ͨ��������ѯ-�û����¼��
	 * @param connection
	 * @param userName
	 * @param userRole
	 * @return
	 * @throws Exception
	 */
	public int getUserCount(@Param("userName")String userName,@Param("userRole")int userRole)throws Exception;
	
	/**
	 * ͨ��userIdɾ��user
	 * @param delId
	 * @return
	 * @throws Exception
	 */
	public int deleteUserById(Integer delId)throws Exception; 
	
	
	/**
	 * ͨ��userId��ȡuser
	 * @param connection
	 * @param id
	 * @return
	 * @throws Exception
	 */
	//public User getUserById(@Param("id")Integer id)throws Exception; 
	
	/**
	 * �޸��û���Ϣ
	 * @param connection
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public int modify(User user)throws Exception;
	
	
	/**
	 * �޸ĵ�ǰ�û�����
	 * @param connection
	 * @param id
	 * @param pwd
	 * @return
	 * @throws Exception
	 */
	/*public int updatePwd(@Param("id")int id,@Param("userPassword")String userPassword)throws Exception;*/
	
	
	
	public User login(String userName,String passWord);
	
	
	public List<User> getUser();
	
	public User getUserCode(String userCode);

	
	public User getUserById(Integer id);
	
	
	public User updatepwd(Integer id);
}
