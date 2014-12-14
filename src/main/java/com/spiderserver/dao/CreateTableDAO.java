package com.spiderserver.dao;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by apoptoxin on 2014/12/4.
 */
public class CreateTableDAO {
    public static int executeCreateSql(String sql) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("sql", sql);
//        return this.update("XX.createTableSql",map);
        return 0;
    }
    /*
    mapper中这样写:
<update id="createTableSql" parameterType="map">
${sql}
</update>
     */
}
