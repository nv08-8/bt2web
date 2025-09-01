<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đăng nhập</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/login" method="post">
		<h2>Đăng nhập</h2>
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
		<div class="row margin-bottom-5">
			<div class="col-xs-6">
				<label class="checkbox"> <input type="checkbox"
					name="remember" /> <i></i> Nhớ tôi
				</label>
			</div>

			<div class="col-xs-6 text-right">
				<a href="#">Quên mật khẩu?</a>
			</div>
		</div>
		<button class="btn-u btn-u-sea-shop btn-block margin-bottom-20"
			type="submit">Đăng nhập</button>

	</form>
	<div class="margin-bottom-20"></div>
	<p class="text-center">
		Nếu bạn chưa có tài khoản trên hệ thống, thì hãy <a
			href="${pageContext.request.contextPath }/register">Đăng ký</a>
	</p>
</body>
</html>
