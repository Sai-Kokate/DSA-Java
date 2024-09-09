import java.util.*;

public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {

        
        // HashSet<List<Integer>> triplets = new HashSet<>();
        int n = nums.length;

        // Brute Force
        // for(int i=0; i<n-2; i++){
        //     for(int j=i+1; j<n-1; j++){
        //         for(int k=j+1; k<n; k++){
        //             if(nums[i]+nums[j]+nums[k]==0){
        //                 ArrayList<Integer> temp = new ArrayList<>();
        //                 temp.add(nums[i]);
        //                 temp.add(nums[j]);
        //                 temp.add(nums[k]);
                        
        //                 Collections.sort(temp);
        //                 triplets.add(temp);
        //             }
        //         }
        //     }
        // }

        // Better Approach

        // for(int i=0; i<n-1; i++){
        //     HashSet<Integer> hs = new HashSet<>();
        //     for(int j=i+1; j<n; j++){
        //         int third = -(nums[i]+nums[j]);

        //         // check if third exists in the hashset
        //         if(hs.contains(third)){
        //             ArrayList<Integer> temp = new ArrayList<>();
        //             temp.add(nums[i]);
        //             temp.add(nums[j]);
        //             temp.add(third);
                    
        //             Collections.sort(temp);
        //             triplets.add(temp);
        //         }

        //         // add nums[j] to hashset
        //         hs.add(nums[j]);
        //     }
        // }

        // Optimal Approach

        //  sort the array
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();


        for(int i=0; i<n; i++){
            if(i>0 && nums[i]==nums[i-1]) continue;

            int j = i+1;
            int k = n-1;

            

            while(j<k){
                int sum = nums[i] + nums[j] + nums[k];
                if(sum > 0){
                    k--;
                } else if (sum < 0) {
                    j++;
                } else {
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(nums[k]);
                    
                    // Collections.sort(temp);
                    ans.add(temp);

                    j++; k--;

                    while(j<k && nums[j-1]==nums[j]) j++;
                    while(j<k && nums[k+1]==nums[k]) k--;
                }
            }

        }

        // List<List<Integer>> ans = new ArrayList<>(triplets);
        return ans;
        
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        
        List<List<Integer>> ans = threeSum(nums);
        
        // Print the result
        for (List<Integer> triplet : ans) {
            System.out.print("[");
            for (int num : triplet) {
                System.out.print(num + " ");
            }
            System.out.print("] ");
        }
        System.out.println();
    }

}
