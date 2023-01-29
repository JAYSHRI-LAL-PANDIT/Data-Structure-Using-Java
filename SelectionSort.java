public class SelectionSort {
    public static int[] sort(int[] arr){
        int n = arr.length;
        
        for(int i=0; i<n-1; i++){
            int min=i;
            for(int j=i+1; j<n; j++){
                if(arr[j]< arr[min])
                    min=j;
            }
            int temp=arr[min];
            arr[min]=arr[i];
            arr[i]=temp;
        }
        return arr;
    }
    public static void main(String []args){
        int []arr=new int[] {4,2,5,6,8};
        int[] result= sort(arr);
        for(int i=0; i<result.length; i++){
            System.out.print(result[i]+" ");
        }
    }
}
