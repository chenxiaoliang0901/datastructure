import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class test1 {
    public static void main(String[] args)
    {
        String strings = matcher("ABCBCCCAAB");
        System.out.println(strings);
    }

    public static String matcher(String input)
    {
        Pattern pattern = Pattern.compile("(.)\\1*");
        Matcher matcher = pattern.matcher(input);
        while (matcher.find())
        {
            if(matcher.group().length()>1){
                input=input.replace(matcher.group(),"");
                matcher = pattern.matcher(input);
            }
        }
        System.out.println();


        return input;
    }
}