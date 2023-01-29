public class InsertionSort {
    public static int[] sort(int arr[]){
        int n = arr.length;
        for(int i=1; i<n; i++){
            int temp=arr[i];
            int j=i-1;
            while(j>=0 && arr[j]>temp){
                arr[j+1]=arr[j];
                j=j-1;
            }
            arr[j+1]=temp;
        }
        return arr;
    }
    public static void main(String[] args) {
        int[] arr={5,3,6,8,2};
        int[] result=sort(arr);
        for(int i=0; i<result.length; i++){
            System.out.print(result[i]+" ");
        }
    }
}
