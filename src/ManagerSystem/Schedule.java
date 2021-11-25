package ManagerSystem;

import java.io.Serializable;

public class Schedule implements Serializable {
    private String classid;
    private String cid;
    private String tid;
    private String classroom;

    public Schedule(String classid, String cid, String tid, String classroom) {
        this.classid = classid;
        this.cid = cid;
        this.tid = tid;
        this.classroom = classroom;
    }

    public String getClassid() {
        return classid;
    }

    public void setClassid(String classid) {
        this.classid = classid;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "classid='" + classid + '\'' +
                ", cid='" + cid + '\'' +
                ", tid='" + tid + '\'' +
                ", classroom='" + classroom + '\'' +
                '}';
    }

    public void display() {
        System.out.println(toString());
    }
}
