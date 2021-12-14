import java.util.*;

public class Solution {
    static ArrayList<String> list = new ArrayList<>();
    static StringBuilder temp = new StringBuilder();
    public static ArrayList < String > findAbbr(String str) {
        // Write your code here.
//         Input: "BAT"
// 		Output: "BAT", "BA1", "B1T", "B2", "1AT", "1A1", "2T", "3"
        temp = new StringBuilder();
        list = new ArrayList<>();
        substrFn(str, str);
        Collections.sort(list);
        return list;
    }
    public static void substrFn(String str, String ros)
    {

        if(ros.length()==0)
        {
            list.add(new String(temp));

            if(Character.isDigit(temp.charAt(temp.length()-1))){
                int x = Character.getNumericValue(temp.charAt(temp.length()-1));
                if(x>1){
                    temp.append((x-1)+"");
                    temp.deleteCharAt(temp.length()-2);
                }
                else  temp.deleteCharAt(temp.length()-1);
            }
            else{
                temp.deleteCharAt(temp.length()-1);
            }
            return;
        }

        if(ros.length()>0)
        {
            if(temp.length()==0 || !Character.isDigit(temp.charAt(temp.length()-1))){
                temp.append(ros.charAt(0));
                substrFn(str, ros.substring(1));

                temp.append('1');
                substrFn(str, ros.substring(1));
            }
            else{
                temp.append((Character.getNumericValue(temp.charAt(temp.length()-1))+1)+ "");
                temp.deleteCharAt(temp.length()-2);
                substrFn(str, ros.substring(1));

                temp.append(ros.charAt(0));
                substrFn(str, ros.substring(1));
            }

        }
        if(temp.length()>0)
        {
            if(Character.isDigit(temp.charAt(temp.length()-1))){
                int x = Character.getNumericValue(temp.charAt(temp.length()-1));
                if(x>1){
                    temp.append((x-1)+"");
                    temp.deleteCharAt(temp.length()-2);
                }
                else  temp.deleteCharAt(temp.length()-1);
            }
            else{
                temp.deleteCharAt(temp.length()-1);
            }
        }
    }
}

