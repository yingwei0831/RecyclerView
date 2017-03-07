package com.yw.testrecyclerview.retrofitutils.model.response;

/**
 * Created by jiahe008_lvlanlan on 2017/3/7.
 */
public class CommitResponse {

    /**
     * response : {"4ff1cbc43ae636b72a00001d":{"thread_id":"1152923703633758877","channel_key":null,"thread_key":"4ff1cbc43ae636b72a00001d","views":41664,"likes":3142,"dislikes":0,"comments":363}}
     * options : {"comments_zero":"暂无","comments_one":"1条评论","comments_multiple":"{num}条评论"}
     * code : 0
     */

    private ResponseBean response;
    private OptionsBean options;
    private int code;

    public static class ResponseBean{
        private ResponseEntity t;

    }

    public static class ResponseEntity{

        /**
         * thread_id : 1152923703633758877
         * channel_key : null
         * thread_key : 4ff1cbc43ae636b72a00001d
         * views : 41664
         * likes : 3142
         * dislikes : 0
         * comments : 363
         */

        private String thread_id;
        private Object channel_key;
        private String thread_key;
        private int views;
        private int likes;
        private int dislikes;
        private int comments;

        public String getThread_id() {
            return thread_id;
        }

        public void setThread_id(String thread_id) {
            this.thread_id = thread_id;
        }

        public Object getChannel_key() {
            return channel_key;
        }

        public void setChannel_key(Object channel_key) {
            this.channel_key = channel_key;
        }

        public String getThread_key() {
            return thread_key;
        }

        public void setThread_key(String thread_key) {
            this.thread_key = thread_key;
        }

        public int getViews() {
            return views;
        }

        public void setViews(int views) {
            this.views = views;
        }

        public int getLikes() {
            return likes;
        }

        public void setLikes(int likes) {
            this.likes = likes;
        }

        public int getDislikes() {
            return dislikes;
        }

        public void setDislikes(int dislikes) {
            this.dislikes = dislikes;
        }

        public int getComments() {
            return comments;
        }

        public void setComments(int comments) {
            this.comments = comments;
        }
    }

    public static class OptionsBean{

        /**
         * comments_zero : 暂无
         * comments_one : 1条评论
         * comments_multiple : {num}条评论
         */

        private String comments_zero;
        private String comments_one;
        private String comments_multiple;

        public String getComments_zero() {
            return comments_zero;
        }

        public void setComments_zero(String comments_zero) {
            this.comments_zero = comments_zero;
        }

        public String getComments_one() {
            return comments_one;
        }

        public void setComments_one(String comments_one) {
            this.comments_one = comments_one;
        }

        public String getComments_multiple() {
            return comments_multiple;
        }

        public void setComments_multiple(String comments_multiple) {
            this.comments_multiple = comments_multiple;
        }
    }
}
