package cn.itcast.bos.dao.impl;

import java.util.List;

import cn.itcast.bos.dao.IUserDao;
import cn.itcast.bos.dao.base.impl.BaseDaoImpl;
import cn.itcast.bos.domain.User;
import org.springframework.stereotype.Repository;



@Repository
public class UserDaoImpl extends BaseDaoImpl<User> implements IUserDao {
	/**
	 * 根据用户名和密码查询用户
	 */
	public User findUserByUsernameAndPassword(String username, String password) {
		String hql = "FROM User u WHERE u.username = ? AND u.password = ?";
		List<User> list = (List<User>) this.getHibernateTemplate().find(hql, username,password);
		if(list != null && list.size() > 0){
			return list.get(0);
		}
		return null;
	}

	@Override
	public void beanUpdate(String password, String id) {

		String hql = "FROM User u WHERE u.id = ?";
		User user = (User) this.getHibernateTemplate().find(hql,id);
		user.setPassword(password);
	}


}
