package Development_Student_System;
import java.util.Scanner;
import System_Student.Student;

public class Update_Student {

    private final Creat_Student creat_student = new Creat_Student();

    protected Update_Student(){}

    public void update_student_context(int number, Development development,
                                       Scanner scanner, Student[] student)
    {
        development.clear();
        System.out.println("1. 学生学号修改");
        System.out.println("2. 学生姓名修改");
        System.out.println("3. 学生年龄修改");
        System.out.println("4. 学生年级修改");
        System.out.println("5. 学生班级修改");
        System.out.println("6. 学生座位号修改");
        System.out.print("请选择：");
        if (scanner.hasNextInt()){
            int student_select = scanner.nextInt();
            if (!(student_select <= 0) && !(student_select >= 7)){
                System.out.print("是否修改？1.y 2.n (一旦选择修改就必须修改, 无法回头)：");
                String yes_no = scanner.next();
                if ("y".equalsIgnoreCase(yes_no)) {
                    System.out.println("正在为您跳转....");
                    development.time();
                    development.clear();
                    switch (student_select) {
                        case 1:
                            System.out.println("当前学生学号：" + student[number].getID());
                            this.creat_student.set_student_ID_name_age_grade_class_seat(
                                    scanner, student, number
                            );
                            break;
                        case 2:
                            System.out.println("当前学生姓名：" + student[number].getName());
                            this.creat_student.set_student_id_NAME_age_grade_class_seat(
                                    scanner, number, student
                            );
                            break;
                        case 3:
                            System.out.println("当前学生的年龄：" + student[number].getAge());
                            this.creat_student.set_student_id_name_AGE_grade_class_seat(
                                    number, scanner, student
                            );
                            break;
                        case 4:
                            System.out.println("当前学生的年级：" + student[number].getGrade());
                            this.creat_student.set_student_id_name_age_GRADE_class_seat(
                                    number, student, scanner
                            );
                            break;
                        case 5:
                            System.out.println("当前学生的班级：" + student[number].getClass_grade());
                            this.creat_student.set_student_id_name_age_grade_CLASS_seat(
                                    student, number, scanner
                            );
                            break;
                        case 6:
                            System.out.println("当前学生的座位号：" + student[number].getSeat());
                            this.creat_student.set_student_id_name_age_grade_class_SEAT(
                                    student, scanner, number
                            );
                            break;
                    }
                    System.out.println("修改成功！(两秒自动返回).....");
                }else {
                    System.out.println("正在返回....");
                }
            }else {
                System.err.println("请重新进入....");
            }
        }else {
            String next = scanner.next();
            System.err.println(next + " 不是数字，请重新进入...");
        }
    }

    // 修改学生信息的内部小程序
    public void update_student_applet(int index, Scanner scanner,
                                      Development development, Student[] student)
    {
        while (true) {
            System.out.print("请输入要修改的序号(若不修改输入exit退出信息修改模式)：");
            if (scanner.hasNextInt()) {
                int number = scanner.nextInt();
                if (number == 0)continue;
                if (number <= index){
                    number -= 1; // 数组的索引值
                    this.update_student_context(number, development, scanner, student);
                }else {
                    System.err.println("当前录取学生信息人数为：" + index +
                            "而您输入的已经超过了范围，请重新输入");
                    Development.enter_exit();
                    return;
                }
            } else {
                String next = scanner.next();
                if ("exit".equalsIgnoreCase(next)){
                    System.out.println("正在退出....");
                    development.time();
                    development.clear();
                    break;
                }
                System.err.println(next + " 不是合法的序号");
            }
            development.time();
            development.clear();
        }
    }
}
