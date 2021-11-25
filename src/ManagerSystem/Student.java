package ManagerSystem;

import java.io.Serializable;

public class Student extends Person implements Serializable {
    protected String sid;
    protected String major;

    public Student(String sid, String name, String gender, int age, String major) {
        super(name, gender, age);
        this.sid = sid;
        this.major = major;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", sid='" + sid + '\'' +
                ", major='" + major + '\'' +
                '}';
    }

    @Override
    public void display() {
        System.out.println(toString());
    }
}
