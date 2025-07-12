class Solution {
    private int[] memo;
    private int n;

    private int getNextIndex(int[][] arr, int l, int currJobEnd){
        int r = n-1;
        int result = n+1;
        while(l<=r){
            int mid = l + (r-l)/2;
            if(arr[mid][0]>=currJobEnd){
                result = mid;
                r = mid-1;
            }else{
                l = mid+1;
            }
        }
        return result;
    }

    private int solve(int[][] arr,int i,int [] memo){
        if(i>=n){
            return 0;
        }

        if(memo[i]!=-1){
            return memo[i];
        }

        int next = getNextIndex(arr, i+1, arr[i][1]);
        int taken = arr[i][2] + solve(arr,next,memo);
        int notTaken = solve(arr, i+1,memo);

        return memo[i] = Math.max(taken, notTaken);
    }


    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        n = startTime.length;
        memo = new int[n];
        Arrays.fill(memo, -1);

        int[][] arr = new int[n][3];  //{s,e,p}

        for(int i=0; i<n; i++){
            arr[i][0]=startTime[i];
            arr[i][1]=endTime[i];
            arr[i][2]=profit[i];
        }

        Arrays.sort(arr, Comparator.comparingInt(row -> row[0]));

        return solve(arr,0,memo);
    }
}