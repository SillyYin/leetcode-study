package acwing.problem429;

import java.util.*;

/**
 * @author yinrongjie
 * @version 1.0
 * @description 奖学金
 * @date 2021/2/21
 */
public class Main {
    static class Student {
        int studentNo;
        int chinese;
        int math;
        int english;
        int total;

        public Student(int studentNo, String chinese, String math, String english) {
            this.studentNo = studentNo;
            this.chinese = Integer.parseInt(chinese);
            this.math = Integer.parseInt(math);
            this.english = Integer.parseInt(english);
            this.total = this.chinese + this.math + this.english;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        List<Student> studentList = new ArrayList<>();
        for (int i = 1; i <= n; ++i) {
            String[] scores = in.nextLine().split(" ");
            studentList.add(new Student(i, scores[0], scores[1], scores[2]));
        }
        studentList.sort((o1, o2) -> {
            if (o1.total != o2.total) {
                return o2.total - o1.total;
            } else if (o1.chinese != o2.chinese) {
                return o2.chinese - o1.chinese;
            }
            return o1.studentNo - o2.studentNo;
        });
        for (int i = 0; i < 5; ++i) {
            Student student = studentList.get(i);
            System.out.println(student.studentNo + " " + student.total);
        }
    }
}
