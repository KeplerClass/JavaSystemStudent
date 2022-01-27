package Development_Student_System;
import System_Student.Student;
import java.util.Scanner;

public class Development {

    static {
        // 使用JNI技术调用C

        /*
            因小生的文件目录跟大家是不一样的，所以若使用的话，
            请将Java_Project包及包下的所有文件,一起放在一个目录下
            并使用System.getProperty("user.id")，获取当前文件的目录
            并与Java_Project包拼接，例：
            System.load(System.getProperty("user.id") + "\\Java_Project\\" +
                "src\\Development_Student_System\\clear.dll");
            System.load(System.getProperty("user.id") + "\\Java_Project\\" +
                "src\\Development_Student_System\\time.dll");

            如果不行，直接将文件全路径写在System.load()函数中
            System.load("某盘:\\xx\\xx\\...\\Java_Project\\" +
                "src\\Development_Student_System\\clear.dll");
            System.load("某盘:\\xx\\xx\\...\\Java_Project\\" +
                "src\\Development_Student_System\\time.dll");
        */

        System.load(System.getProperty("user.id") + "\\Java_Project\\" +
                "src\\Development_Student_System\\clear.dll");
        System.load(System.getProperty("user.id") + "\\Java_Project\\" +
                "src\\Development_Student_System\\time.dll");
    }

    public final native void clear(); // 调用C程序的清除

    public final native void time(); // 调用C程序的时间

    protected Development(){} // 除了本包中的本类和子类、其他类可以创建，其他不允许

    protected static Student[] student = null;  // 静态数组

    public static final Scanner
            scanner = new Scanner(System.in);  // 静态常量输入流

    private static final Development development = new Development(); // 私有的静态常量对象

    // 使用创建学生类对象
    private final Creat_Student creat_student_at = new Creat_Student();

    // 使用修改学生类对象
    private final Update_Student update_student_at = new Update_Student();

    public boolean number_flag = false;
    
    public boolean creat_flag = false;

    public int index = 0; // 学生当前个数

    boolean delete_index_zero = false; // 当删除学生全部信息后，索引为0时

    boolean delete_function_execution = false;  // 当删除函数执行时

    @SuppressWarnings("all")
    public static final void enter_exit(){
        while (true){
            System.out.println();
            System.out.print("输入0退出：");
            if (scanner.hasNextInt()){
                if (scanner.nextInt() == 0){
                    development.time();
                    development.clear();
                    break;
                }
            }else {
                scanner.next();
            }
        }
    }

    @SuppressWarnings("all")
    private static int print_main(){
        // 打印主菜单
        development.clear();
        System.out.println("-----------Welcome To The Student Management System-----------");
        System.out.println("1. Create Student");
        System.out.println("2. Update Student");
        System.out.println("3. Delete Student");
        System.out.println("4. Select Student");
        System.out.println("5. Number Of Students");
        System.out.println("6. Exit System");
        System.out.print("input：");
        if (scanner.hasNextInt()){
            int number = scanner.nextInt();
            int zero_false_or_true = number != 0 ? number : 0;
            return zero_false_or_true;
        }else {
            String next = scanner.next();
            return -1;
        }
    }

    public static void start(){
        int number = print_main();
        if (number != -1){
            if (!(number < 1) && !(number >= 7)){
                switch (number){
                    case 1:
                        development.creat_flag = development.creat_student();
                        break;
                    case 2:
                        development.update_student();
                        break;
                    case 3:
                        development.delete_student();
                        break;
                    case 4:
                        development.select_student();
                        break;
                    case 5:
                        development.number_flag = development.number_of_students();
                        break;
                    default:
                        System.out.println("感谢您的使用，再见！");
                        development.time();
                        System.out.println("两秒后退出系统");
                        development.time();
                        development.clear();
                        scanner.close();  // 关闭输入流
                        System.exit(0); // 退出系统
                }
            }else {
                System.err.println(String.format("%d 不在(1 - 6)的范围内", number));
                development.time();
                development.clear();
            }
        }else {
            System.err.println("请检查输入的是否不是整数！");
            System.out.println("请重新输入(两秒后刷新)");
            development.time();
            development.clear();
        }
    }

