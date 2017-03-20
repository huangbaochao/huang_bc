package cn.baochao.dto;

import java.io.Serializable;

/**
 * Created by zongguang on 2017/3/14.
 */
public class Result<T> implements Serializable {
    private static final long serialVersionUID = -3973450777861690481L;

    private int code;
    private String msg;
    private T t;

    public Result() {
    }

    public Result(T t) {
        this.code = 200;
        this.t = t;
    }

    public Result(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Result(Integer code, String msg, T t) {
        this.code = code;
        this.msg = msg;
        this.t = t;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }
}
