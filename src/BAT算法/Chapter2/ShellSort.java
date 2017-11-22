package BAT算法.Chapter2;

public class ShellSort {

    public int [] shellSort(int [] A, int n){
        if(A==null||n<2){
            return A;
        }
        int feet=n/2;
        int index=0;
        printArray(A);
        while (feet>0){
            printArray(A);
            for(int i=feet;i<n;i++){
                index=i;
                while (index>=feet){
                    if(A[index-feet]>A[index]){
                        swap(A,index-feet,index);
                        index-=feet;
                    }
                    else {
                        break;
                    }
                }
            }
            feet/=2;
        }
        printArray(A);
        return A;
    }

    static void  swap(int []A,int m,int n){
        A[m]=A[m]^A[n];
        A[n]=A[m]^A[n];
        A[m]=A[m]^A[n];
    }

    static void printArray(int []a){
        for(Integer n: a){
            System.out.print(n+" ");
        }
        System.out.println();
    }

    public static void main(String [] args){
        int [] a={1,5,2,9,6,7,4};
        new ShellSort().shellSort(a,a.length);
    }

}
