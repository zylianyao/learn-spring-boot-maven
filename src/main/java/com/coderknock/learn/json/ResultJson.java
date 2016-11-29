package com.coderknock.learn.json;


import java.util.ArrayList;
import java.util.List;

/**
 * 拿客
 * 网站：www.coderknock.com
 * QQ群：213732117
 * 三产 创建于 2016年10月31日 14:12:49。
 * 描述：
 */
public class ResultJson<T> {

    //是否成功
    private boolean result;
    private T data;
    private List<String> messages;

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public List<String> getMessages() {
        return messages;
    }

    public void setMessages(List<String> messages) {
        this.messages = messages;
    }

    public void addMessages(String message) {
        if (this.messages == null) {
            this.messages = new ArrayList<String>();
        }
        this.messages.add(message);
    }

}

