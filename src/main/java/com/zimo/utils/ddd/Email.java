package com.zimo.utils.ddd;

/**
 * @author zi.mo
 * @description
 * @createTime 2019/9/4,3:16 PM
 */
public class Email  {


    private String address;


    protected void setAddress(String address){
        if (address == null || address.isEmpty() )
            throw new IllegalArgumentException("email address can not be null !");

        if (address.length() > 200)
            throw new IllegalArgumentException("email address' length can not more than 200 !");

        this.address = address;

    }

    protected String getAddress(){
        return this.address;
    }
}
