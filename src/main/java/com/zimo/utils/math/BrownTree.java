package com.zimo.utils.math;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * @author zi.mo
 * @description
 * @createTime 2019/11/14,10:35 AM
 */
public class BrownTree extends Application{
    Pane pane = new Pane();
    public static void main(String args[]){
        launch();
    }

    public BrownTree() {
    }

    public void  addParticle(Pane pane) {
        for(int i=0;i<3000;i++) {
            Particle p=new Particle(Particle.MIN+Math.random()*600,Particle.MIN+Math.random()*600);
            pane.getChildren().add(p.getNode());
        }
        Particle center=new Particle(300,300);
        pane.getChildren().add(center.getNode());
        center.goDie();
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        addParticle(pane);

        ParticleService service=new ParticleService();
        service.setDelay(Duration.seconds(1));
        service.setPeriod(Duration.seconds(0.1));
        service.start();
        pane.setOnMouseClicked(e->{
            service.cancel();
        });
        primaryStage.setScene(new Scene(pane));
        primaryStage.setWidth(600);
        primaryStage.setHeight(600);
        primaryStage.setTitle("布朗树 ");
        primaryStage.show();

    }
}
