package com.spiderserver.dao;

import com.spiderserver.po.SchemaInfo;

import java.util.List;

/**
 * Created by apoptoxin on 2014/12/5.
 */
public interface SchemaInfoMapper {
    public List<SchemaInfo> getAllSchema();
    public void addSchema(SchemaInfo schemaInfo);
    public void deleteSchema(int id);
    public void updateSchema(SchemaInfo schemaInfo);
}
