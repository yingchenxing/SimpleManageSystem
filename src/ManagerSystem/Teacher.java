package ManagerSystem;

import java.io.Serializable;

public class Teacher extends Person implements Serializable {
    protected String tid;
    protected String tittle;

    public Teacher(String tid, String name, String gender, int age, String tittle) {
        super(name, gender, age);
        this.tid = tid;
        this.tittle = tittle;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", tid='" + tid + '\'' +
                ", tittle='" + tittle + '\'' +
                '}';
    }

    @Override
    public void display() {
        System.out.println(toString());
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }
}
