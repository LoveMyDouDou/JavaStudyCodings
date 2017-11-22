package 网易;

import java.util.Scanner;

public class InterstellarCrossing {

    public static void main(String [] args){
        Scanner scanner=new Scanner(System.in);
        long h=scanner.nextLong();
        long x=(long)Math.sqrt(h);
        while(x<Integer.MAX_VALUE){
            if(x*x+x<=h){
                if(x*x+3*x+2>h){
                    break;
                }
            }
            --x;
        }
        System.out.println(x);
    }

}
