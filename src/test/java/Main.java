
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.nextLine();
        String b = in.nextLine();

        Random r = new Random();
        int index=r.nextInt(b.length()-1)+1;

        StringBuffer str=new StringBuffer(b);

        String input=str.insert(index,a).toString();

        Pattern pattern = Pattern.compile("(.)\\1*");
        Matcher matcher = pattern.matcher(input);

        int length=0;
        while (matcher.find())
        {
            if(matcher.group().length()>1){
                length+=matcher.group().length();
                input=input.replace(matcher.group(),"");
                matcher = pattern.matcher(input);
            }
        }
        System.out.println(length);
    }
}
