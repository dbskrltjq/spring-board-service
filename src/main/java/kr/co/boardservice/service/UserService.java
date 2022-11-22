package kr.co.boardservice.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import kr.co.boardservice.exception.OnlineApplicationException;
import kr.co.boardservice.form.UserRegisterForm;
import kr.co.boardservice.mapper.UserMapper;
import kr.co.boardservice.vo.User;

@Service
@Transactional
public class UserService {

	@Autowired
	private UserMapper userMapper;
	
	@Value("${online.profile.image.save-directory}")
	private String profileImageSaveDirectory;
	
	public User getUserById(String id) {
		return userMapper.getUserById(id);
	}
	
	public User getUserByNo(int no) {
		return userMapper.getUserByNo(no);
	}
	
	public void addNewUser(UserRegisterForm userRegisterForm) throws Exception {
		
		User user = userMapper.getUserById(userRegisterForm.getId());
		if(user != null) {
			throw new OnlineApplicationException("이미 사용중인 아이디입니다.");
		}
		
		user = new User();
		BeanUtils.copyProperties(userRegisterForm, user);
		
		MultipartFile imgFile = userRegisterForm.getProfileFile();
		
		if(!imgFile.isEmpty()) {
			String fileName = imgFile.getOriginalFilename();
			user.setProfileImage(fileName);
	
			InputStream in = imgFile.getInputStream(); // 업로드된 첨부파일은 임시디렉토리에 저장되는데 그 파일을 읽어오는 스트림이다.
			FileOutputStream out = new FileOutputStream(new File(profileImageSaveDirectory, fileName));
			FileCopyUtils.copy(in, out);
		}
		
		userMapper.insertUser(user);
	}
}
