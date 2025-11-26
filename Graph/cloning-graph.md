# Clone the Graph

https://leetcode.com/problems/clone-graph/description/?envType=problem-list-v2&envId=vk2ews95
```java
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        
        if(node==null){
            return null;
        }
        int start = node.val;
        Map<Integer, List<Integer>> map = getAdjMatrix(node);

        Set<Integer> keySet = map.keySet();
        Map<Integer, Node> copiedNodes = new HashMap<>();
        for(Integer key : keySet){
            Node n = new Node();
            n.val = key;
            n.neighbors = new ArrayList<Node>();
            copiedNodes.put(key , n);
        }
        int key = 0;
        Node n = null;
        for(Integer i :  keySet){
            key = i;
            n = copiedNodes.get(i);
            for(Integer nei : map.get(i)){
                n.neighbors.add(copiedNodes.get(nei));
            }

        }
        return copiedNodes.get(start);

    }

    /**
    
        key convert to node . 
        add key-node in a map . 

        follow the first map . 
        add the neibours to the second
    
     */

    

    public Map<Integer, List<Integer>> getAdjMatrix(Node node){

        Queue<Node> queue = new LinkedList<>(); 

        if(node!=null){
            queue.offer(node);
        }
        boolean [] visited = new boolean[100];
        Map<Integer, List<Integer>> map = new HashMap<>();
        while(!queue.isEmpty()){
            node = queue.poll();
            visited[node.val-1] = true;
            List<Integer> neiList = new ArrayList<>();
            for(Node nei : node.neighbors){
                
                if(visited[nei.val-1] == false){
                    queue.offer(nei);
                }
                neiList.add(nei.val);
            }
            map.put(node.val, neiList);
        }
        return map;
    }   
}
```

## Python 

