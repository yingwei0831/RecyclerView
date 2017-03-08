package com.yw.testrecyclerview.retrofitutils.model;

/**
 * Created by jiahe008_lvlanlan on 2017/2/24.
 */
public class BaseResponse<Q> {

    private HeadBean head;

    private Q body;


    public Q getBody() {
        return body;
    }

    public void setBody(Q body) {
        this.body = body;
    }

    public HeadBean getHead() {
        return head;
    }

    public void setHead(HeadBean head) {
        this.head = head;
    }

    public static class HeadBean {
        /**
         * res_code : 0000
         * res_msg : success
         * res_arg : 获取成功
         */

        private String res_code;
        private String res_msg;
        private String res_arg;

        public String getRes_code() {
            return res_code;
        }

        public void setRes_code(String res_code) {
            this.res_code = res_code;
        }

        public String getRes_msg() {
            return res_msg;
        }

        public void setRes_msg(String res_msg) {
            this.res_msg = res_msg;
        }

        public String getRes_arg() {
            return res_arg;
        }

        public void setRes_arg(String res_arg) {
            this.res_arg = res_arg;
        }

        @Override
        public String toString() {
            return "HeadBean{" +
                    "res_code='" + res_code + '\'' +
                    ", res_msg='" + res_msg + '\'' +
                    ", res_arg='" + res_arg + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "BaseResponse{" +
                "head=" + head +
                ", body=" + body +
                '}';
    }
}
