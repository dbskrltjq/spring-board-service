<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="common/tags.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<title>스프링 게시판</title>
</head>
<body>
<c:set var="menu" value="home"/>
<%@ include file="common/nav.jsp" %>
<div class="container my-3">
    <div class="row">
        <div class="col">
            <div class="border p-3 bg-light">
                <h1 class="mb-4">스프링 부트 샘플 애플리케이션.</h1>
                <p class="mb-0">스프링 부트 샘플 애플리케이션입니다.</p>
                <p class="">할일 관리 게시판 기능을 제공하는 웹 애플리케이션 입니다.</p>
				<c:if test="${empty LOGIN_USER}">
                 <div>
                 	<button type="button" class="btn btn-outline-primary" data-bs-toggle="modal" data-bs-target="#modal-register">회원가입</button>
                     <a href="/login" class="btn btn-primary">로그인</a>
                 </div>
                </c:if>
            </div>
        </div>
    </div>
</div>

<!-- 회원가입 모달 -->
<div class="modal fade" id="modal-register" data-bs-backdrop="static" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h1 class="modal-title fs-5" id="exampleModalLabel">회원 가입</h1>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
      	<p>아이디, 비밀번호, 이름, 이메일을 입력하세요.</p>
            <form:form class="border bg-light p-3" method="post"  action="register" modelAttribute="userRegisterForm" enctype="multipart/form-data">
                <div class="mb-3">
                	<label for="id-field" class="form-label">아이디</label>
                	<form:input class="form-control" path="id" id="id-field" />
                	<form:errors path="id" class="text-danger small fst-italic"></form:errors>
                </div>
                <div class="mb-3">
                	<label for="password-field" class="form-label">비밀번호</label>
                	<form:input class="form-control" type="password" path="password" id="password-field" placeholder="비밀번호는 영어 대소문자와 숫자로 8글자 ~ 20글자입니다."/>
                	<form:errors path="password" class="text-danger small fst-italic"></form:errors>
                </div>
                <div class="mb-3">
                	<label for="name-field" class="form-label">이름</label>
                	<form:input class="form-control" path="name" id="name-field" placeholder="이름은 한글로 2글자 이상입니다."/>
                	<form:errors path="name" class="text-danger small fst-italic"></form:errors>
                </div>
                <div class="mb-3">
                	<label for="email-field" class="form-label">이메일</label>
                	<form:input class="form-control" path="email" id="email-field" placeholder="sample@naver.com"/>
                	<form:errors path="email" class="text-danger small fst-italic"></form:errors>
                </div>
                <div class="mb-3">
                	<label for="tel-field" class="form-label">프로필이미지</label>
                	<input type="file" class="form-control" name="profileFile" id="profile-file-field" placeholder="010-1234-5678"/>
                </div>
                <div class="text-end">
                	<a href="/" class="btn btn-secondary">취소</a>
                	<button type="submit" class="btn btn-primary">회원가입</button>
                </div>
            </form:form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary">Save changes</button>
      </div>
    </div>
  </div>
</div>


<script type="text/javascript">
$(function() {
	
	
	
}
)


</script>
</body>
</html>