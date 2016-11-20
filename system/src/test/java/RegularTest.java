import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by James on 2016/11/19.
 */
public class RegularTest {


    @Test
    public void test(){

        Pattern pattern = Pattern.compile("(phone*?)(?=\\d{11})");

        String text = "james’s info: phone-number1:18818403577, phone-number2:13729000579";

        Matcher matcher = pattern.matcher(text);

        while(matcher.find()){

            System.out.println(matcher.group());

        }

    }





}
