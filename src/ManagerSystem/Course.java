package ManagerSystem;

import java.io.Serializable;

public class Course implements Serializable {
    private String cname;
    private String cid;
    private int chour;

    public Course(String cid, String cname, int chour) {
        this.cname = cname;
        this.cid = cid;
        this.chour = chour;
    }


    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public int getChour() {
        return chour;
    }

    public void setChour(int chour) {
        this.chour = chour;
    }

    @Override
    public String toString() {
        return "Course{" +
                "cname='" + cname + '\'' +
                ", cid='" + cid + '\'' +
                ", chour=" + chour +
                '}';
    }

    public void display() {
        System.out.println(toString());
    }
}
