
public class ContainDuplicate
{
    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        int k = 3;
        System.out.println(containsNearbyDuplicate(nums,k));
        // int[] nums = {1,2,3,1,2,3};
        // int k=2;
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        
        // In first integer will store the elements and next integer will store index 
       if (k == 0)
           return false;

        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int integer = nums[i];
            if (hashMap.containsKey(integer) && i - hashMap.get(integer) <= k)
                return true;
            hashMap.put(integer, i);
        }
        return false;
    }
}