    // 创建学生信息
    public boolean creat_student(){
        development.clear();
        if (development.number_flag){

            // 全部信息被删除后
            if (development.delete_index_zero){
                for (int i = 0; i < development.index; i++)
                    student[i] = new Student();
                System.out.println("因数据为空，正在为您重新创建信息录入表");
                System.out.println("正在创建...");
                development.time();
                System.out.println("创建成功！正在退出....");
                development.time();
                development.clear();
                development.delete_index_zero = false;
                development.delete_function_execution = false;
                return false;
            }
            if (development.delete_function_execution)
                for (int i = 0; i < development.index + 1; ++i)
                    if (student[i] == null)
                        student[i] = new Student();

            while (true) {
                if (development.index < student.length) {
                    this.creat_student_at.creat_student_applet(development.index, scanner,
                            student, development);
                    development.index++;

                    System.out.print("是否继续 (1.是  2.否)：");
                    String next = scanner.next();
                    if ("2".equals(next)){
                        System.out.println("正在退出....");
                        development.time();
                        break;
                    }
                    development.clear();
                } else {
                    development.time();
                    System.out.println("无法录入，原因如下：");
                    System.out.println();
                    System.out.println(String.format("学生总数为：%d", student.length));
                    System.err.println(String.format("当前学生个数为：%d", development.index));
                    System.out.println("已经达到您最开始输入的学生个数，若需要删除个别学生可转到3选项中" +
                            "，若需要重新录取学生个数，可选择5选项中");
                    enter_exit();
                    break;
                }
            }
            return true;
        }else {
            System.err.print("请先输入要录入的学生个数");
            enter_exit();
            return false;
        }
    }

    // 修改学生信息
    public void update_student(){
        development.clear();
        if (development.creat_flag)
        {
            this.update_student_at.update_student_applet
                    (development.index, scanner, development, student);
        }else {
            System.err.print("请先创建学生");
            enter_exit();
        }
    }

    @SuppressWarnings("all")
    // 删除学生信息
    public void delete_student(){
        development.clear();
        if (development.creat_flag){
            System.out.print("请输入要删除的学生序号：");
            if (scanner.hasNextInt()){
                int number = scanner.nextInt();
                if (number <= 0){
                    System.out.println("请重新进入....");
                }else {
                    if (number <= development.index) {
                        number -= 1;
                        System.out.print("一旦删除，就无法恢复！是否删除？(y / 其他字符)：");
                        String yes_no = scanner.next();
                        if ("y".equalsIgnoreCase(yes_no)) {
                            for (int i = number; i < development.index; i++) {
                                if (i == development.index - 1)
                                    student[i] = null;
                                else
                                    student[i] = student[i + 1];
                            }

                            // 最开始执行删除函数时执行
                            if (development.delete_function_execution == false)
                                development.delete_function_execution = true;
                            System.out.println("正在删除....");
                            development.time();
                            System.out.println("删除成功！正在为您跳转....");
                            development.index--;
                            if (development.index == 0)
                                development.delete_index_zero = true;
                        }else
                            System.out.println("正在返回....");
                    }else {
                        System.out.println(String.format(
                                "无法删除序号为：%d， 该序号的数据为空~", number
                        ));
                        enter_exit();
                        return;
                    }
                }
            }else {
                String next = scanner.next();
                if ("exit".equalsIgnoreCase(next))
                    System.out.println("正在退出....");
                else
                    System.out.println(next + " 非数字的序号， 请重新进入....");
            }
            development.time();
            development.clear();
        }else {
            System.err.print("请先创建学生");
            enter_exit();
        }
    }

    // 查询学生信息
    public void select_student(){
        development.clear();
        if (development.creat_flag){
            for (int i = 0; i < development.index; ++i){
                if (student[i] != null)
                    System.out.println(
                            String.format("序号: %d   学号:  %d    姓名:  %s     年龄:  %d     年级:  %s     " +
                                            "班级:  %s     座位号:  %d", i + 1,
                                    student[i].getID(), student[i].getName(), student[i].getAge(),
                                    student[i].getGrade(), student[i].getClass_grade(),
                                    student[i].getSeat())
                    );
            }
        }
        else {
            if (development.index == 0 && development.delete_index_zero){
                System.out.println("数据空啦~");
                System.out.println("请重新录入学生信息或者重新录入学生人数哦~");
            }else {
                System.err.print("请先创建学生");
            }
        }
        enter_exit();
    }

    // 创建学生个数
    public boolean number_of_students(){
        development.clear();
        if (student == null) {
            System.out.print("input students number：");
            if (scanner.hasNextInt()) {
                int number = scanner.nextInt();
                if (number > 0) {
                    student = new Student[number];
                    for (int i = 0; i < student.length; i++){
                        student[i] = new Student();
                    }
                    System.out.println("输入成功！");
                    development.time();
                    development.clear();
                    return true;
                }else {
                    System.err.println("不能输入小于等于0的数字");
                    development.time();
                    development.clear();
                }
            } else {
                System.err.println("输入的不是整数");
                scanner.next();
                development.time();
                development.clear();
            }
            return false;
        }
        System.out.println(String.format("当前学生个数为：%d, 录入学生信息的个数为：%d", student.length, development.index));
        System.err.print("是否将学生个数全部清除？并重新录取？(y / 其他字符)：");
        String yes_no = scanner.next();
        if ("y".equalsIgnoreCase(yes_no)){
            student = null;
            development.index = 0;
            System.out.println("数据已清空");
            development.time();
            System.out.println("两秒后返回");
            development.time();
            development.clear();
            development.creat_flag = false;
            return false;
        }else {
            System.out.println("两秒后返回");
            development.time();
            development.clear();
        }
        return true;
    }
}

