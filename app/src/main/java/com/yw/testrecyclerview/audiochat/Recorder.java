package com.yw.testrecyclerview.audiochat;

/**
 * Created by jiahe008_lvlanlan on 2017/5/25.
 */
public class Recorder {
    String filePath;
    float time;

    public Recorder(float time, String filePath) {
        this.filePath = filePath;
        this.time = time;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public float getTime() {
        return time;
    }

    public void setTime(float time) {
        this.time = time;
    }
}
