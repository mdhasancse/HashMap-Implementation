import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
    public static void main(String[] args) {
        System.out.println(isHappy(19));
        System.out.println(isHappy(29));
        
    }

    public static boolean isHappy(int n) {
        Set<Integer> hashtable = new HashSet<>();
        while(true)
        {   
            // sum of square
            int sum = 0;
            while(n != 0)
            {
                sum += Math.pow(n % 10, 2.0);
                n = n/10;
            }
                // if sum is 1 return true
                if(sum == 1)
                    return true;
                
                // else, the new number is the current sum
                n = sum;
                    
                // check if we have already encountered that number in hashtable
                if(hashtable.contains(n))
                    return false;
                hashtable.add(n);
            
        }
    }
}
