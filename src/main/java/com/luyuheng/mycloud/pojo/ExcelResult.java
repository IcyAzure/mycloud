package com.luyuheng.mycloud.pojo;

/**
 * Excel 导出结果
 * @Author:luyuheng
 * @Date:2018/4/26 11 16
 * @Description
 */
public class ExcelResult<T> {

    private String message;

    private T Data;

    public ExcelResult(String message,T Data){this.Data = Data;this.message = message;}

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return Data;
    }

    public void setData(T data) {
        Data = data;
    }
}
