import java.util.Scanner;

class Student {
    int id;
    String name;
    int age;
    float[] grades = new float[3];

    void display() {
        System.out.println("ID: " + id + ", Name: " + name + ", Age: " + age);
        System.out.print("Grades: ");
        for (float g : grades) System.out.print(g + " ");
        System.out.println();
    }
}

public class StudentRecordSystem {
    static Student[] students = new Student[100];
    static int count = 0;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n1. Add Student\n2. Display All\n3. Search by ID\n0. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    displayAll();
                    break;
                case 3:
                    searchStudent();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice!");
                    break;
            }
        } while (choice != 0);
    }

    static void addStudent() {
        Student s = new Student();
        System.out.print("Enter ID: ");
        s.id = sc.nextInt();
        sc.nextLine(); // consume newline
        System.out.print("Enter Name: ");
        s.name = sc.nextLine();
        System.out.print("Enter Age: ");
        s.age = sc.nextInt();
        System.out.println("Enter 3 Grades:");
        for (int i = 0; i < 3; i++) {
            System.out.print("Grade " + (i + 1) + ": ");
            s.grades[i] = sc.nextFloat();
        }
        students[count++] = s;
        System.out.println("Student added successfully!");
    }

    static void displayAll() {
        if (count == 0) {
            System.out.println("No records found.");
            return;
        }
        for (int i = 0; i < count; i++) {
            students[i].display();
        }
    }

    static void searchStudent() {
        System.out.print("Enter ID to search: ");
        int id = sc.nextInt();
        for (int i = 0; i < count; i++) {
            if (students[i].id == id) {
                students[i].display();
                return;
            }
        }
        System.out.println("Student not found.");
    }
}
