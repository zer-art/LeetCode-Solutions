class Solution {
    private boolean candidate(long mid , int[] nums, int k){ 
        int kCount = 1 ; 
        long sum = 0 ; 
        for(int i : nums){ 
            if(i+sum <= mid ){ 
                sum+=i;
            }else{ 
                kCount +=1 ; 
                sum = i ; 
            }
        }

        return kCount <= k ; 
    }
    public int splitArray(int[] nums, int k) {
        if (k>nums.length) return -1 ; 
        long high = 0 ; 
        long low = 0 ;
        long res = 0 ; 
        for (int i : nums){ 
            high += i ; 
            if (i > low) low = i ; 
        }
        if (k == high ) return k ; 

        while ( low <= high){ 
            long mid = low + (high - low)/2; 
            if(candidate(mid,nums,k)){ 
                high = mid - 1 ; 
                res = mid ; 
            }else { 
                low = mid + 1 ; 
            }
        }

        return (int)res ; 
    }
}
