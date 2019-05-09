package cn.zimo.wbq.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author zi.mo
 * @description
 * @createTime 2019/5/5,2:17 PM
 * @updateAuthor
 * @updateTime
 * @updateDesc
 */
public interface LogInterface {
    default Logger logger(){
        return LoggerFactory.getLogger(getClass());
    }

    default boolean isOpenDebug(){
        return LogConstants.isOpenDebug();
    }

    default boolean isOpenWarn(){
        return LogConstants.isOpenWarn();
    }

    default boolean isOpenInfo(){
        return LogConstants.isOpenInfo();
    }
}
