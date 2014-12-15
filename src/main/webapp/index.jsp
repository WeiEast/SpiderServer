<!doctype html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<html lang="en">

<head>
	<meta charset="utf-8"/>
	<title>Dashboard I Admin Panel</title>
	
	<link rel="stylesheet" href="css/layout.css" type="text/css" media="screen" />
	<!--[if lt IE 9]>
	<link rel="stylesheet" href="css/ie.css" type="text/css" media="screen" />
	<script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
	<![endif]-->
	<script src="js/jquery-1.5.2.min.js" type="text/javascript"></script>
	<script src="js/hideshow.js" type="text/javascript"></script>
	<script src="js/jquery.tablesorter.min.js" type="text/javascript"></script>
	<script type="text/javascript" src="js/jquery.equalHeight.js"></script>
	<script type="text/javascript">
	$(document).ready(function() 
    { 
    	$(".tablesorter").tablesorter(); 
   	} 
	);
	$(document).ready(function() {

	//When page loads...
	$(".tab_content").hide(); //Hide all content
	$("ul.tabs li:first").addClass("active").show(); //Activate first tab
	$(".tab_content:first").show(); //Show first tab content

	//On Click Event
	$("ul.tabs li").click(function() {

		$("ul.tabs li").removeClass("active"); //Remove any "active" class
		$(this).addClass("active"); //Add "active" class to selected tab
		$(".tab_content").hide(); //Hide all tab content

		var activeTab = $(this).find("a").attr("href"); //Find the href attribute value to identify the active tab + content
		$(activeTab).fadeIn(); //Fade in the active ID content
		return false;
	});

});
    </script>
    <script type="text/javascript">
    $(function(){
        $('.column').equalHeight();
    });
</script>
<script>
	function refresh(n){
		switch(n){
			case "edit":
				<!--首页-调度管理-新增调度-->
				document.getElementById("middle_breadcrumbs").innerHTML="调度管理";
				document.getElementById("current").innerHTML="新增调度";
				break;
			default:
				<!--同show-->
				document.getElementById("middle_breadcrumbs").innerHTML="调度管理";
				document.getElementById("current").innerHTML="全部调度";
				break;
		};
		document.getElementById("show_frame").src=n+".do";
	}	
</script>
</head>


<body>

	<header id="header">
		<hgroup>
			<h1 class="site_title"><a href="index.jsp">欢迎使用爬虫系统</a></h1>
			<h2 class="section_title"></h2><div class="btn_view_site"></div>
		</hgroup>
	</header> <!-- end of header bar -->
	
	<section id="secondary_bar">
		<div class="user">
			<p>张三 </p>
			<a class="logout_user" href="#" title="Logout">Logout</a>
		</div>
		<div class="breadcrumbs_container">
			<article class="breadcrumbs">
				<a href="index.jsp">首页</a>
				<div class="breadcrumb_divider"></div>
					<a id="middle_breadcrumbs" class="current">调度管理</a><div class="breadcrumb_divider">
				</div> 
				<a id="current" class="current">全部调度</a>
			</article>
		</div>
	</section><!-- end of secondary bar -->
	
	<aside id="sidebar" class="column">
		<form class="quick_search">
			<input type="text" value="Quick Search" onfocus="if(!this._haschanged){this.value=''};this._haschanged=true;">
		</form>
		<hr/>
		<h3>调度管理</h3>
		<ul class="toggle">
			<li class="icn_new_article"><a href="#" onclick='refresh("showAllSchema")'>调度管理</a></li>
			<li class="icn_edit_article"><a href="#" onclick='refresh("edit")'>新增调度</a></li>
			<!--<li class="icn_categories"><a href="#" onclick="refresh()">待办公文</a></li>
			<li class="icn_tags"><a href="#" onclick="refresh()">统计信息</a></li>-->
		</ul>		
		<footer>
			<hr />
			<p><strong>邮箱：joyofeveryday@163.com</strong></p>
		</footer>
	</aside><!-- end of sidebar -->
	
	<section id="main" class="column">
		<iframe id="show_frame" name="test" src="showAllSchema.do" frameborder=0 scrolling=no width="100%" height="100%">
			
		</iframe>
	</section>


</body>

</html>