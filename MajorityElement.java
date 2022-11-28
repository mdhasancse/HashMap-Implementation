import java.util.HashMap;
public class MajorityElement {
    public static void main(String[] args) {
        int[] arr = {2,2,1,1,1,2,2};
        HashMap<Integer,Integer> hmap = new HashMap<>();
        hmap.put(arr[0],1);
        int maxFrequency = 1;
        int maxElement = arr[0];

        for(int i=0;i<arr.length;i++)
        {
            boolean keyExisting = hmap.containsKey(arr[i]);
            if(keyExisting)
            {
                int existingFreq = hmap.get(arr[i]);
                hmap.put(arr[i],existingFreq+1);
            }else{
                hmap.put(arr[i], 1);
            }
            int freq = hmap.get(arr[i]);
            if(freq> maxFrequency)
            {
                maxFrequency = freq;
                maxElement = arr[i];
            }
        }
        int sizeofArray = arr.length;
        if(maxFrequency > (sizeofArray/2))
        {
            System.out.println(maxElement);
        }else{
            System.out.println("-1");
        }
    }
}
