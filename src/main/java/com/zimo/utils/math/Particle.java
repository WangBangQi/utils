package com.zimo.utils.math;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.util.ArrayList;

/**
 * @author zi.mo
 * @description
 * @createTime 2019/11/14,10:37 AM
 */
public class Particle {
    static ArrayList<Particle> list=new ArrayList<Particle>();
    final static int SIZE=2;
    final static int MIN=0;
    final static int MAX=600;
    final int SPACE=10;
    boolean live=true;
    public Circle node;
    public Particle(double x ,double y) {
        node=new Circle(x,y,SIZE);
        node.setFill(Color.valueOf("#43CD80"));
        list.add(this);
    }
    public Circle getNode() {
        return node;
    }
    public  void move() {
        if(this.live) {
            double x=0;
            double y=0;
            do{
                x=node.getCenterX()+(Math.random()>0.5?1:-1)*Math.random()*SPACE;
                y=node.getCenterY()+(Math.random()>0.5?1:-1)*Math.random()*SPACE;
            }while(x<MIN||x>MAX||y<MIN||y>MAX) ;
            node.setCenterX(x);
            node.setCenterY(y);
            for(Particle itme:list) {
                if(this!=itme&&isNear(this,itme)&&itme.live==false) {
                    goDie();
                }
            }
        }
    }
    public void  goDie() {
        node.setFill(Color.valueOf("#912CEE"));
        this.live=false;
    }
    public static boolean isNear(Particle u,Particle r) {
        double x = u.node.getCenterX()-r.node.getCenterX();
        double y=  u.node.getCenterY()-r.node.getCenterY();
        return x*x+y*y<64;
        //return x*x+y*y<Math.pow((u.getNode().getRadius()+r.getNode().getRadius()),2);
    }
}
