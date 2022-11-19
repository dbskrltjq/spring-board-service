package kr.co.boardservice.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.boardservice.mapper.UserMapper;
import kr.co.boardservice.vo.User;

@Service
@Transactional
public class UserService {

	@Autowired
	private UserMapper userMapper;
	
	public User getUserById(String id) {
		return userMapper.getUserById(id);
	}
	
	public User getUserByNo(int no) {
		return userMapper.getUserByNo(no);
	}
	
	public void addNewUser(User user) {
		userMapper.insertUser(user);
	}
}
