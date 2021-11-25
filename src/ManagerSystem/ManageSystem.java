package ManagerSystem;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class ManageSystem {
    private Object[] teachers;
    private Object[] students;
    private Object[] courses;
    private Object[] electiveCourses;
    private Object[] schedules;

    public ManageSystem() {
        teachers = new Object[100];
        students = new Object[100];
        courses = new Object[100];
        electiveCourses = new Object[100];
        schedules = new Object[100];
        MyDatabase.readData(teachers, MyDatabase.TEACHER);
        MyDatabase.readData(students, MyDatabase.STUDENT);
        MyDatabase.readData(courses, MyDatabase.COURSE);
        MyDatabase.readData(electiveCourses, MyDatabase.ELECTIVECOURSE);
        MyDatabase.readData(schedules, MyDatabase.SCHEDULE);

    }

    //显示所有学生信息
    public void showAllStu() {
        for (int i = 0; i < students.length; i++) {
            if (students[i] != null)
                ((Student) students[i]).display();
            else
                break;
        }
    }

    //显示所有选课信息
    public void showAllElc() {
        for (int i = 0; i < electiveCourses.length; i++) {
            if (electiveCourses[i] != null)
                ((ElectiveCourse) electiveCourses[i]).display();
            else
                break;
        }
    }

    //显示所有老师信息
    public void showAllTeacher() {
        for (int i = 0; i < teachers.length; i++) {
            if (teachers[i] != null)
                ((Teacher) teachers[i]).display();
            else
                break;
        }
    }

    //显示所有Schedule
    public void showAllSchedule() {
        for (int i = 0; i < schedules.length; i++) {
            if (schedules[i] != null)
                ((Schedule) schedules[i]).display();
            else
                break;
        }
    }

    //显示所有课程信息
    public void showAllCourse() {
        for (int i = 0; i < courses.length; i++) {
            if (courses[i] != null)
                ((Course) courses[i]).display();
            else
                break;
        }
    }

    //显示菜单
    public void showMenu() throws IOException {
        while (true) {
            System.out.println("----------MENU----------");
            System.out.println("0.退出系统");
            System.out.println("1.显示信息");
            System.out.println("2.添加信息");
            System.out.println("3.查找排课信息");
            System.out.println("------------------------");
            System.out.println("");
            System.out.println("请输入您的选择：");
            Scanner scanner = new Scanner(System.in);
            int select = scanner.nextInt();
            if (select < 0 || select > 3) {
                System.out.println("您的输入有误，请重新输入:");
            } else if (select == 0) {
                return;
            } else if (select == 1) {
                System.out.println("1. 显示所有学生信息");
                System.out.println("2. 显示所有老师信息");
                System.out.println("3. 显示所有选课信息");
                System.out.println("4. 显示所有课程信息");
                System.out.println("5. 显示所有排课信息");
                System.out.println("6. 显示所有信息");
                System.out.println("其他. 返回上一级");
                select = scanner.nextInt();
                showInfo(select);
            } else if (select == 2) {
                System.out.println("1. 添加学生信息");
                System.out.println("2. 添加老师信息");
                System.out.println("3. 添加选课信息");
                System.out.println("4. 添加课程信息");
                System.out.println("5. 添加排课信息");
                System.out.println("其他. 返回上一级");
                select = scanner.nextInt();
                addInfo(select);
            } else if (select == 3) {
                System.out.println("请输入学生学号:");
                String sid = scanner.next();
                searchInfo(sid);
            } else {
                System.out.println("输入错误，请重新输入：");
            }
        }
    }

    //查找选课内容
    private void searchInfo(String sid) {
        String classId = null;
        String classroom = null;
        String courseName = null;
        //查找选课信息
        for (int i = 0; i < electiveCourses.length && electiveCourses[i] != null; i++) {
            ElectiveCourse ec = (ElectiveCourse) electiveCourses[i];

            if (ec.getSid().equals(sid)) {
                classId = ec.getClassid();


                //查找排课
                for (int j = 0; j < schedules.length && schedules[j] != null; j++) {
                    Schedule schedule = (Schedule) schedules[j];
                    if (schedule.getClassid().equals(classId)) {
                        classroom = schedule.getClassroom();//上课地点
                        String cId = schedule.getCid();//课程编号
                        String tId = schedule.getTid();//教师编号

                        courseName = null;

                        //查找课程名称
                        for (int k = 0; k < courses.length && courses[k] != null; k++) {
                            Course course = (Course) courses[k];
                            if (course.getCid().equals(cId)) {
                                courseName = course.getCname();
                                break;
                            }
                        }
                        String teacherName = null;
                        //查找老师名称
                        for (int k = 0; k < teachers.length && teachers[k] != null; k++) {
                            Teacher teacher = (Teacher) teachers[k];
                            if (teacher.getTid().equals(tId)) {
                                teacherName = teacher.getName();
                                break;
                            }
                        }

                        if (teacherName == null) {
                            System.out.println("查找失败，缺少老师信息！");
                        } else if (courseName == null) {
//                            System.out.println("查找失败，缺少课程信息！");
                        } else {
                            System.out.println("已选课程：" + courseName + ";老师：" + teacherName + ";上课地点：" + classroom);
                        }
                    }
                }
            }

        }
        if (classId == null) {
            System.out.println("查找不到选课记录！");
        }
    }

    //添加信息
    private void addInfo(int select) throws IOException {
        switch (select) {
            case 1:
                addStu();
                return;
            case 2:
                addTeacher();
                return;
            case 3:
                addElc();
                return;
            case 4:
                addCourse();
                return;
            case 5:
                addSchedule();
                return;
            default:
                return;
        }
    }

    private void addSchedule() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入classId：");
        String classid = scanner.next();

        System.out.println("请输入cid：");
        String cid = scanner.next();

        System.out.println("请输入tid：");
        String tid = scanner.next();

        System.out.println("请输入classroom：");
        String classroom = scanner.next();

        System.out.println("请输入cHour：");
        int cHour = scanner.nextInt();

        Schedule schedule = new Schedule(classid, cid, tid, classroom);

        for (int i = 0; i < schedules.length; i++) {
            if (schedules[i] == null) {
                schedules[i] = schedule;
                break;
            }
        }
        MyDatabase.writeData(schedules);
    }

    private void addCourse() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入cid：");
        String cid = scanner.next();

        System.out.println("请输入cname：");
        String cname = scanner.next();

        System.out.println("请输入cHour：");
        int chour = scanner.nextInt();

        Course course = new Course(cid, cname, chour);
        for (int i = 0; i < courses.length; i++) {
            if (courses[i] == null) {
                courses[i] = course;
                break;
            }
        }
        MyDatabase.writeData(courses);
    }

    private void addElc() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入elid：");
        String elid = scanner.next();

        System.out.println("请输入sid：");
        String sid = scanner.next();

        System.out.println("请输入classid：");
        String classid = scanner.next();


        ElectiveCourse electiveCourse = new ElectiveCourse(elid, sid, classid);
        for (int i = 0; i < electiveCourses.length; i++) {
            if (electiveCourses[i] == null) {
                electiveCourses[i] = electiveCourse;
                break;
            }
        }
        MyDatabase.writeData(electiveCourses);
    }

    private void addStu() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入sid：");
        String sid = scanner.next();

        System.out.println("请输入名称：");
        String name = scanner.next();

        System.out.println("请输入性别：");
        String gender = scanner.next();

        System.out.println("请输入年龄：");
        int age = scanner.nextInt();

        System.out.println("请输入专业：");
        String major = scanner.next();

        Student student = new Student(sid, name, gender, age, major);
        for (int i = 0; i < students.length; i++) {
            if (students[i] == null) {
                students[i] = student;
                break;
            }
        }
        MyDatabase.writeData(students);
    }

    private void addTeacher() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入tid：");
        String tid = scanner.next();

        System.out.println("请输入名称：");
        String name = scanner.next();

        System.out.println("请输入性别：");
        String gender = scanner.next();

        System.out.println("请输入年龄：");
        int age = scanner.nextInt();

        System.out.println("请输入职称：");
        String tittle = scanner.next();

        Teacher teacher = new Teacher(tid, name, gender, age, tittle);
        for (int i = 0; i < students.length; i++) {
            if (teachers[i] == null) {
                teachers[i] = teacher;
                break;
            }
        }
        MyDatabase.writeData(teachers);
    }

    private void showInfo(int select) {
        switch (select) {
            case 1:
                System.out.println("学生信息：");
                showAllStu();
                return;
            case 2:
                System.out.println("老师信息：");
                showAllTeacher();
                return;
            case 3:
                System.out.println("选课信息：");
                showAllElc();
                return;
            case 4:
                System.out.println("课程信息：");
                showAllCourse();
                return;
            case 5:
                System.out.println("排课信息：");
                showAllSchedule();
                return;
            case 6:

                System.out.println("--------------系统信息------------------");
                for(int i =1;i<6;i++)
                    showInfo(i);
                System.out.println("---------------------------------------\n\n");
            default:
                return;
        }
    }

    public static void main(String[] args) throws IOException {
        ManageSystem manageSystem = new ManageSystem();
        manageSystem.showMenu();
    }

}
