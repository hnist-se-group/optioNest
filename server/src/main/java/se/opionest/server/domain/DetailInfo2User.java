package se.opionest.server.domain;

import java.util.ArrayList;

public class DetailInfo2User {
    private String name;
    private String location;
    private String brief;
    private String gender;
    private String img;
    private String email;
    private Integer uid;
    private ArrayList<VotesInfo> votes;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public ArrayList<VotesInfo> getVotes() {
        return votes;
    }

    public void setVotes(ArrayList<VotesInfo> votes) {
        this.votes = votes;
    }

    @Override
    public String toString() {
        return "DetailInfo2User{" +
                "name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", brief='" + brief + '\'' +
                ", gender='" + gender + '\'' +
                ", img='" + img + '\'' +
                ", email='" + email + '\'' +
                ", uid=" + uid +
                ", votes=" + votes +
                '}';
    }
}
