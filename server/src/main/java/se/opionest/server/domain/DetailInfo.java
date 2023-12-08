package se.opionest.server.domain;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class DetailInfo {
    private Integer pv;
    private Integer id;
    private String title;
    private String content;
    private String stime;
    private String etime;
    private Integer num;
    private Integer state;
    private ArrayList<Options> options;


    public Integer getPv() {
        return pv;
    }

    public void setPv(Integer pv) {
        this.pv = pv;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getStime() {
        return stime;
    }

    public void setStime(String stime) {
        this.stime = stime;
    }

    public String getEtime() {
        return etime;
    }

    public void setEtime(String etime) {
        this.etime = etime;
    }

    public ArrayList<Options> getOptions() {
        return options;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public void setOptions(ArrayList<Options> options) {
        this.options = options;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "DetailInfo{" +
                "pv=" + pv +
                ", id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", stime='" + stime + '\'' +
                ", etime='" + etime + '\'' +
                ", num=" + num +
                ", state=" + state +
                ", options=" + options +
                '}';
    }
}
