package com.zimo.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author zi.mo
 * @description
 * @createTime 2019/4/28,9:36 AM
 * @updateAuthor
 * @updateTime
 * @updateDesc
 */
public class _Base {
    protected Logger logger = LoggerFactory.getLogger(this.getClass());
    @Resource
    HttpServletResponse response;
    @Resource
    HttpServletRequest request;
}
