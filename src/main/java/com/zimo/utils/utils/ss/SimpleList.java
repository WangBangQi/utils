package com.zimo.utils.utils.ss;

/**
 * @author zi.mo
 * @description
 * @createTime 2019/7/23,10:02 PM
 * @updateAuthor
 * @updateTime
 * @updateDesc
 */
public class SimpleList <T> {
    private Object[] elementData;

    private int size = 0;

    public SimpleList() {
        elementData = new Object[]{};
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){

        return false;
    }

    public boolean add(T e){
        return false;
    }

    public boolean remove(Object o){
        return false;
    }

    public T get(int index){
        return null;
    }
}
