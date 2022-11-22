package kr.co.boardservice.mapper;

import org.apache.ibatis.annotations.Mapper;

import kr.co.boardservice.vo.User;

@Mapper
public interface UserMapper {

	User getUserById(String id);
	User getUserByNo(int userNo);
	void insertUser(User user);
	void updateUser(User user);
	void disableUser(int userNo);
}
