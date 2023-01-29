
public class LinearSearchRecursive {
    public static int linearSearch(int arr[],int size,int key){
        if(size==0)
            return -1;
        if(arr[size-1]==key)
            return size-1;
        else
            return linearSearch(arr, size-1, key);            
    }
    public static void main(String args[]){
        int arr[]={4,2,0,1,5};
        int index=linearSearch(arr, arr.length, 5);
        if(index== -1){
            System.out.println("Element is not found in the array.");
        }else{
            System.out.println("Element is found at the Position is :"+index);
        }

    }
}
