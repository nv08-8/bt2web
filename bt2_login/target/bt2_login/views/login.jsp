<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/login" method="post">
		<h2>Tạo tài khoản mới</h2>
		<c:if test="${alert != null}">
			<h3 class="alert alertdanger">${alert}</h3>
		</c:if>

		<!-- username -->
		<section>
			<label class="input login-input">
				<div class="input-group">
					<span class="input-group-addon"> <i class="fa fa-user"></i>
					</span> <input type="text" placeholder="Tài khoản" name="username"
						class="form-control">
				</div>
			</label>
		</section>

		<!-- password -->
		<section>
			<label class="input login-input">
				<div class="input-group">
					<span class="input-group-addon"> <i class="fa fa-lock"></i>
					</span> <input type="password" placeholder="Mật khẩu" name="password"
						class="form-control">
				</div>
			</label>
		</section>

		<!-- nút submit -->
		<div style="margin-top: 10px;">
			<button type="submit">Đăng nhập</button>
		</div>
	</form>
</body>
</html>
