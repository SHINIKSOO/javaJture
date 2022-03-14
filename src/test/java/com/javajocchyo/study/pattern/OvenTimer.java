package com.javajocchyo.study.pattern;


import lombok.extern.slf4j.Slf4j;

import java.util.Timer;
import java.util.TimerTask;

//강한 응집도(비슷한녀석들끼리 묶어염), 약한 결합도



@Slf4j
public class OvenTimer {

    private Timer timer;


    public void on(int second){
        log.info("타이머 ON");

        log.info("this =>" + this);
        TimerTask timerTask = new OvenTimerTask(this,5);
        timer = new Timer();
        timer.schedule(timerTask,0,1000);
    }

    public  void off(){
        log.info("타이머 OFF");

        timer.cancel();
    }

    @Slf4j
    public static class OvenTimerTask extends TimerTask {

        private OvenTimer ovenTimer;
        private  int second;


        public OvenTimerTask(OvenTimer ovenTimer, int second) {
            this.ovenTimer = ovenTimer;
            this.second=second;
        }

        @Override
        public void run() {
            log.info("타이머 : "+second--);

            if(second==0) {
                ovenTimer.off();
            }
        }
    }
}
