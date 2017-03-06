package com.yw.testrecyclerview.retrofitutils;

import java.util.List;

/**
 * Created by jiahe008_lvlanlan on 2017/3/3.
 */
public class MWeather {


    /**
     * desc : OK
     * status : 1000
     * data : {"wendu":"20","ganmao":"天气较凉，较易发生感冒，请适当增加衣服。体质较弱的朋友尤其应该注意防护。","forecast":[{"fengxiang":"无持续风向","fengli":"微风级","high":"高温 22℃","type":"多云","low":"低温 15℃","date":"3日星期五"},{"fengxiang":"无持续风向","fengli":"微风级","high":"高温 23℃","type":"阴","low":"低温 16℃","date":"4日星期六"},{"fengxiang":"无持续风向","fengli":"微风级","high":"高温 25℃","type":"阴","low":"低温 18℃","date":"5日星期天"},{"fengxiang":"无持续风向","fengli":"微风级","high":"高温 25℃","type":"小雨","low":"低温 17℃","date":"6日星期一"},{"fengxiang":"无持续风向","fengli":"微风级","high":"高温 21℃","type":"小雨","low":"低温 15℃","date":"7日星期二"}],"yesterday":{"fl":"5-6级","fx":"东北风","high":"高温 23℃","type":"多云","low":"低温 15℃","date":"2日星期四"},"aqi":"81","city":"深圳"}
     */

    private String desc;
    private int status;
    private DataBean data;

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * wendu : 20
         * ganmao : 天气较凉，较易发生感冒，请适当增加衣服。体质较弱的朋友尤其应该注意防护。
         * forecast : [{"fengxiang":"无持续风向","fengli":"微风级","high":"高温 22℃","type":"多云","low":"低温 15℃","date":"3日星期五"},{"fengxiang":"无持续风向","fengli":"微风级","high":"高温 23℃","type":"阴","low":"低温 16℃","date":"4日星期六"},{"fengxiang":"无持续风向","fengli":"微风级","high":"高温 25℃","type":"阴","low":"低温 18℃","date":"5日星期天"},{"fengxiang":"无持续风向","fengli":"微风级","high":"高温 25℃","type":"小雨","low":"低温 17℃","date":"6日星期一"},{"fengxiang":"无持续风向","fengli":"微风级","high":"高温 21℃","type":"小雨","low":"低温 15℃","date":"7日星期二"}]
         * yesterday : {"fl":"5-6级","fx":"东北风","high":"高温 23℃","type":"多云","low":"低温 15℃","date":"2日星期四"}
         * aqi : 81
         * city : 深圳
         */

        private String wendu;
        private String ganmao;
        private YesterdayBean yesterday;
        private String aqi;
        private String city;
        private List<ForecastBean> forecast;

        public String getWendu() {
            return wendu;
        }

        public void setWendu(String wendu) {
            this.wendu = wendu;
        }

        public String getGanmao() {
            return ganmao;
        }

        public void setGanmao(String ganmao) {
            this.ganmao = ganmao;
        }

        public YesterdayBean getYesterday() {
            return yesterday;
        }

        public void setYesterday(YesterdayBean yesterday) {
            this.yesterday = yesterday;
        }

        public String getAqi() {
            return aqi;
        }

        public void setAqi(String aqi) {
            this.aqi = aqi;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public List<ForecastBean> getForecast() {
            return forecast;
        }

        public void setForecast(List<ForecastBean> forecast) {
            this.forecast = forecast;
        }

        public static class YesterdayBean {
            /**
             * fl : 5-6级
             * fx : 东北风
             * high : 高温 23℃
             * type : 多云
             * low : 低温 15℃
             * date : 2日星期四
             */

            private String fl;
            private String fx;
            private String high;
            private String type;
            private String low;
            private String date;

            public String getFl() {
                return fl;
            }

            public void setFl(String fl) {
                this.fl = fl;
            }

            public String getFx() {
                return fx;
            }

            public void setFx(String fx) {
                this.fx = fx;
            }

            public String getHigh() {
                return high;
            }

            public void setHigh(String high) {
                this.high = high;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getLow() {
                return low;
            }

            public void setLow(String low) {
                this.low = low;
            }

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }
        }

        public static class ForecastBean {
            /**
             * fengxiang : 无持续风向
             * fengli : 微风级
             * high : 高温 22℃
             * type : 多云
             * low : 低温 15℃
             * date : 3日星期五
             */

            private String fengxiang;
            private String fengli;
            private String high;
            private String type;
            private String low;
            private String date;

            public String getFengxiang() {
                return fengxiang;
            }

            public void setFengxiang(String fengxiang) {
                this.fengxiang = fengxiang;
            }

            public String getFengli() {
                return fengli;
            }

            public void setFengli(String fengli) {
                this.fengli = fengli;
            }

            public String getHigh() {
                return high;
            }

            public void setHigh(String high) {
                this.high = high;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getLow() {
                return low;
            }

            public void setLow(String low) {
                this.low = low;
            }

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }
        }
    }
}
