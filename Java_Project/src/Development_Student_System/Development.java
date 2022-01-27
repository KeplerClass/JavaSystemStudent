package Development_Student_System;
import System_Student.Student;
import java.util.Scanner;

public class Development {

    static {
        // ʹ��JNI��������C

        /*
            ��С�����ļ�Ŀ¼������ǲ�һ���ģ�������ʹ�õĻ���
            �뽫Java_Project�������µ������ļ�,һ�����һ��Ŀ¼��
            ��ʹ��System.getProperty("user.id")����ȡ��ǰ�ļ���Ŀ¼
            ����Java_Project��ƴ�ӣ�����
            System.load(System.getProperty("user.id") + "\\Java_Project\\" +
                "src\\Development_Student_System\\clear.dll");
            System.load(System.getProperty("user.id") + "\\Java_Project\\" +
                "src\\Development_Student_System\\time.dll");

            ������У�ֱ�ӽ��ļ�ȫ·��д��System.load()������
            System.load("ĳ��:\\xx\\xx\\...\\Java_Project\\" +
                "src\\Development_Student_System\\clear.dll");
            System.load("ĳ��:\\xx\\xx\\...\\Java_Project\\" +
                "src\\Development_Student_System\\time.dll");
        */

        System.load(System.getProperty("user.id") + "\\Java_Project\\" +
                "src\\Development_Student_System\\clear.dll");
        System.load(System.getProperty("user.id") + "\\Java_Project\\" +
                "src\\Development_Student_System\\time.dll");
    }

    public final native void clear(); // ����C��������

    public final native void time(); // ����C�����ʱ��

    protected Development(){} // ���˱����еı�������ࡢ��������Դ���������������

    protected static Student[] student = null;  // ��̬����

    public static final Scanner
            scanner = new Scanner(System.in);  // ��̬����������

    private static final Development development = new Development(); // ˽�еľ�̬��������

    // ʹ�ô���ѧ�������
    private final Creat_Student creat_student_at = new Creat_Student();

    // ʹ���޸�ѧ�������
    private final Update_Student update_student_at = new Update_Student();

    public boolean number_flag = false;
    
    public boolean creat_flag = false;

    public int index = 0; // ѧ����ǰ����

    boolean delete_index_zero = false; // ��ɾ��ѧ��ȫ����Ϣ������Ϊ0ʱ

    boolean delete_function_execution = false;  // ��ɾ������ִ��ʱ

