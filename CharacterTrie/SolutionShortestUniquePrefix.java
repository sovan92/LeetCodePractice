public class Solution {
    
    class Node {

        public HashMap<Character, Node> map;
        public int prefixCount;

        public Node(HashMap<Character, Node> map, int prefixCount){
            this.map = map;
            this.prefixCount = prefixCount;
        }
    }
    
    public ArrayList<String> prefix(ArrayList<String> A) {

        Node root = new Node(new HashMap<>(), A.size());

        for(String word: A){
            insert(root, word, 0);
        }
        ArrayList<String> retList = new ArrayList<>();

        for(String word: A){
            StringBuilder builder = new StringBuilder();
            getPrefix(root, word, builder, 0);
            retList.add(builder.toString());
        }
        return retList;
    }
    public void insert(Node root, String word, int curr){

        if(curr == word.length()){
            return;
        }
        char c = word.charAt(curr);
        
        if(!root.map.containsKey(c)){
            root.map.put(c, new Node(new HashMap<Character, Node>(), 0));
        }
        Node nextNode = root.map.get(c);
        nextNode.prefixCount++;
        insert(nextNode, word, curr+1);
    }
    
    public void getPrefix(Node root, String word, StringBuilder prefix, int curr){

        if(curr == word.length() || root.prefixCount==1){
            return;
        }
        
        char c = word.charAt(curr);

        if (!root.map.containsKey(c)){
            return;
        }
        else {
            prefix.append(c);
            getPrefix(root.map.get(c), word, prefix, curr+1);
        }

    }

}
