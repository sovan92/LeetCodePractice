public class JavaSolutioncharacterTrieSpellChecker {
    
    class Node{
        public HashMap<Character, Node> map ;
        public int noOfWords;

        public Node(HashMap<Character, Node> map , int noOfWords){
            this.map = map;
            this.noOfWords = noOfWords;
        }
    }
    
    public ArrayList<Integer> solve(ArrayList<String> A, ArrayList<String> B) {

        Node root = new Node(new HashMap<Character, Node>(), 0);
        Node node = root;
        
        for(String word :  A){
            insert(word,node,0);
        }
        
        ArrayList<Integer> retList = new ArrayList<>();

        for(String word : B){

            if(isPresent(node, 0, word)){
                retList.add(1);
            }
            else{
                retList.add(0);
            }

        }
        return retList;
    
    }
    public void insert(String word, Node node , int curr){
        
        if(curr == word.length()){
            node.noOfWords++;
            return;
        }
        char c = word.charAt(curr);
        node.map.putIfAbsent(c,  new Node(new HashMap<Character, Node>(), 0));
        Node nextNode = node.map.get(c);
        insert(word, nextNode, curr+1);
    }

    public boolean isPresent(Node root, int curr, String word){

        if(curr == word.length()){
            return (root.noOfWords == 0) ? false:true;
        }
        char c = word.charAt(curr);
        if (root.map.containsKey(c)){
            return isPresent(root.map.get(c), curr+1, word);
        }   
        else{
            return false;
        }
    }




}
