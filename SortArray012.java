public class SortArray012 {
    public static int[] threeNumberSort(int[] arr){
        int i=0;
        int j=0;
        int k=arr.length - 1;
        while(i<=k){
            if(arr[i]==0){
                swap(arr,i,j);
                i++;
                j++;
            }else if(arr[i]==1){
                i++;
            }else if(arr[i]==2){
                swap(arr,i,k);
                k--;
            }
        }
        return arr;
    }
    public static void swap(int[]arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] =temp;
    }
    public static void main(String args[]){
            int arr[] = {2,1,0,1,0,2};
            int result[] = threeNumberSort(arr);
            System.out.println("Dutch National Flag Problem :");
            for(int i=0; i<result.length; i++){
                System.out.print(result[i]+" ");
            }
    }
}
