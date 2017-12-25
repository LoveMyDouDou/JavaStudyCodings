package 华为;


import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String [] args){
        Scanner scanner=new Scanner(System.in);
        String s=scanner.next();
        String string=scanner.next();
        String [] strs=string.split(",");
        long [] a;
        if(s.charAt(0)=='D'||s.charAt(0)=='d'){
            a=DESC(strs);
        }
        else {
            a=ASCE(strs);
        }
        System.out.print(a[0]);
        for(int i=1;i<a.length;++i){
            System.out.print(","+a[i]);
        }
    }

    public static long [] DESC(String [] strings){
        for(int i=0;i<strings.length;++i){
            strings[i]=toFormat(asce(strings[i]));
        }
        long [] a=new long [strings.length];
        for(int i=0;i<a.length;++i){
            a[i]=Long.parseLong(strings[i]);
        }
        Arrays.sort(a);
        for(int i=0;i<a.length/2;++i){
            long t=a[i];
            a[i]=a[a.length-1-i];
            a[a.length-1-i]=t;
        }
        return a;
    }

    public static long [] ASCE(String [] strings){
        for(int i=0;i<strings.length;++i){
            strings[i]=toFormat(asce(strings[i]));
        }
        long [] a=new long [strings.length];
        for(int i=0;i<a.length;++i){
            a[i]=Long.parseLong(strings[i]);
        }
        Arrays.sort(a);
        return a;
    }

    public static String toFormat(String s) {
        if(s.equals("0")){
            return "0";
        }
        if(s.charAt(0)=='-'){
            String ans="-";
            StringBuilder stringBuilder=new StringBuilder(s.substring(1));
            stringBuilder.reverse();
            return ans+stringBuilder.toString();
        }
        else {
            int index = 0;
            for (int i = 0; i < s.length(); ++i) {
                if (s.charAt(i) == '0') {
                    ++index;
                } else {
                    break;
                }
            }
            String zero="";
            for(int i=0;i<index;++i){
                zero+="0";
            }
            String ans=""+s.charAt(index);
            ans+=zero;
            ans+=s.substring(index+1);
            return ans;
        }
    }

    public static String asce(String s){
        char [] chars=s.toCharArray();
        Arrays.sort(chars);
        String ans="";
        int start=0;
        if(chars[0]=='-'){
            start=1;
            ans="-";
        }
        boolean flag=false;
        for(int i=start;i<chars.length;++i){
            ans+=chars[i];
        }
        return ans;
    }
}

