import java.util.*;

class HelloWorld {
    
    public static boolean isSafe(int[][] arr,int x,int y,int n){
        if(x>=0 && y>=0 && x<n && y<n && arr[x][y]==1){
            return true;
        }
        return false;
    }
    
    public static boolean RatInMaze(int[][] arr,int x,int y,int n,int[][] solArr){
        if(x==n-1 && y==n-1){
            solArr[x][y]=1;
            return true;
        }
        
        if(isSafe(arr,x,y,n)){
            solArr[x][y]=1;
            if(RatInMaze(arr,x+1,y,n,solArr)){  //Checking bottom
                return true;
            }
            if(RatInMaze(arr,x,y+1,n,solArr)){  //Checking for right
                return true;
            }
            solArr[x][y]=0;  //not usefull so set it to 0.(BACKTRACKING)
            return false;
        }
        return false;  //Not safe, so it has 0 in its place.
    }
    public static void main(String[] args) {
        int n=4;
        Scanner sc=new Scanner(System.in);
        int arr[][]=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                arr[i][j]=sc.nextInt();
            }
        }
        int solArr[][]=new int[n][n];  //Output array
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                solArr[i][j]=0;
            }
        }
        
        RatInMaze(arr,0,0,n,solArr);
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(" "+solArr[i][j]+" ");
            }
            System.out.println();
        }
    }
}
