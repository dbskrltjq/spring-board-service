package kr.co.boardservice.form;


import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class UserRegisterForm {

	private String id;
	private String password;
	private String name;
	private String email;
	private MultipartFile profileFile;
	
	/*
	 *  MultipartFile 
	 *  	* 스프링에서 첨부파일 처리를 위해서 제공하는 객체다.
	 *  		- MultipartFile객체는 항상 null이 아니다. 
	 *            즉, 파일의 첨부여부와 상관없이 항상 null이 아니다(MultipartFile객체는 생성되어 profileFile에 담겨있다)
	 *  		  단, 해당 입력필드가 disabled 상태일 때는 null이다.
	 *  	* 주요 API(메소드)
	 *  		- String getOriginalFilename()	: 첨부파일명을 반환한다.
	 *  		- String getContentType()		: 첨부파일의 컨텐츠 타입을 반환한다.
	 *  		- boolean isEmpty()				: 첨부파일이 업로드되지 않았을 때 true를 반환한다.
	 *  		- long getSize()				: 첨부파일의 크기를 byte 단위로 반환한다.
	 *  		- byte[] getBytes()				: 첨부파일의 데이터를 byte[] 배열로 반환한다.
	 *  		- InputStream getInputStream()	: 업로드된 첨부파일을 읽어오는 읽기 전용 스트림을 반환한다.
	 */
}
