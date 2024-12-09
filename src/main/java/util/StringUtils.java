package util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: tongqianwen
 * @Date: 2024/12/9
 */
public class StringUtils {
    public static String[] parseCommand(String input){
        List<String> tokens = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char character = input.charAt(i);
            if('\''==character){
                while ('\''!=(character=input.charAt(++i))){
                    sb.append(character);
                }
                tokens.add(sb.toString());
                sb=new StringBuilder();
                continue;
            }
            if(' '!=character){
                sb.append(character);
            }else if(!sb.isEmpty()){
                tokens.add(sb.toString());
                sb=new StringBuilder();
            }
        }
        return  tokens.toArray(tokens.toArray(new String[0]));
    }

    public static void main(String[] args) {
        String input = "cat 'aa' 'bb jj '";
        String[] strings = parseCommand(input);
        System.out.println(Arrays.asList(strings));
    }
}
