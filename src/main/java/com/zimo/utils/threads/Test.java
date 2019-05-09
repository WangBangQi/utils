package com.zimo.utils.threads;

/**
 * @author zi.mo
 * @description
 * @createTime 2019/5/5,2:13 PM
 * @updateAuthor
 * @updateTime
 * @updateDesc
 */
public class Test extends Task {

    private static final String defaultName = "test";

    private String name;

    public Test() {
        this.name = defaultName;
    }

    public Test(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        logger().info("Base Test's name is {}",name);
    }
}
