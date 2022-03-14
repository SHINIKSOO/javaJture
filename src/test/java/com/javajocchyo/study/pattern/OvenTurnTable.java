package com.javajocchyo.study.pattern;


import lombok.extern.slf4j.Slf4j;

@Slf4j
public class OvenTurnTable {


    public void on() {
        log.info("턴테이블 ON");
    }

    public void off(){
        log.info("턴테이블 OFF");
    }
}
