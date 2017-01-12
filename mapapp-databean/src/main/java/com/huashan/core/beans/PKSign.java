package com.huashan.core.beans;

/**
 * Created by lixu on 2017-01-02.
 */
public enum PKSign {
    Life(0),WaiGong(1),NeiGong(2),Partner(3),Ave(4);

    private int index;

    private PKSign(int i) {
        this.index = i;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
