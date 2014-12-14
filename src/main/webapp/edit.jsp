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
        var schedule_count = 1;
        var storage_count = 1;
        function add_schedule(){
            schedule_count += 1;
            var source = "<div class=\"module_div\">";
            source += "<label class=\"info_content\">"+schedule_count+"</label>";
            source += "<input name=\"id\" type=\"hidden\" value=\""+schedule_count+"\">";
            source += "<div class=\"info_content\">";
            source += "<select name=\"mode\"><option>抓取</option><option>取值</option></select></div>";
            source += "<div class=\"info_content\"><input name=\"source\" type=\"text\" size=\"20\" maxlength=\"150\"/></div>";
            source += "<div class=\"info_content\">";
            source += "<select name=\"type\" class=\"info_content\"><option>str</option><option>xpath</option><option>regex</option></select></div>";
            source += "<div class=\"info_content\"><input type=\"text\" name=\"template\" size=\"20\" maxlength=\"150\"/></div></div>";
            document.getElementById("schedule").innerHTML = document.getElementById("schedule").innerHTML+source;
        }
        function add_storage(){
            storage_count += 1;
            var source = "<div class=\"module_div\">";
            source += "<label class=\"info_content\">"+storage_count+"</label>";
            source += "<div class=\"info_content\">";
            source += "<select><option>抓取</option><option>取值</option></select></div>";
            source += "<div class=\"info_content\"><input type=\"text\" size=\"20\" maxlength=\"150\"/></div>";
            source += "<div class=\"info_content\">";
            source += "<select  class=\"info_content\"><option>str</option><option>xpath</option><option>regex</option></select></div>";
            source += "<div class=\"info_content\"><input type=\"text\" size=\"20\" maxlength=\"150\"/></div></div>";
            document.getElementById("storage").innerHTML = document.getElementById("storage").innerHTML+source;
        }
    </script>
</head>
<body>
<section id="main" class="column">
    <form id = "form" name="addForm" method="post" action="addSchedular.do" class="module width_full"><!--???????onsubmit???-->
        <header>
            <h3>调度配置</h3>
        </header>
        <div class="module_content">
            <fieldset>
                <label>调度名称</label>
                <input type="text" name="name">
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
                <div class="module_div">
                    <label class="info_content">1</label>
                    <input name="id" type="hidden" value="1">
                    <div class="info_content">
                        <select name="mode">
                            <option>抓取</option>
                            <option>取值</option>
                        </select>
                    </div>
                    <!--输入源序号-->
                    <div class="info_content">
                        <input type="text" name="source" size="20" maxlength="150"/>
                    </div>
                    <div class="info_content">
                        <select  name="type" class="info_content"><!--解析方式-->
                            <option>str</option>
                            <option>xpath</option>
                            <option>regex</option>
                        </select>
                    </div>
                    <!--解析路径-->
                    <div class="info_content">
                        <input type="text" name="template" size="20" maxlength="150"/>
                    </div>
                </div>
            </fieldset>
            <fieldset id="storage" style="width:100%; float:left; margin-right: 3%;"> <!-- to make two field float next to one another, adjust values accordingly -->
                <div class="module_div">
                    <label style="width:80px">存储流程</label>
                    <input type="button" value="新增" onClick="add_storage()">
                </div>
                <div class="module_div">
                    <label class="info_content">id</label>
                    <label class="info_content">方式</label>
                    <label class="info_content">输入源序号</label>
                    <label class="info_content">解析方式</label>
                    <label class="info_content">解析路径</label>
                </div>
                <div class="module_div">
                    <label class="info_content">1</label>
                    <div class="info_content">
                        <select>
                            <option>抓取</option>
                            <option>取值</option>
                        </select>
                    </div>
                    <!--输入源序号-->
                    <div class="info_content">
                        <input type="text" size="20" maxlength="150"/>
                    </div>
                    <div class="info_content">
                        <select  class="info_content"><!--解析方式-->
                            <option>str</option>
                            <option>xpath</option>
                            <option>regex</option>
                        </select>
                    </div>
                    <!--解析路径-->
                    <div class="info_content">
                        <input type="text" size="20" maxlength="150"/>
                    </div>
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