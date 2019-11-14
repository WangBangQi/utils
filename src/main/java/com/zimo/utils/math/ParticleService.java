package com.zimo.utils.math;

import javafx.concurrent.ScheduledService;
import javafx.concurrent.Task;

/**
 * @author zi.mo
 * @description
 * @createTime 2019/11/14,10:38 AM
 */
public class ParticleService extends ScheduledService<Number> {
    protected Task<Number> createTask() {
        Task<Number> task=new Task<Number>(){
            protected void updateValue(Number value) {
                super.updateValue(value);
                Particle.list.forEach(Particle::move);
            }
            protected Number call() throws Exception {
                return null;
            }
        };
        return task;
    }
}