    @SuppressWarnings("all")
    public static final void enter_exit(){
        while (true){
            System.out.println();
            System.out.print("����0�˳���");
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
        // ��ӡ���˵�
        development.clear();
        System.out.println("-----------Welcome To The Student Management System-----------");
        System.out.println("1. Create Student");
        System.out.println("2. Update Student");
        System.out.println("3. Delete Student");
        System.out.println("4. Select Student");
        System.out.println("5. Number Of Students");
        System.out.println("6. Exit System");
        System.out.print("input��");
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
                        System.out.println("��л����ʹ�ã��ټ���");
                        development.time();
                        System.out.println("������˳�ϵͳ");
                        development.time();
                        development.clear();
                        scanner.close();  // �ر�������
                        System.exit(0); // �˳�ϵͳ
                }
            }else {
                System.err.println(String.format("%d ����(1 - 6)�ķ�Χ��", number));
                development.time();
                development.clear();
            }
        }else {
            System.err.println("����������Ƿ���������");
            System.out.println("����������(�����ˢ��)");
            development.time();
            development.clear();
        }
    }

    // ����ѧ����Ϣ
    public boolean creat_student(){
        development.clear();
        if (development.number_flag){

            // ȫ����Ϣ��ɾ����
            if (development.delete_index_zero){
                for (int i = 0; i < development.index; i++)
                    student[i] = new Student();
                System.out.println("������Ϊ�գ�����Ϊ�����´�����Ϣ¼���");
                System.out.println("���ڴ���...");
                development.time();
                System.out.println("�����ɹ��������˳�....");
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

                    System.out.print("�Ƿ���� (1.��  2.��)��");
                    String next = scanner.next();
                    if ("2".equals(next)){
                        System.out.println("�����˳�....");
                        development.time();
                        break;
                    }
                    development.clear();
                } else {
                    development.time();
                    System.out.println("�޷�¼�룬ԭ�����£�");
                    System.out.println();
                    System.out.println(String.format("ѧ������Ϊ��%d", student.length));
                    System.err.println(String.format("��ǰѧ������Ϊ��%d", development.index));
                    System.out.println("�Ѿ��ﵽ���ʼ�����ѧ������������Ҫɾ������ѧ����ת��3ѡ����" +
                            "������Ҫ����¼ȡѧ����������ѡ��5ѡ����");
                    enter_exit();
                    break;
                }
            }
            return true;
        }else {
            System.err.print("��������Ҫ¼���ѧ������");
            enter_exit();
            return false;
        }
    }

    // �޸�ѧ����Ϣ
    public void update_student(){
        development.clear();
        if (development.creat_flag)
        {
            this.update_student_at.update_student_applet
                    (development.index, scanner, development, student);
        }else {
            System.err.print("���ȴ���ѧ��");
            enter_exit();
        }
    }

    @SuppressWarnings("all")
    // ɾ��ѧ����Ϣ
    public void delete_student(){
        development.clear();
        if (development.creat_flag){
            System.out.print("������Ҫɾ����ѧ����ţ�");
            if (scanner.hasNextInt()){
                int number = scanner.nextInt();
                if (number <= 0){
                    System.out.println("�����½���....");
                }else {
                    if (number <= development.index) {
                        number -= 1;
                        System.out.print("һ��ɾ�������޷��ָ����Ƿ�ɾ����(y / �����ַ�)��");
                        String yes_no = scanner.next();
                        if ("y".equalsIgnoreCase(yes_no)) {
                            for (int i = number; i < development.index; i++) {
                                if (i == development.index - 1)
                                    student[i] = null;
                                else
                                    student[i] = student[i + 1];
                            }

                            // �ʼִ��ɾ������ʱִ��
                            if (development.delete_function_execution == false)
                                development.delete_function_execution = true;
                            System.out.println("����ɾ��....");
                            development.time();
                            System.out.println("ɾ���ɹ�������Ϊ����ת....");
                            development.index--;
                            if (development.index == 0)
                                development.delete_index_zero = true;
                        }else
                            System.out.println("���ڷ���....");
                    }else {
                        System.out.println(String.format(
                                "�޷�ɾ�����Ϊ��%d�� ����ŵ�����Ϊ��~", number
                        ));
                        enter_exit();
                        return;
                    }
                }
            }else {
                String next = scanner.next();
                if ("exit".equalsIgnoreCase(next))
                    System.out.println("�����˳�....");
                else
                    System.out.println(next + " �����ֵ���ţ� �����½���....");
            }
            development.time();
            development.clear();
        }else {
            System.err.print("���ȴ���ѧ��");
            enter_exit();
        }
    }

    // ��ѯѧ����Ϣ
    public void select_student(){
        development.clear();
        if (development.creat_flag){
            for (int i = 0; i < development.index; ++i){
                if (student[i] != null)
                    System.out.println(
                            String.format("���: %d   ѧ��:  %d    ����:  %s     ����:  %d     �꼶:  %s     " +
                                            "�༶:  %s     ��λ��:  %d", i + 1,
                                    student[i].getID(), student[i].getName(), student[i].getAge(),
                                    student[i].getGrade(), student[i].getClass_grade(),
                                    student[i].getSeat())
                    );
            }
        }
        else {
            if (development.index == 0 && development.delete_index_zero){
                System.out.println("���ݿ���~");
                System.out.println("������¼��ѧ����Ϣ��������¼��ѧ������Ŷ~");
            }else {
                System.err.print("���ȴ���ѧ��");
            }
        }
        enter_exit();
    }

    // ����ѧ������
    public boolean number_of_students(){
        development.clear();
        if (student == null) {
            System.out.print("input students number��");
            if (scanner.hasNextInt()) {
                int number = scanner.nextInt();
                if (number > 0) {
                    student = new Student[number];
                    for (int i = 0; i < student.length; i++){
                        student[i] = new Student();
                    }
                    System.out.println("����ɹ���");
                    development.time();
                    development.clear();
                    return true;
                }else {
                    System.err.println("��������С�ڵ���0������");
                    development.time();
                    development.clear();
                }
            } else {
                System.err.println("����Ĳ�������");
                scanner.next();
                development.time();
                development.clear();
            }
            return false;
        }
        System.out.println(String.format("��ǰѧ������Ϊ��%d, ¼��ѧ����Ϣ�ĸ���Ϊ��%d", student.length, development.index));
        System.err.print("�Ƿ�ѧ������ȫ�������������¼ȡ��(y / �����ַ�)��");
        String yes_no = scanner.next();
        if ("y".equalsIgnoreCase(yes_no)){
            student = null;
            development.index = 0;
            System.out.println("���������");
            development.time();
            System.out.println("����󷵻�");
            development.time();
            development.clear();
            development.creat_flag = false;
            return false;
        }else {
            System.out.println("����󷵻�");
            development.time();
            development.clear();
        }
        return true;
    }
}

