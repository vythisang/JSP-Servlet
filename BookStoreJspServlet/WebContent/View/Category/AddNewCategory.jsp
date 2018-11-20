<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="Template/assets/css/bootstrap.min.css" />
<link rel="stylesheet"
	href="Template/assets/font-awesome/4.5.0/css/font-awesome.min.css" />

<link rel="stylesheet"
	href="Template/assets/css/fonts.googleapis.com.css" />

<link rel="stylesheet" href="Template/assets/css/ace.min.css" />

<link rel="stylesheet"
	href="Template/assets/css/ace-rtl.min.css" />
<title>Register</title>
<script type="text/javascript">

	function validate(){
		
		var email = document.myform.email.value;
		var name = document.myform.name.value;
		var password = document.myform.password.value;
		var dob = document.myform.dob.value;
		
		if(email == "" || name=="" || password=="" || dob==""){
			alert("Do not empty");
			return false;
		}
		
		
	}





</script>


</head>
<body class="login-layout">
	<div class="main-container">
		<div class="main-content">
			<div class="row">
				<div class="col-sm-10 col-sm-offset-1">
					<div class="login-container">
						<div class="center">
							<h1>
								<i class="ace-icon fa fa-leaf green"></i> <span class="red">Book store</span>
								<span class="white" id="id-text2">Application</span>
							</h1>
							<h4 class="blue" id="id-company-text">&copy; Industrial HCM</h4>
						</div>

						<div class="space-6"></div>

						<div class="position-relative">
							<div id="login-box"
								class="login-box visible widget-box no-border">
								<div class="widget-body">
									<div class="widget-main">
										<h4 class="header blue lighter bigger">
											<i class="ace-icon fa fa-coffee green"></i>Add new categpry
										</h4>

										<div class="space-6"></div>

										<form action="CategoryForward" method="get" name ="myform" onsubmit="return validate()">
											
											<fieldset>
												<label class="block clearfix">
													<%= request.getAttribute("msgregister") != null ? request.getAttribute("msgregister"): " " %>
												</label>
												<label class="block clearfix"> <span
													class="block input-icon input-icon-right"> <input
														type="text" class="form-control" placeholder="name" name="name"  />
														<i class="ace-icon fa fa-user"></i>
												</span>
												</label> 
												
												
												
												
												
												<div class="space"></div>

												<div class="clearfix">
													
													<input type="hidden" name="command" value="NEW" />
													<button type="submit"
														class="width-35 pull-right btn btn-sm btn-primary">
														<i class="ace-icon fa fa-key"></i> <span
															class="bigger-110">Add New</span>
													</button>
												</div>

												<div class="space-4"></div>
											</fieldset>
										</form>

										

										<div class="space-6"></div>

										
									</div>
									<!-- /.widget-main -->

									<div class="toolbar clearfix">

										<div>
											<a href="HomeForward" 
												class="user-signup-link">  Comback home<i
												class="ace-icon fa fa-arrow-left"></i>
											</a>
										</div>
										<div>
											<a href="LoginForward" 
												class="user-signup-link">  Login <i
												class="ace-icon fa fa-arrow-right"></i>
											</a>
										</div>
									</div>
								</div>
								<!-- /.widget-body -->
							</div>
							

								
							<!-- /.signup-box -->
						</div>
						<!-- /.position-relative -->

						<div class="navbar-fixed-top align-right">
							<br /> &nbsp; <a id="btn-login-dark" href="#">Dark</a> &nbsp; <span
								class="blue">/</span> &nbsp; <a id="btn-login-blur" href="#">Blur</a>
							&nbsp; <span class="blue">/</span> &nbsp; <a id="btn-login-light"
								href="#">Light</a> &nbsp; &nbsp; &nbsp;
						</div>
					</div>
				</div>
				<!-- /.col -->
			</div>
			<!-- /.row -->
		</div>
		<!-- /.main-content -->
	</div>





	<script src="Template/assets/js/jquery-2.1.4.min.js"></script>

	<script type="text/javascript">
		if ('ontouchstart' in document.documentElement)
			document
					.write("<script src='Template/assets/js/jquery.mobile.custom.min.js'>"
							+ "<"+"/script>");
	</script>

	<!-- inline scripts related to this page -->
	<script type="text/javascript">
		jQuery(function($) {
			$(document).on('click', '.toolbar a[data-target]', function(e) {
				e.preventDefault();
				var target = $(this).data('target');
				$('.widget-box.visible').removeClass('visible');//hide others
				$(target).addClass('visible');//show target
			});
		});

		//you don't need this, just used for changing background
		jQuery(function($) {
			$('#btn-login-dark').on('click', function(e) {
				$('body').attr('class', 'login-layout');
				$('#id-text2').attr('class', 'white');
				$('#id-company-text').attr('class', 'blue');

				e.preventDefault();
			});
			$('#btn-login-light').on('click', function(e) {
				$('body').attr('class', 'login-layout light-login');
				$('#id-text2').attr('class', 'grey');
				$('#id-company-text').attr('class', 'blue');

				e.preventDefault();
			});
			$('#btn-login-blur').on('click', function(e) {
				$('body').attr('class', 'login-layout blur-login');
				$('#id-text2').attr('class', 'white');
				$('#id-company-text').attr('class', 'light-blue');

				e.preventDefault();
			});

		});
	</script>

</body>
</html>