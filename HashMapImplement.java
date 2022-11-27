import java.util.ArrayList;
import java.util.LinkedList;
import java.util.*;
public class HashMapImplement
{
    static class HashMap<K,V>
    {
        private class Node
        {
            K key;
            V value;

            //constructor
            public Node(K key, V value)
            {
                this.key = key;
                this.value = value;
            }
        }

        private int n; //node size
        private int N; // list or arr size
        private LinkedList<Node> bucket[]; //N = buckets.lrngth


        @SuppressWarnings("unchecked")
        // constructor for changin null list into list Node
        public HashMap()
        {
            this.N = 4;
            this.bucket = new LinkedList[4];
            for(int i=0;i<4;i++)
            {
                this.bucket[i] = new LinkedList<>();
            }
        }

        


        private int hashFuntion(K key)
        {
            int bi = key.hashCode(); // it will change nd return any integer +ve nd -ve
            return Math.abs(bi)%N; // Math.abs--> change -ve into +ve value
        }

        private int searchInLL(K key, int bi)
        {
         LinkedList<Node> ll = bucket[bi];
         for(int i=0; i<ll.size();i++)
         {
            if(ll.get(i).key == key)
            {
                return i; // di -->i
            }
         }   
         return -1;
        }

        @SuppressWarnings("unchecked")
        private void rehash()
        {
            LinkedList<Node> oldBucket[] = bucket;
            bucket = new LinkedList[N*2];// increase size double of new bucket

            // node null index into linked list 
            for(int i=0;i<N*2;i++)
            {
                bucket[i] = new LinkedList<>();
            }

            for(int i=0;i<oldBucket.length;i++)
            {
                LinkedList<Node> ll = oldBucket[i];
                for(int j=0;j<ll.size();j++)
                {
                    Node node = ll.get(j);
                    put(node.key,node.value);
                }
            }
        }

        // put key and value 
        public void put(K key, V value)
        {
            int bi = hashFuntion(key); // bucket Index(bi)
            int di = searchInLL(key,bi);  // data index -- > -1 0rr 0

            if(di == -1)
            { // key does not exist
                bucket[bi].add(new Node(key,value));
                n++;
            }else{ // key exist
                Node node = bucket[bi].get(di);
                node.value = value;
            }

            double lambda = (double)n/N;
            if(lambda > 2.0) // 2 means threshold value --< k value
            {
                //rehashing
                rehash();
            }
        }

        // get fun.
        public V get(K key)
        {
            int bi = hashFuntion(key); // bucket Index(bi)
            int di = searchInLL(key,bi);  // data index -- > -1 0rr 0

            if(di == -1)
            { // key does not exist
                return null;
            }else{ // key exist
                Node node = bucket[bi].get(di);
                 return node.value;
            }
        }
        // key exit or not 
        public boolean contain(K key)
        {
            int bi = hashFuntion(key); // bucket Index(bi)
            int di = searchInLL(key,bi);  // data index -- > -1 0rr 0

            if(di == -1)
            { // key does not exist
                return false;
            }else{ // key exist
                return true;
            }
        }

        public V remove(K key)
        {
            int bi = hashFuntion(key); // bucket Index(bi)
            int di = searchInLL(key,bi);  // data index -- > -1 0rr 0

            if(di == -1)
            { // key does not exist
                return null;
            }else{ // key exist
                Node node = bucket[bi].remove(di);
                n--;
                return node.value;
            }
        }
        public ArrayList<K> keySet()
        {
            ArrayList<K> keys = new ArrayList<>();

            for(int i=0;i<bucket.length;i++){ // bi
                LinkedList<Node> ll = bucket[i];
                for(int j=0; j<ll.size();j++){//di
                    Node node = ll.get(j);
                    keys.add(node.key);
                }
            }
            return keys;
        }

        public boolean isEmpty()
        {
            return n==0;
        }
    }
        public static void main(String[] args) {
            HashMap<String, Integer> map = new HashMap<>();
            map.put("India",190);
            map.put("china",250);
            map.put("US",150);

            ArrayList<String> keys = map.keySet();
            for(int i=0;i<keys.size();i++){
                System.out.println(keys.get(i)+" "+map.get(keys.get(i)));
            }
            map.remove("India");
            System.out.println(map.get("India"));
        }
        
}
