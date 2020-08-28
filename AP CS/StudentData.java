import java.util.*;
import java.io.*;

/**
 * StudentData
 */
public class StudentData {

    public static void main(String[] args) {
        System.out.println("Enter student data file name: ");
        Scanner console = new Scanner(System.in);
        String fn = console.next();
        console.close();

        try {
            ArrayList<Student> students = new ArrayList<>();
            BufferedReader reader = new BufferedReader(new FileReader(new File(fn)));
            String line;
            while ((line = reader.readLine()) != null) {
                StringTokenizer t = new StringTokenizer(line);
                students.add(new Student(t.nextToken(), t.nextToken(), t.nextToken(), Double.valueOf(t.nextToken()), t.nextToken().charAt(0)));
            }
            reader.close();

            ArrayList<Student> last = new ArrayList<>(students);
            last.sort(new Comparator<Student>() {
                @Override
                public int compare(Student o1, Student o2) {
                    return o1.last.compareTo(o2.last);
                }
            });
            ArrayList<Student> first = new ArrayList<>(students);
            first.sort(new Comparator<Student>() {
                @Override
                public int compare(Student o1, Student o2) {
                    return o1.first.compareTo(o2.first);
                }
            });
            ArrayList<Student> id = new ArrayList<>(students);
            id.sort(new Comparator<Student>() {
                @Override
                public int compare(Student o1, Student o2) {
                    return o1.id.compareTo(o2.id);
                }
            });
            ArrayList<Student> percent = new ArrayList<>(students);
            percent.sort(new Comparator<Student>() {
                @Override
                public int compare(Student o1, Student o2) {
                    return Double.compare(o1.percent, o2.percent);
                }
            });
            ArrayList<Student> grade = new ArrayList<>(students);
            grade.sort(new Comparator<Student>() {
                @Override
                public int compare(Student o1, Student o2) {
                    if (o1.grade != o2.grade) return Character.compare(o1.grade, o2.grade);
                    return Double.compare(o1.percent, o2.percent);
                }
            });

            System.out.println("Student data, by last name:");
            printStudents(last);
            System.out.println("Student data, by first name:");
            printStudents(first);
            System.out.println("Student data, by student id:");
            printStudents(id);
            System.out.println("Student data, by percentage:");
            printStudents(percent);
            System.out.println("Student data, by grade:");
            printStudents(grade);

            System.out.println("Student data, by last name(reversed):");
            printStudents(reversed(last));
            System.out.println("Student data, by first name(reversed):");
            printStudents(reversed(first));
            System.out.println("Student data, by student id(reversed):");
            printStudents(reversed(id));
            System.out.println("Student data, by percentage(reversed):");
            printStudents(reversed(percent));
            System.out.println("Student data, by grade(reversed):");
            printStudents(reversed(grade));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void printStudents(ArrayList<Student> students) {
        for (Student s : students) {
            System.out.println(formatted(s.last, 10, 0) + formatted(s.first, 14, 0) + formatted(s.id, 9, 0) + formatted(String.valueOf(s.percent), 5, 1) + formatted(String.valueOf(s.grade), 6, 1));
        }
        System.out.println();
    }

    public static String formatted(String s, int slot, int alignment) {
        String gap = "";
        for (int i = 0; i < slot - s.length(); i++) gap += " ";
        if (alignment == 0)
            return s + gap;
        return gap + s;
    }

    public static ArrayList<Student> reversed(ArrayList<Student> l) {
        Collections.reverse(l);
        return l;
    }

}

class Student {

    public String last;
    public String first;
    public String id;
    public double percent;
    public char grade;

    public Student(String last, String first, String id, double percent, char grade) {
        this.last = last;
        this.first = first;
        this.id = id;
        this.percent = percent;
        this.grade = grade;
    }

}