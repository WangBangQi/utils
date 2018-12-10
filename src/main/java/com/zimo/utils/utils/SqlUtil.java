package com.zimo.utils.utils;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;

import java.lang.reflect.Field;

public class SqlUtil {

    /**
     * 未完成
     * @param origin
     * @return
     */
    public static String getCreateTableSql(Class origin){
        StringBuilder stringBuilder = new StringBuilder();
        Field[] fields = origin.getFields();
        String tableName = new PropertyNamingStrategy.SnakeCaseStrategy().translate(origin.getName())
                .toUpperCase();
        stringBuilder.append("DROP TABLE IF EXISTS `"+tableName+"`;\n");
        stringBuilder.append("CREATE TABLE `"+tableName+"`(\n");

        stringBuilder.append(")ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8mb4;");
        return  stringBuilder.toString();
    }
}
