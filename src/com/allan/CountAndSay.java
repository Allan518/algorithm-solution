package com.allan;
public class CountAndSay {
    static String countAndSay ( int level ){
        System.out.println("inside countAndSay call " + level);
        if ( level == 1 ){
            return "1";
        }
        StringBuilder sb = new StringBuilder();
        String str = countAndSay( level - 1);
        System.out.println("from recursive call for level " + (level - 1) + " str = " + str);
        int count = 1 ;
        char value = '1' ;
        for( int i = 0; i < str.length(); i++  ){
            for( int j = i ; j < str.length() -1; j++){
                if ( str.charAt(j) == str.charAt(j+1 )){
                    count++;
                    value = str.charAt(j);
                }
                else{
                    i +=count;
                    sb.append(count);
                    sb.append(value);
                }

            }
            if( level == 2 ){
                sb.append("11");
            }
        }
        System.out.println("before return call level " + level + " sb = " + sb);
        return sb.toString();
    }

    public static void main(String[] args) {
        int level = 4;
        String words = "1";
        System.out.println(countAndSay(4));
    }
}
