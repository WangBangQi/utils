package cn.zimo.wbq.http;

import cn.zimo.wbq.exceptions.SystemException;
import org.springframework.util.StringUtils;

/**
 * Created by wangqiyun on 2017/6/3.
 */
public class NameValuePairImp implements org.apache.http.NameValuePair {
    private String name;
    private String value;

    public NameValuePairImp(String name, String value) {
        this.name = name;
        this.value = value;
        if (StringUtils.isEmpty(name) || value == null)
            throw SystemException.SYSTEM_ERR;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getValue() {
        return value;
    }
}
