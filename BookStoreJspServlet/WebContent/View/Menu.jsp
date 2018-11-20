<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="sidebar" class="sidebar                  responsive                    ace-save-state">
			<script type="text/javascript">
					try{ace.settings.loadState('sidebar')}catch(e){}
			</script>
			<ul class="nav nav-list">
				<li class="">
					<a href="#" class="dropdown-toggle">
							<i class="menu-icon fa fa-desktop"></i>
							<span class="menu-text">
								Manage book store
							</span>

							<b class="arrow fa fa-angle-down"></b>
					</a>
					<b class="arrow"></b>
					<ul class="submenu">
						<li class="">
							<a href="#" class="dropdown-toggle">
									<i class="menu-icon fa fa-caret-right"></i>

									Book
									<b class="arrow fa fa-angle-down"></b>
							</a>
							<b class="arrow"></b>
							<ul class="submenu">
								<li class="">
										<a href="BookForward">
											<i class="menu-icon fa fa-caret-right"></i>
											Display all book
										</a>

										<b class="arrow"></b>
								</li>
								<li class="">
										<a href="ModifyBook">
											<i class="menu-icon fa fa-caret-right"></i>
											Add new book 
										</a>

										<b class="arrow"></b>
								</li>
								<li class="">
										<a href="two-menu-1.html">
											<i class="menu-icon fa fa-caret-right"></i>
											Top 20 book price
										</a>

										<b class="arrow"></b>
								</li>
									
							</ul>
						</li>
						<li class="">
							<a href="" class="dropdown-toggle">
									<i class="menu-icon fa fa-caret-right"></i>

									Category
									<b class="arrow fa fa-angle-down"></b>
							</a>
							<b class="arrow"></b>
							<ul class="submenu">
								<li class="">
										<a href="CategoryForward">
											<i class="menu-icon fa fa-caret-right"></i>
											Display all 
										</a>

										<b class="arrow"></b>
								</li>
								<li class="">
										<a href="ModifyCategory">
											<i class="menu-icon fa fa-caret-right"></i>
											Add new category 
										</a>

										<b class="arrow"></b>
								</li>
								<li class="">
										<a href="CategoryForward?command=TOP3">
											<i class="menu-icon fa fa-caret-right"></i>
											Top 3 seling
										</a>

										<b class="arrow"></b>
								</li>
								<li class="">
										<a href="CategoryForward?command=TOP3REVENUE">
											<i class="menu-icon fa fa-caret-right"></i>
											Top 3 revenue
										</a>

										<b class="arrow"></b>
								</li>
									
							</ul>
						</li>
						<li class="">
							<a href="#" class="dropdown-toggle">
									<i class="menu-icon fa fa-caret-right"></i>

									Author
									<b class="arrow fa fa-angle-down"></b>
							</a>
							<b class="arrow"></b>
							<ul class="submenu">
								<li class="">
										<a href="AuthorForward">
											<i class="menu-icon fa fa-caret-right"></i>
											Display all author
										</a>

										<b class="arrow"></b>
								</li>
								<li class="">
										<a href="ModifyAuthor">
											<i class="menu-icon fa fa-caret-right"></i>
											Add new author 
										</a>

										<b class="arrow"></b>
								</li>
								<li class="">
										<a href="AuthorForward?command=TOP3REVENUE">
											<i class="menu-icon fa fa-caret-right"></i>
											Top 3 author revenue 
										</a>

										<b class="arrow"></b>
								</li>
									
							</ul>
						</li>
					</ul>
				
				</li>
		
			</ul>
		</div>
</body>
</html>