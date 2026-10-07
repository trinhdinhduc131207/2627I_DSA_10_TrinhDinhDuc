import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    static class Student {
        private int id;
        private String name;
        private double Cgpa;

        public Student(int id, String name, double Cgpa) {
            this.id = id;
            this.name = name;
            this.Cgpa = Cgpa;
        }

        public int getId () {
            return id;
        }

        public String getName () {
            return name;
        }

        public double getCgpa () {
            return Cgpa;
        }
    }
// sinh viên nào hơn thì đứng sau theo thứ tự tăng dần
    static class StudentComparator implements Comparator<Student> {
        @Override
        public int compare(Student x, Student y) {
            if (x.getCgpa() > y.getCgpa()) {
                return -1;
            } else if (x.getCgpa() < y.getCgpa()) {
                return 1;
            } else {
                if (x.getName().compareTo(y.getName()) != 0) {
                    return x.getName().compareTo(y.getName());
                } else {
                    if (x.getId() > y.getId()) {
                        return 1;
                    } else if (x.getId() < y.getId()) {
                        return -1;
                    }
                }
            }
            return 0;
        }
    }

    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<>();

        // Thêm các sinh viên test đầy đủ các trường hợp:
        // 1. Khác CGPA
        // 2. Cùng CGPA nhưng khác Tên
        // 3. Cùng CGPA, Cùng Tên nhưng khác ID
        studentList.add(new Student(33, "Rina", 3.68));
        studentList.add(new Student(85, "Ashis", 3.85));
        studentList.add(new Student(56, "Samiha", 3.75));
        studentList.add(new Student(19, "Samara", 3.75)); // Cùng CGPA 3.75 với Samiha -> So sánh tên (Samara < Samiha)
        studentList.add(new Student(22, "Fahim", 3.76));
        studentList.add(new Student(10, "Aamir", 3.75));  // Cùng CGPA 3.75 -> Tên Aamir lên đầu nhóm 3.75
        studentList.add(new Student(99, "Aamir", 3.75));  // Cùng CGPA 3.75, Cùng tên Aamir -> So sánh ID (ID 10 < ID 99)

        // Tiến hành sắp xếp bằng Comparator của bạn
        Collections.sort(studentList, new StudentComparator());

        // In kết quả ra màn hình để kiểm tra
        System.out.println("--- KẾT QUẢ SẮP XẾP ---");
        for (Student st : studentList) {
            System.out.println("ID: " + st.getId() + " | Name: " + st.getName() + " | CGPA: " + st.getCgpa());
        }
    }



}