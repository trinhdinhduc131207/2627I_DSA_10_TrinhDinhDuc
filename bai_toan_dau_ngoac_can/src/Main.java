import java.util.Deque;
import java.util.ArrayDeque;

public class Main {
    static class ngoacCanBang {
        public static boolean canBang (String vanBan) {
            Deque<Character> stack = new ArrayDeque<>();

            for (int i = 0; i < vanBan.length(); i++) {
                char ch = vanBan.charAt(i);
                if (ch == '(' || ch == '{' || ch == '[') {
                    stack.push(ch);
                }

                if (ch == ')' || ch == '}' || ch == ']') {
                    if (stack.isEmpty()) {
                        return false;
                    }

                    char top = stack.pop();
                    if (!kiemTraNgoacHopLe(top, ch)) {
                        return false;
                    }
                }
            }
            return stack.isEmpty();
        }

        public static boolean kiemTraNgoacHopLe (char top, char ch) {
            return (top == '(' && ch == ')') || (top == '[' && ch == ']') || (top == '{' && ch == '}');
        }
    }

    static void main() {
        String[] testCases = {
                "{[()]}",      // Cân bằng
                "{[(])}",      // Không cân bằng (mở ngoặc sai thứ tự)
                "((()",        // Không cân bằng (dư dấu mở)
                "())",         // Không cân bằng (dư dấu đóng)
                "(a * (b + c)"  // Cân bằng (chứa cả ký tự/toán tử khác)
        };

        for (String test : testCases) {
            System.out.printf("Chuỗi: %-15s -> Kết quả: %s%n",
                    "\"" + test + "\"",
                    ngoacCanBang.canBang(test) ? "Cân bằng" : "Không cân bằng");
        }
    }
}



