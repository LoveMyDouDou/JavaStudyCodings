package 今日头条;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
        String line=bufferedReader.readLine();
        String [] strs=line.split(" ");
        int n=Integer.parseInt(strs[0]);
        int x=Integer.parseInt(strs[1]);
        line=bufferedReader.readLine();
        strs=line.split(" ");
        int array[] = new int[n+5];
        for(int i = 1; i<= n; i++){
            array[i] = Integer.parseInt(strs[i-1]);
        }
        int min=minIndex(array,n);
        int sum=(array[min]-1)*n;
        for(int i=1;i<=n;++i){
            array[i]-=(array[min]-1);
        }
//        int [] a={0,6,5,1};
//        slove(a,1,3);

        slove(array,x,n,sum);
    }


    public static int minIndex(int [] a,int n){
        int ans=a[1];
        int index=1;
        for(int i=2;i<=n;++i){
            if(a[i]<ans){
                ans=a[i];
                index=i;
            }
        }
        return index;
    }

    public static void slove(int [] a,int no,int n,int sum){
        int index=-1;
        for(int i=no;i>=0;--i){
            if(i==0){
                i=n;
            }
            --a[i];
            ++sum;
            if(a[i]==0){
                index=i;
                break;
            }
        }
        int count=0;
        for(int i=index-1;i>=0;--i){
            if(i==0){
                i=n;
            }
            --a[i];
            ++sum;
            ++count;
            if(count==n-1){
                a[index]=sum;
                break;
            }
        }

        for(int i=1;i<=n-1;++i){
            System.out.print(a[i]+" ");
        }
        System.out.print(a[n]);
    }
}
