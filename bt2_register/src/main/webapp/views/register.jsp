<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đăng ký</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/register" method="post">
		<h2>Tạo tài khoản mới</h2>

		<c:if test="${not empty alert}">
			<div class="alert alert-danger">${alert}</div>
		</c:if>


		<section>
			<label class="input login-input">
				<div class="input-group">
					<span class="input-group-addon"><i class="fa fa-user"></i></span> <input
						type="text" placeholder="Tài khoản" name="username"
						class="form-control" required value="${param.username}">
				</div>
			</label>
		</section>

		<section>
			<label class="input login-input">
				<div class="input-group">
					<span class="input-group-addon"><i class="fa fa-lock"></i></span> <input
						type="password" placeholder="Mật khẩu" name="password"
						class="form-control" required>
				</div>
			</label>
		</section>

		<section>
			<label class="input login-input">
				<div class="input-group">
					<span class="input-group-addon"><i class="fa fa-envelope"></i></span>
					<input type="email" placeholder="Email" name="email"
						class="form-control" required value="${param.email}">
				</div>
			</label>
		</section>

		<section>
			<label class="input login-input">
				<div class="input-group">
					<span class="input-group-addon"><i class="fa fa-id-card"></i></span>
					<input type="text" placeholder="Họ tên" name="fullname"
						class="form-control" required value="${param.fullname}">
				</div>
			</label>
		</section>

		<section>
			<label class="input login-input">
				<div class="input-group">
					<span class="input-group-addon"><i class="fa fa-phone"></i></span>
					<input type="text" placeholder="Số điện thoại" name="phone"
						class="form-control" value="${param.phone}">
				</div>
			</label>
		</section>

		<button type="submit" class="btn btn-primary">Đăng ký</button>
	</form>
</body>
</html>
