package BAT算法.Chapter2;

public class CountingSort {

    public int[] countingSort(int[] A, int n) {
        count(A);
        return A;
    }

    public static void count(int [] arr){
        int min=arr[0];
        int max=arr[0];
        for(int i=1;i<arr.length;++i){
             min=Math.min(arr[i],min);
             max=Math.max(arr[i],max);
        }
        int [] countArr=new int[max-min+1];
        for(int i=0;i<arr.length;++i){
            countArr[arr[i]-min]++;
        }
        int index=0;
        for (int i=0;i<countArr.length;++i){
            while (countArr[i]-->0){
                arr[index++]=i+min;
            }
        }
    }

}
