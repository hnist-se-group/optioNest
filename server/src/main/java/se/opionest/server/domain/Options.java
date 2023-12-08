package se.opionest.server.domain;

public class Options {
    private String name;
    private Integer num;
    int oid;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }

    @Override
    public String toString() {
        return "Options{" +
                "name='" + name + '\'' +
                ", num=" + num +
                '}';
    }
}
