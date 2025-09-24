import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.util.Iterator;
// import java.util.*;

public class users {
    public static void main (String[] args) {
        try {
            // directly link to file saver;
            String file_name = "employees.txt";
            ArrayList<Employee> employees = new ArrayList<>();
            // get initial employee from file to list
            Scanner sc_file = new Scanner(new File(file_name));
            while (sc_file.hasNextLine()) {
                String code = sc_file.nextLine();
                String name = sc_file.nextLine();
                int salary = Integer.parseInt(sc_file.nextLine());
                employees.add(new Employee(code, name, salary));
            }
            sc_file.close();
            Scanner sc = new Scanner(System.in);
            while(true) {
                show_menu();
                int t = Integer.parseInt(sc.nextLine());
                if(t == 1) {
                    add_employee(employees, sc);
                } else if (t == 2) {
                    remove_employee(employees, sc);
                } else if (t == 3) {
                    promote_salary(employees, sc);
                } else if (t == 4) {
                    show_employees(employees);
                } else if (t == 5) {
                    save_list_to_file(employees, file_name);
                } else if (t == 6) {
                    break;
                } else {
                    System.out.print("WRONG FUNCTIONs");
                }
            }
        } catch (Exception ex) {
            System.out.println();
            ex.printStackTrace();
        } finally {
            System.out.println("DONE!");
        }
    }

    public static void show_menu () {
        String[] menu_list = {
            "Adding new employee",
            "Removing employee",
            "Promoting the salary of an employee",
            "Listing employee details",
            "Save the list to file",
            "Quit"
        };
        for (int i = 1; i <= menu_list.length; i++) {
            System.out.printf("%d. %s\n", i, menu_list[i - 1]);
        }
        System.out.println("-".repeat(50));
    }

    public static void add_employee (ArrayList<Employee> employees, Scanner sc) {
        Employee new_employee = new Employee();
        new_employee.input(sc);
        employees.add(new_employee);
    }

    // delete employee with exactly and salary must be number
    public static void remove_employee (ArrayList<Employee> employees, Scanner sc) {
        System.out.println("You want to remove employee with code, name or salary : ");
        System.out.println("1. code");
        System.out.println("2. name");
        System.out.println("3. salary");
        int t = Integer.parseInt(sc.nextLine());
        String name= sc.nextLine();
        Iterator<Employee> it = employees.iterator();
        while (it.hasNext()) {
            Employee x = it.next();
            if (x.is_remove(t, name)) {
                it.remove();
            }
        }
    }

    public static void promote_salary (ArrayList<Employee> employees, Scanner sc) {
        System.out.println("How much $ do you want increase salary ? ");
        int x = Integer.parseInt(sc.nextLine());
        for (Employee e : employees) {
            e.set_salary(e.get_salary() + x);
        }
    }

    public static void show_employees (ArrayList<Employee> employees) {
        System.out.printf("| %10s | %20s | %10s $ |\n", "code", "name", "salary");
        System.out.println("-".repeat(50));
        for(Employee x : employees) {
            System.out.println(x);
        }
    }

    public static void save_list_to_file (ArrayList<Employee> employees, String file_name) {
        try {
            File f = new File(file_name);
            PrintWriter output = new PrintWriter(f);
            for(Employee x : employees) {
                output.println(x.get_code());
                output.println(x.get_name());
                output.println(x.get_salary());
            }
            output.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}