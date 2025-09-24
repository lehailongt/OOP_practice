// tesetse saldfjdksalhfksdajhglkjsa;jghbakf;lgndasklvjsadngbflva
// dskahg;salngsda  sda v sadvad v das s


import java.util.Scanner;

public class Employee {

    private String code;
    private String name;
    private int salary;

    public Employee(){};
    public Employee(String code, String name, int salary){
        this.code = code;
        this.name = name;
        this.salary = salary;
    }

    public void set_code (String code) {
        this.code = code;
    }
    public String get_code () {
        return this.code;
    }
    public void set_name (String name) {
        this.name = name;
    }
    public String get_name () {
        return this.name;
    }
    public void set_salary (int salary) {
        this.salary = salary;
    }
    public int get_salary () {
        return this.salary;
    }

    public void input (Scanner sc) {
        System.out.print("code : ");
        set_code(sc.nextLine());
        System.out.print("name : ");
        set_name(sc.nextLine());
        System.out.print("salary : ");
        set_salary(Integer.parseInt(sc.nextLine()));
    }

    public boolean is_remove (int type, String x) {
        switch (type) {
            case 1:
                return get_code().equals(x);
            case 2:
                return get_name().equals(x);
            case 3:
                return x.matches("[0-9]+") && get_salary() == Integer.parseInt(x);
            default:
                return false;
        }
    }

    @Override
    public String toString () {
        return String.format("| %10s | %20s | %10d $ |", code, name, salary);
    }
}
