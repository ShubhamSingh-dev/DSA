import java.util.*;
public class HashMapCode<K, V> {
    static class Node<K, V> {
        K key;
        V value;
        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private int n;
    private int N;
    private LinkedList<Node<K, V>> buckets[]; // N // this is similar to int arr[]
    
    @SuppressWarnings("unchecked")
    public HashMapCode() {
        this.N = 4;
        this.buckets = new LinkedList[4];
        for(int i = 0; i < 4; i++) {
            this.buckets[i] = new LinkedList<>(); //having a linkedlist in all buckets is necessary
        }
    }

    private int hashFunction(K key) {
        int hc = key.hashCode();
        return Math.abs(hc) % N;
    }

    private int searchInLinkedList(K key, int bucketIndex) {
        LinkedList<Node<K, V>> ll = this.buckets[bucketIndex];
        int dataIndex = 0;

        for(int i = 0; i < ll.size(); i++) {
            Node<K, V> node = ll.get(i);
            if(node.key.equals(key)) {
                return dataIndex;
            }
            dataIndex++;
        }
        return -1;
    }

    @SuppressWarnings("unchecked")
    private void rehash() {
        LinkedList<Node<K, V>> oldBuckets[] = buckets;
        buckets = new LinkedList[N * 2];
        N = 2 * N;
        for(int i = 0; i < buckets.length; i++) {
            buckets[i] = new LinkedList<>();
        }

        //nodes -> add in bucket
        for(int i = 0; i < oldBuckets.length; i++) {
            LinkedList<Node<K, V>> ll = oldBuckets[i];
            for(Node<K, V> node : ll) {
                put(node.key, node.value);
            }
        }
    }

    public void put(K key, V value) {
        int bucketIndex = this.hashFunction(key);
        int dataIndex = this.searchInLinkedList(key, bucketIndex);

        if(dataIndex != -1) {
            Node<K, V> node = buckets[bucketIndex].get(dataIndex);
            node.value = value;
        } else {
            buckets[bucketIndex].add(new Node<K, V>(key, value));
            n++;
        }
        
        double lambda = (double) n / N; 
        if(lambda > 2.0) {
            rehash();
        }
    }

    public boolean containsKey(K key) {
        int bucketIndex = hashFunction(key);
        int dataIndex = searchInLinkedList(key, bucketIndex);
         if(dataIndex != -1) {
          return true;
         } else {
          return false;
         }
    }

    

     public V remove(K key) {
        int bucketIndex = hashFunction(key);
        int dataIndex = searchInLinkedList(key, bucketIndex);
        
        if(dataIndex != -1) {
            Node<K, V> node = buckets[bucketIndex].remove(dataIndex);
            n--;
            return node.value;
        }
        return null;
    }

    public V get(K key) {
        int bucketIndex = hashFunction(key);
        int dataIndex = searchInLinkedList(key, bucketIndex);
        
        if(dataIndex != -1) {
            Node<K, V> node = buckets[bucketIndex].get(dataIndex);
            return node.value;
        }
        return null;
    }

    public ArrayList<K> keySet() {
        ArrayList<K> keys = new ArrayList<>();
        for(LinkedList<Node<K, V>> bucket : buckets) {
            for(Node<K, V> node : bucket) {
                keys.add(node.key);
            }
        }
        return keys;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public static void main(String args[]) {
        HashMapCode<String, Integer> hm = new HashMapCode<>();
        hm.put("India", 100);
        hm.put("USA", 200);
        hm.put("UK", 300);
        hm.put("Russia", 400);
        
        System.out.println(hm.get("India"));  // 100
        System.out.println(hm.containsKey("USA"));  // true
        System.out.println(hm.remove("UK"));  // 300
        System.out.println(hm.keySet());  // [India, USA, Russia] (order may vary)
    }
}