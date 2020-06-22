import java.util.Scanner;
import java.util.Stack;

public class test4 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int length = 0;
        length = Integer.valueOf(in.nextLine());
        String[] list = in.nextLine().split(" ");
        Stack stack=new Stack<>();
        if (list.length != length) {
            System.out.println("");
        } else {
            for (int i = length-1; i >=0; i--) {
                if (i == length-1){
                    stack.push(0);
                }
                for (int j = i + 1; j <length; j++) {
                    if (Integer.valueOf(list[j]) > Integer.valueOf(list[i])) {
                        stack.push(j);
                        break;
                    } else {
                        if (j == length - 1) {
                            stack.push(0);
                        }
                    }
                }

            }
        }
        while (!stack.empty()){
            System.out.printf("%s ",stack.pop());
        }

    }
}
