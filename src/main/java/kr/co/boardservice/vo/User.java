package kr.co.boardservice.vo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.apache.ibatis.type.Alias;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Alias("User")
public class User {

	private Integer no;
	
	private String id;
	
	@JsonIgnore
	private String password;
	
	private String nickname;
	
	private String email;
	@JsonFormat(pattern="yyyy년 M월 d일")
	private Date createdDate;
	@JsonFormat(pattern="yyyy년 M월 d일")
	private Date updatedDate;
	
	public User(Integer no, String id, String password, String nickname, String email) {
		super();
		this.no = no;
		this.id = id;
		this.password = password;
		this.nickname = nickname;
		this.email = email;
	}
	
	
}
