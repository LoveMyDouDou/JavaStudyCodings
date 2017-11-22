package 牛客练习赛5;

import java.util.Scanner;

public class Split {

    public static void main(String [] args){
        Scanner scanner=new Scanner(System.in);
        int s=scanner.nextInt();
        int m=scanner.nextInt();

        int l=1,r=s-1;
        int k=-1;
        while (l<=r){
            int mid=(l+r)>>1;
            if(check(s,mid)>=m){
                r=mid-1;
                k=mid;
            }
            else {
                l=mid+1;
            }
        }
        System.out.println(k);
    }

    static long check(int s,int k){
        ++k;
        int num=s/k;
        int r=s%k;
        long ans=0;
        for(int i=1;i<=r;++i){
            ans+=(num+1)*(s-num-1);
            s-=num+1;
        }
        for(int i=r+1;i<k;++i){
            ans+=num*(s-num);
            s-=num;
        }
        return ans;
    }

}
