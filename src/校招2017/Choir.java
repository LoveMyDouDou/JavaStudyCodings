package 校招2017;

import java.util.Scanner;

public class Choir {

    public static void main(String [] args){
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int [] a=new int [n+1];
        for(int i=1;i<=n;++i){
            a[i]=scanner.nextInt();
        }
        int K=scanner.nextInt();
        int d=scanner.nextInt();
        long [][] fmax=new long[K+1][n+1];
        long [][] fmin=new long[K+1][n+1];

        long res=Integer.MIN_VALUE;
        for(int i=1;i<=n;++i){
            fmax[1][i]=a[i];
            fmin[1][i]=a[i];
            for(int k=2;k<=K;++k){
                for(int j=i-1;j>0&&i-j<=d;--j){
                    fmax[k][i]=Math.max(fmax[k][i],Math.max(fmax[k-1][j]*a[i],fmin[k-1][j]*a[i]));
                    fmin[k][i]=Math.min(fmin[k][i],Math.min(fmax[k-1][j]*a[i],fmin[k-1][j]*a[i]));
                }
            }
            res=Math.max(res,fmax[K][i]);
        }
        System.out.println(res);
    }

}
