package edu.model2.test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import edu.model2.bean.Clazz;
import edu.model2.bean.ClazzDao;
import edu.model2.bean.User;
import edu.model2.bean.UserDao;

public class TestDao {

	/**
	 * 测试user Dao层
	 */
	@Test
	public void testddUser() {
		User user = new User();
		user.setUserName("刘备");
		user.setUserEmail("73737@qq.com");
		user.setUserKey("123");
		user.setUserAccount("1");
		UserDao dao = new UserDao();
		dao.addUser(user);

	}

	@Test
	public void testDeleteUser() {
		UserDao dao = new UserDao();
		int id=3;
		try {
			if (dao.idExist(id)) {
				dao.deleteUser(id);
			}
			else
				System.out.println("---->>id"+id+"不存在");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void testUpdateUser(){
		User user = new User();
		user.setUserId(1);
		user.setUserName("刘备");
		user.setUserEmail("73737@qq.com");
		user.setUserKey("123");
		user.setUserAccount("1");
		UserDao dao = new UserDao();
		dao.updateUser(user);
	}
	@Test
	public void testFindAllUser(){
		UserDao dao = new UserDao();
		List<User> user =new ArrayList<User>();
		try {
			user=dao.findAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i=0;i<user.size();i++){
			

			System.out.print(user.get(i).getUserId()+ "\t");
			System.out.print(user.get(i).getUserName()+ "\t");
			System.out.print(user.get(i).getUserEmail() + "\t");
			System.out.print(user.get(i).getUserKey()+ "\t");
			System.out.print(user.get(i).getUserAccount() + "\n");
			
		}
	}
	@Test
	public void testFindById(){
		UserDao dao =new UserDao();
		User user= new User();
		user=dao.findUserById(2);
		System.out.print(user.getUserId()+ "\t");
		System.out.print(user.getUserName()+ "\t");
		System.out.print(user.getUserEmail() + "\t");
		System.out.print(user.getUserKey()+ "\t");
		System.out.print(user.getUserAccount() + "\n");
	}

	/**
	 * class Dao
	 */
	@Test
	public void testDelClazz(){
		ClazzDao dao = new ClazzDao();
		dao.deleteClazz(1);
	}
	@Test
	public void testUpdateClazz(){
		Clazz clazz = new Clazz();
		clazz.setClazzId(32);
		clazz.setClazzName("大南航1班");
		clazz.setClazzCode("11111111");
		ClazzDao dao = new ClazzDao();
		dao.updateClazz(clazz);
	}
	@Test
	public void testLoginDo(){
		UserDao dao=new UserDao();
		boolean i=dao.loginDo(1,"123");
		System.out.print("------>>>"+i);
	}
}
