package com.zimo.utils.threads;

/**
 * @author zi.mo
 * @description 阻塞队列，有三个原则
 *          1.先进先出
 *          2.写入队列空间不可用时，线程进行等待
 *          3.获取队列数据时当队列为空时将阻塞
 * @createTime 2019/5/5,5:46 PM
 * @updateAuthor
 * @updateTime
 * @updateDesc
 */
public class ArrayQueue <T> {

    private Object[] items = null;

    /**
     * 写入的数据的个数
     */
    private int count = 0;

    /**
     * 当前添加的数组的下标
     */
    private int putIndex=0;

    /**
     * 当前获取的数组的下标
     */
    private int getIndex = 0;

    /**
     * 初始化阻塞队列
     * @param size the size of items's length
     */
    public ArrayQueue(int size) {
        items = new Object[size];
    }


    /**
     * 队列满时的阻塞锁
     */
    private Object full = new Object();

    /**
     * 队列为空时的阻塞锁
     */
    private Object empty = new Object();

    /**
     * 写入数据
     * @param t
     */
    public void put(T t){

        synchronized (full){
            while (count == items.length){
                try {
                    full.wait();
                }catch (InterruptedException e){
                    break;
                }
            }
        }

        synchronized (empty) {
            //写入
            items[putIndex] = t;
            count++;

            putIndex++;
            if (putIndex == items.length) {
                //超出数组长度，需要重头开始
                putIndex = 0;
            }
            empty.notify();
        }
    }

    /**
     * 获取数据
     * @return
     */
    public T get() {

        synchronized (empty) {
            while (count == 0) {
                try {
                    empty.wait();
                } catch (InterruptedException e) {
                    return null;
                }
            }
        }

        synchronized (full) {
            Object result = items[getIndex];
            items[getIndex] = null;
            count--;

            getIndex++;
            if (getIndex == items.length) {
                getIndex = 0;
            }

            full.notify();
            return (T) result;
        }
    }

    public int size(){
        return count;
    }

}
