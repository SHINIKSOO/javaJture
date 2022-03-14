package com.javajocchyo.study.pattern;

import lombok.SneakyThrows;

public class OvenUser  {




    public static void main(String[] agrs) throws InterruptedException {

        //OvenMagnetron magnetron = new OvenMagnetron();
        //OvenTurnTable turnTable = new OvenTurnTable();
        //OvenSlideTable slideTable = new OvenSlideTable();
        //OvenTimer timer = new OvenTimer();

       //전자렌지동작시작
        //magnetron.on();
        //slideTable.on();
        //timer.on(5);

        Oven oven = new Oven();
        oven.on(5000);
       // Thread.sleep(3000);
        //oven.off();
        //중간취소
        //magnetron.off();
        //slideTable.off();
        //imer.off();
    }
}
