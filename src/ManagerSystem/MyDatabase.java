package ManagerSystem;

import java.io.*;

public class MyDatabase {
    public static int COURSE = 0;
    public static int ELECTIVECOURSE = 1;
    public static int SCHEDULE = 2;
    public static int STUDENT = 3;
    public static int TEACHER = 4;

    //区分class类
    public static String switchFile(Object object) {
        if (object instanceof Course)
            return "Course.ser";
        else if (object instanceof ElectiveCourse)
            return "ElectiveCourse.ser";
        else if (object instanceof Schedule)
            return "Schedule.ser";
        else if (object instanceof Teacher)
            return "Teacher.ser";
        else if (object instanceof Student)
            return "Student.ser";
        else
            return null;
    }

    public static String switchFile(int type) {
        if (type == COURSE)
            return "Course.ser";
        else if (type == ELECTIVECOURSE)
            return "ElectiveCourse.ser";
        else if (type == SCHEDULE)
            return "Schedule.ser";
        else if (type == TEACHER)
            return "Teacher.ser";
        else if (type == STUDENT)
            return "Student.ser";
        else
            return null;
    }


    //写数据
    public static void writeData(Object... objects) throws IOException {
        FileOutputStream fileOut =
                new FileOutputStream("C:\\Users\\96392\\Desktop\\Code\\JavaHomework\\SimpleManageSystem\\src\\ManagerSystem\\Info\\" + switchFile(objects[0]));
        ObjectOutputStream out = new ObjectOutputStream(fileOut);
        for (Object object : objects)
            out.writeObject(object);
        out.close();
        fileOut.close();
    }


    //读数据
    public static void readData(Object[] objects, int type) {
        try {
            FileInputStream fIn = new FileInputStream("C:\\Users\\96392\\Desktop\\Code\\JavaHomework\\SimpleManageSystem\\src\\ManagerSystem\\Info\\" + switchFile(type));
            ObjectInputStream in = new ObjectInputStream(fIn);
            for (int i = 0; i < objects.length; i++) {
                try{
                objects[i] = in.readObject();}
                catch (IOException e){
                    break;
                }
            }
            in.close();
            fIn.close();
        } catch (FileNotFoundException e){
            System.out.println("信息为空！");
        } catch (IOException i) {
            i.printStackTrace();
            return;
        } catch (ClassNotFoundException c) {
            System.out.println("class not found");
            c.printStackTrace();
            return;
        }
    }

    public static void readTeacher(String info) {
    }

    public static void readStudent(String info) {
    }

    public static void readSchedule(String info) {
    }

    public static void readElectiveCourse(String info) {
    }
}
