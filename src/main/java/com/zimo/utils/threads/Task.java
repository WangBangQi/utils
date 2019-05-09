package com.zimo.utils.threads;

import cn.zimo.wbq.service.LogInterface;

/**
 * @author zi.mo
 * @description
 * @createTime 2019/5/5,2:13 PM
 * @updateAuthor
 * @updateTime
 * @updateDesc
 */
public class Task implements Runnable,LogInterface{
    @Override
    public void run() {
        logger().error("please implements run method");
    }
}
