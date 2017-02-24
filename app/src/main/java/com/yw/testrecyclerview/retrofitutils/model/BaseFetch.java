package com.yw.testrecyclerview.retrofitutils.model;

import com.google.gson.Gson;
import com.google.gson.JsonElement;

/**
 * Created by jiahe008_lvlanlan on 2017/2/24.
 */
public class BaseFetch<T> {

    private HeadBean head;

    public HeadBean getHead() {
        return head;
    }

    public void setHead(HeadBean head) {
        this.head = head;
    }

    public static class HeadBean {
        /**
         * code : Publics_show
         */
        private String code;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }
    }

    public void setHeadCode(String code){
        head.code = code;
    }

    private T field;

    public T getField() {
        return field;
    }

    public void setField(T field) {
        this.field = field;
    }

//    {"head":{"code":"Publics_show"},"field":{"id":"589","memberid":"73"}}

//    protected String code;

//    public String getCode() {
//        return code;
//    }

//    public void setCode(String code) {
//        this.code = code;
//    }
}
