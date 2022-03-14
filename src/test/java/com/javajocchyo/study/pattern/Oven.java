package com.javajocchyo.study.pattern;


import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Oven {

  private  final OvenMagnetron magnetron;
  private  final OvenSlideTable slideTable;
  private  final OvenTimer timer;

    public Oven() {
        magnetron = new OvenMagnetron();
        slideTable = new OvenSlideTable();
        timer = new OvenTimer();
    }

    public void on(int timerCnt){
        magnetron.on();
        slideTable.on();
        timer.on(timerCnt);
    }

    public void off(){

        magnetron.off();
        slideTable.off();
        timer.off();
    }
}
