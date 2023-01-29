public class QuickSort {
     private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i= low;
        int j= low;
        while(i<=high){
            if(arr[i]<=pivot){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j++;
            }
            i++;
        }
        return j-1;
    }
    public static int[] sort(int[] arr,int low,int high){
        if(low<high){
            int p = partition(arr,low,high);
            sort(arr, low, p-1);
            sort(arr, p+1, high);
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr={9,-3,5,2,6,8,-6,1,3};
        int result[]=sort(arr, 0,arr.length-1);
        for(int i=0; i<result.length; i++){
            System.out.print(result[i]+" ");
        }
    }
    
}
