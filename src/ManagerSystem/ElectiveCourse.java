package ManagerSystem;

import java.io.Serializable;

public class ElectiveCourse implements Serializable {
    private String elid;
    private String sid;
    private String classid;

    public ElectiveCourse(String elid, String sid, String classid) {
        this.elid = elid;
        this.sid = sid;
        this.classid = classid;
    }

    public String getElid() {
        return elid;
    }

    public void setElid(String elid) {
        this.elid = elid;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getClassid() {
        return classid;
    }

    public void setClassid(String classid) {
        this.classid = classid;
    }

    @Override
    public String toString() {
        return "ElectiveCourse{" +
                "elid='" + elid + '\'' +
                ", sid='" + sid + '\'' +
                ", classid='" + classid + '\'' +
                '}';
    }

    public void display(){
        System.out.println(toString());
    }
}
