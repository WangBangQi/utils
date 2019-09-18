package com.zimo.utils.ddd;

/**
 * @author zi.mo
 * @description
 * @createTime 2019/9/4,3:29 PM
 */
public abstract class Validator {

    private ValidatorNotificationHandle handle;


    public Validator(ValidatorNotificationHandle handle) {
        super();
        this.setHandle(handle);
    }

    public void setHandle(ValidatorNotificationHandle handle) {
        this.handle = handle;
    }

    public ValidatorNotificationHandle getHandle() {
        return handle;
    }

    protected abstract void validator();
}
