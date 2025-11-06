 # LRU Cache 

 ## If you want to push it in Distributed service , what to do . 

 1. Consistent hashing . - Use consistent hasing for each node with keys. 
 2. Distributed locking service - Use a distributed locking 
 3. Use a database to store the keys . 

```java
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

interface Cache {

    int get(int key); 

    void put(int key, int value);

}





 //        next
//.  start  -->  end 
//          <--
//.        prev


class LRUCache implements Cache{

    public int capacity;

    public Map<Integer, CacheObject> map = new ConcurrentHashMap<>();

    public CacheObject start;
    public CacheObject end;

    Lock lock = new ReentrantLock();

    static class CacheObject{
        int value;
        int key;
        CacheObject prev;
        CacheObject next;

        public CacheObject(int key , int value){
            this.key = key;
            this.value = value;
            this.prev = null;
            this.next = null;
        }
    }
    public LRUCache(int capacity){

        if(capacity < 1){
            // throw some exception 
        }

        this.capacity = capacity;
        start = new CacheObject(Integer.MIN_VALUE,Integer.MIN_VALUE);
        end = new CacheObject(Integer.MIN_VALUE,Integer.MIN_VALUE);
        start.next = end;
        end.prev = start;

        // Capacity can';t be 0
    }
    
    public int get(int key){
      
       if(!map.containsKey(key)) {
          return -1;
       }
       else{

          CacheObject obj = map.get(key);
          placeAtEnd(obj);

          return obj.value;

       }

    }
    private void placeAtEnd(CacheObject obj){

        lock.lock();

        CacheObject prev = obj.prev;
        CacheObject next = obj.next;

        prev.next = next;
        next.prev = prev;

        CacheObject endPrev = end.prev;
        endPrev.next = obj;
        obj.prev = endPrev;

        obj.next = end;
        end.prev = obj;
        lock.unlock();
    }

    private CacheObject evictFromStart(){

        lock.lock();
        CacheObject evicted = start.next;

        CacheObject next = evicted.next;

        start.next = next;
        next.prev = start;
        lock.unlock();
        return evicted;
    }

    // end is the most used , start is the least . 

    public void put(int key , int value){
        

        if(map.containsKey(key)){
            CacheObject obj = map.get(key);
            placeAtEnd(obj);
        }
        else {

            if(map.keySet().size() >= capacity){
                CacheObject evicted  = evictFromStart();
                System.out.println(evicted.key);
                map.remove(evicted.key);
            } 
            
            lock.lock();

            CacheObject obj = new CacheObject(key, value);
            CacheObject endPrev = end.prev;
            endPrev.next = obj;
            obj.prev = endPrev;
            obj.next = end;
            end.prev = obj;
            map.put(key, obj);
            lock.unlock();
        }
        
    }


    public void printNodes(){

        CacheObject node = start;

        while(node!=null){

            System.out.println(node.key + " "+node.value );
            node = node.next;
        }

    }
    

  
}

class Main{

    public static void main(String [] args){

        LRUCache lrucache = new LRUCache(5);
        // 1, 2,3,4,1,5,4,9
        lrucache.put(1, 1);
        lrucache.put(2, 2);
        lrucache.printNodes();
        lrucache.put(3, 3);
        lrucache.put(4, 4);
        lrucache.put(1, 1);
        lrucache.printNodes();
        lrucache.put(5,5);
        lrucache.printNodes();
        lrucache.put(4, 4);
         lrucache.printNodes();
        lrucache.put(9, 9); 

        System.out.println(lrucache.get(5));
         lrucache.printNodes();
    }


}

```
