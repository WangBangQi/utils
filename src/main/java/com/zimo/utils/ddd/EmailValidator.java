package com.zimo.utils.ddd;

/**
 * @author zi.mo
 * @description
 * @createTime 2019/9/4,4:08 PM
 */
public class EmailValidator extends Validator{

    Email email;

    public EmailValidator(Email email,ValidatorNotificationHandle handle) {
        super(handle);
        this.setEmail(email);
    }

    @Override
    protected void validator() {
        if (this.hasEmailIsNull()){
            this.getHandle().handleError("email is null");
        }
    }



    private boolean hasEmailIsNull(){
        if (this.getEmail() == null) return true;
        return false;
    }

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }
}
