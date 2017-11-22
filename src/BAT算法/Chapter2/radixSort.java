package BAT算法.Chapter2;

public class radixSort {
    public int [] radixSort(int [] A,int n){
        if(null==A||n<2){
            return A;
        }
        int [] bucket=new int [n];
        int [] count=new int [10];
        for(int i=1;i<=4;++i){
            for(int j=0;j<10;++j){
                count[j]=0;
            }
            for(int j=0;j<n;++j){
                count[getNum(A[j],i)]++;
            }
            for(int k=1;k<10;++k){
                count[k]=count[k]+count[k-1];
            }
        }
        return A;
    }

    private int getNum(int x,int d){
        int [] a={1,1,10,100,1000};
        return (x/a[d]%10);
    }

}
