package kr.co.boardservice.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class UserRegisterForm {

	@NotBlank(message = "아이디를 입력해주세요.")
	private String id;
	
	@NotBlank(message = "비밀번호를 입력해주세요.")
	@Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[~!@#$%^&*()+|=])[A-Za-z\\d~!@#$%^&*()+|=]{8,16}$", message = "비밀번호는 숫자, 영어대소문자, 특수문자가 1개 이상, 8글자 ~ 16글자까지 허용됩니다.")
	private String password;
	
	@NotBlank(message = "이름을 입력해주세요.")
	@Pattern(regexp = "^[가-힣]{2,}$", message = "이름은 한글로 2글자 이상만 허용됩니다.")
	private String name;
	
	@NotBlank(message = "이메일은 필수 입력값입니다.")		
	@Email(message = "유효한 이메일 형식이 아닙니다.")
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
