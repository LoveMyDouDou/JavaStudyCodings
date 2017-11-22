package BAT算法.Chapter2;

public class HeapSort {
    public int [] heapSort(int [] A,int n){
        for(int i=n/2;i>=0;--i){
            System.out.println("-----heapAjust-----");
            heapAdjust(A,i,n);
            printArray(A);
        }
        for(int i=n-1;i>0;--i){
            swap(A,0,i);
            System.out.println("-----swap-----");
            printArray(A);
            System.out.println("-----heapAjust-----");
            heapAdjust(A,0,i);
            printArray(A);
        }
        return A;
    }

    void heapAdjust(int []A,int index,int length){
        int childLeft;
        int temp=A[index];
        for(;index*2+1<length;index=childLeft){
            childLeft=index*2+1;
            if(childLeft!=length-1&&A[childLeft]<A[childLeft+1]){
                ++childLeft;
            }
            if(temp>A[childLeft]){
                break;
            }
            else {
                A[index]=A[childLeft];
                index=childLeft;
            }
        }
        A[index]=temp;
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
        new HeapSort().heapSort(a,a.length);
    }
}
