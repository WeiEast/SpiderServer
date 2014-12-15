<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
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
    <script>
        var schedule_count = 0;
        var storage_count = 0;
        function add_schedule(){
            schedule_count += 1;
            var source = "<div class=\"module_div\">";
            source += "<label class=\"info_content\">"+schedule_count+"</label>";
            source += "<input name=\"schedularId\" type=\"hidden\" value=\""+schedule_count+"\">";
            source += "<div class=\"info_content\">";
            source += "<select name=\"fetchmode\"><option>抓取</option><option>取值</option></select></div>";
            source += "<div class=\"info_content\"><input name=\"fetchsource\" type=\"text\" size=\"20\" maxlength=\"150\"/></div>";
            source += "<div class=\"info_content\">";
            source += "<select name=\"fetchtype\" class=\"info_content\"><option>str</option><option>xpath</option><option>regex</option></select></div>";
            source += "<div class=\"info_content\"><input type=\"text\" name=\"fetchtemplate\" size=\"20\" maxlength=\"150\"/></div></div>";
            document.getElementById("schedule").innerHTML = document.getElementById("schedule").innerHTML+source;
        }
        function add_storage(){
            <!--当前不支持regex按组划分，后期希望在调度和存储中都加入regex的分组取值功能-->
            storage_count += 1;
            var source = "<div class=\"module_div\">";
            source += "<label class=\"info_content\">"+storage_count+"</label>";
            source += "<input name=\"storageId\" type=\"hidden\" value=\""+schedule_count+"\">";
            source += "<div class=\"info_content\">";
            source += "<select name=\"storagemode\"><option>int</option><option>str</option><option>double</option></select></div>";
            source += "<div class=\"info_content\"><input name=\"storagesource\" type=\"text\" size=\"20\" maxlength=\"150\"/></div>";
            source += "<div class=\"info_content\">";
            source += "<select name=\"storagetype\" class=\"info_content\"><option>str</option><option>xpath</option><option>regex</option></select></div>";
            source += "<div class=\"info_content\"><input name=\"storagetemplate\" type=\"text\" size=\"20\" maxlength=\"150\"/></div></div>";
            document.getElementById("storage").innerHTML = document.getElementById("storage").innerHTML+source;
        }
    </script>
</head>
<body onLoad="add_schedule();add_storage()">
<section id="main" class="column" style="overflow: auto;overflow-x: hidden;max-height: 560px;">
    <form id = "form" name="addForm" method="post" action="addSchedular.do" class="module width_full">
        <header>
            <h3>调度配置</h3>
        </header>
        <div class="module_content">
            <fieldset>
                <label>调度名称</label>
                <input type="text" name="name">
            </fieldset>
            <fieldset>
                <div class="module_div">
                    <label>调度周期</label>
                </div>
                <div class="module_div">
                    <input type="text" name="day" style="width:10%" value="0"/>
                    <label style="width:40px">天</label>
                    <input type="text" name="hour" style="width:10%" value="0"/>
                    <label style="width:40px">小时</label>
                </div>
            </fieldset>
            <fieldset id="schedule" style="width:100%; float:left; margin-right: 3%;"> <!-- to make two field float next to one another, adjust values accordingly -->
                <div class="module_div">
                    <label style="width:80px">抓取流程</label>
                    <input type="button" value="新增" onClick="add_schedule()">
                </div>
                <div class="module_div">
                    <label class="info_content">id</label>
                    <label class="info_content">方式</label>
                    <label class="info_content">输入源序号</label>
                    <label class="info_content">解析方式</label>
                    <label class="info_content">解析路径</label>
                </div>
            </fieldset>
            <fieldset id="storage" style="width:100%; float:left; margin-right: 3%;"> <!-- to make two field float next to one another, adjust values accordingly -->
                <div class="module_div">
                    <label style="width:80px">存储流程</label>
                    <input type="button" value="新增" onClick="add_storage()">
                </div>
                <div class="module_div">
                    <label class="info_content">id</label>
                    <label class="info_content">字段类型</label>
                    <label class="info_content">输入源序号</label>
                    <label class="info_content">解析方式</label>
                    <label class="info_content">解析路径</label>
                </div>
            </fieldset>
            <div class="clear"></div>
        </div>
        <footer>
            <div class="submit_link">
                <input type="submit" value="提交" class="alt_btn">
                <input type="reset" value="重置">
            </div>
        </footer>
    </form><!-- end of post new form -->
</section>
</body>