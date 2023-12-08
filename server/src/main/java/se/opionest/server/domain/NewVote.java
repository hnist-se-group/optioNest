package se.opionest.server.domain;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class NewVote {
    private Integer uid;
    private String title;
    private String content;
    private String stime;
    private String etime;
    private ArrayList<Options> options;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
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

    public void setOptions(ArrayList<Options> options) {
        this.options = options;
    }

    @Override
    public String toString() {
        return "NewVote{" +
                "uid=" + uid +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", stime='" + stime + '\'' +
                ", etime='" + etime + '\'' +
                ", options=" + options +
                '}';
    }
}
