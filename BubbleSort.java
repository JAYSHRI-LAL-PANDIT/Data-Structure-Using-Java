public class BubbleSort {
    
        
    public static int [] sort(int arr[]){
        int n = arr.length;
        boolean isSwapped;
        for(int i=0; i<n-1; i++){
            isSwapped=false;
            for(int j=0; j<n-1-i; j++){
                if(arr[j]>arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                    isSwapped=true;
                }
            }
            if(isSwapped==false){
                break;
            }
        }
        return arr;
    }
     public static void main(String[] args) {
       int arr[]={9,2,5,6,1};
       int []result = sort(arr); 
       for(int i=0; i<result.length; i++){
        System.out.print(result[i]+" ");
       }
    }
}

