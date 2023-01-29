public class LinearSearchItirative {
    public static int linearSearch(int[] arr,int n, int key){
        for(int i=0; i<n; i++){
            if(arr[i]==key){
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args){
        int[] arr={4,3,9,23,19,34};
        System.out.println("Index number is :"+linearSearch(arr, arr.length, 9));
    }
}
