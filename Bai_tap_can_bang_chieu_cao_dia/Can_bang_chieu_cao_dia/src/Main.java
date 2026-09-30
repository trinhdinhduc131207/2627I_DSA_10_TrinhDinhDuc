import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt(); // Số lượng thao tác

        StringBuilder s = new StringBuilder(); // Dùng StringBuilder để thao tác chuỗi nhanh hơn
        Stack<String> history = new Stack<>(); // Stack lưu lịch sử các chuỗi trước khi sửa

        for (int i = 0; i < q; i++) {
            int type = sc.nextInt();

            if (type == 1) {
                // Thao tác 1 W: Append chuỗi W vào s
                String w = sc.next();
                history.push(s.toString()); // Lưu trạng thái cũ trước khi append
                s.append(w);

            } else if (type == 2) {
                // Thao tác 2 k: Xóa k ký tự cuối cùng của s
                int k = sc.nextInt();
                history.push(s.toString()); // Lưu trạng thái cũ trước khi delete
                s.delete(s.length() - k, s.length());

            } else if (type == 3) {
                // Thao tác 3 k: In ra ký tự thứ k (1-indexed)
                int k = sc.nextInt();
                System.out.println(s.charAt(k - 1)); // 1-indexed đổi sang 0-indexed bằng (k - 1)

            } else if (type == 4) {
                // Thao tác 4: Undo - Quay lại trạng thái trước đó
                s = new StringBuilder(history.pop());
            }
        }
        sc.close();
    }
}