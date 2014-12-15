<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
	<meta http-equiv="content-type" content="text/html;charset=UTF-8" />
	<link rel="stylesheet" href="css/layout.css" type="text/css" media="screen" />
	<!--[if lt IE 9]>
	<link rel="stylesheet" href="css/ie.css" type="text/css" media="screen" />
	<script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
	<![endif]-->
	<script src="js/jquery-1.5.2.min.js" type="text/javascript"></script>
	<script src="js/hideshow.js" type="text/javascript"></script>
	<script src="js/jquery.tablesorter.min.js" type="text/javascript"></script>
	<script type="text/javascript" src="js/jquery.equalHeight.js"></script>
</head>
<body>
	<section id="main" class="column">
		<article class="module width_3_quarter">
			<header>
				<h3 class="tabs_involved">全部调度</h3>
			</header>

		<div class="tab_container">
			<div id="tab1" class="tab_content">
			<table class="tablesorter" cellspacing="0"> 
			<tbody>
                <tr>
                    <td></td>
                    <td>调度名称</td>
                    <td>调度状态</td>
                    <td>调度周期</td>
                    <td></td>
                </tr>
                <c:forEach items="${articles}" var="item">
                    <tr>
                        <td><input type="checkbox"></td>
                        <td><c:out value="${item.schemaName}"></c:out></td>
                        <td><c:if test="${item.stat=='0'}">Waiting</c:if><c:if test="${item.stat=='1'}">Running</c:if></td>
                        <td><c:out value="${item.cycle}"></c:out>小时</td>
                        <td><input type="image" src="images/icn_edit.png" title="Edit"><input type="image" src="images/icn_trash.png" title="Trash"/></td>
                    </tr>
                </c:forEach>
			</tbody> 
			</table>
			</div><!-- end of #tab1 -->
		</div><!-- end of .tab_container -->
</article><!-- end of content manager article -->
</section>
</body>