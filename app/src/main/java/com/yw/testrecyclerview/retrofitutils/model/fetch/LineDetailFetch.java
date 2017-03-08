package com.yw.testrecyclerview.retrofitutils.model.fetch;

import com.yw.testrecyclerview.retrofitutils.model.BaseFetch;

/**
 * Created by jiahe008_lvlanlan on 2017/2/24.
 */
public class LineDetailFetch {
    /**
     * head : {"code":"Publics_show"}
     * field : {"id":"589","memberid":"73"}
     */

    /**
     * id : 589
     * memberid : 73
     */

    private String id;
    private String memberid;

    public LineDetailFetch(String id, String memberid) {
        this.id = id;
        this.memberid = memberid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMemberid() {
        return memberid;
    }

    public void setMemberid(String memberid) {
        this.memberid = memberid;
    }

//    {"head":{"code":"Publics_show"},"field":{"id":"589","memberid":"73"}}

    @Override
    public String toString() {
        return "LineDetailFetch{" +
                "id='" + id + '\'' +
                ", memberid='" + memberid + '\'' +
                '}';
    }
}
