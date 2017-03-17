package com.yzx.yzxpractice.module.Retrofit_RxJava.model;

/**
 * Description：
 * Created by yzx on 2017/3/17.
 */

public class TestEvent {
    private String title;
    private String content;

    public TestEvent(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
