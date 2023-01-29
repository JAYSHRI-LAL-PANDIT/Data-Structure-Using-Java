public class SquareOfSortedArray {
    public static int[] arraySquare(int[] arr){
        int n = arr.length;
        int i=0;
        int j=n-1;
        int[] result = new int[n];
        for(int k=n-1; k>=0; k--){
            if(Math.abs(arr[i]) > Math.abs(arr[j])){
                result[k] = arr[i] * arr[i];
                i++;
            } else{
                result[k] = arr[j] * arr[j];
                j--;
            }
        } 
        return result; 
    }
    public static void main(String[] args) {
        int arr[] = {-4,-2,1,3,4};
        int result[]=arraySquare(arr);
        System.out.println("Square of Sorted Array is :");
        for(int i=0; i<result.length; i++){
            System.out.print(result[i]+" ");
        }
    }
}
