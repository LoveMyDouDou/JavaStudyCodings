package 网易;

import java.util.Scanner;

public class AssignApples {

    public static void main(String [] args){
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int [] a=new int [n];
        int sum=0;
        for(int i=0;i<n;++i){
            a[i]=scanner.nextInt();
            sum+=a[i];
        }
        if(sum%n!=0){
            System.out.println("-1");
        }
        else {
            int average=sum/n;
            int ans=0;
            for(int i=0;i<n;++i){
                if(a[i]>average){
                    if(((a[i]-average)&1)==0){
                        ans+=(a[i]-average)/2;
                    }
                    else {
                        System.out.println("-1");
                        return;
                    }
                }
            }
            System.out.println(ans);
        }
    }

}
