//返回A的最短的非空连续子数组的长度，该数组的和至少为K。如果没有和至少为K的非空子数组，返回—1。

import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入数组A中的数字元素，用逗号分隔。");
        String[] s = scanner.nextLine().split(",");
        int[] A = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            A[i] = Integer.parseInt(s[i]);
        }

        System.out.print("请输入K的值：");
        int k =(int)scanner.nextDouble();

        scanner.close();

//        System.out.print("A=[");
//        for (int i = 0; i<A.length; i ++){
//            if (i==A.length-1){
//                System.out.println(A[i]+"]");
//            }
//            else {
//                System.out.print(A[i]+",");
//            }
//        }
//        System.out.println("k="+k);

        int r = LengthAndSum(A,k);
        System.out.println("返回："+r);

    }

    //判断最短非空连续子数组的长度
    public static Integer LengthAndSum(int[] A,int k) {
        int r = -1;
        for (int size = 1; size <= A.length; size++) {

//            System.out.println("size="+size);
            for (int i = 0; i < A.length; i++) {
                int sum = 0;
                int count =0;
                for (int j = i ; j < i + size; j++) {
                    count ++;
                    if (j<A.length ){
//                        System.out.println("sum="+sum+",A[j]="+A[j]);
                        sum += A[j];
                        if (count==size) {
//                            System.out.println(sum);
                            r=ReturnBack(size,sum,k);
                            if (r!=-1){
                                return r;
                            }
                        }
                    }else break;
                }

            }

//            System.out.println("------------------");
        }
        return r;
    }

    //判断数组的和与k值，并返回最终结果
    public static Integer ReturnBack(int length,int sum,int k){
        if (sum<k){
            return -1;
        }
        else {
            return length;
        }
    }

}