public class TowersOfHannoiSolution {
    public ArrayList<ArrayList<Integer>> towerOfHanoi(int A) {

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        recurseSolve(A, 1,3,2,result);

        return result;


    }
  public void recurseSolve(int noOfDisks , int source, int destination, int middle , ArrayList<ArrayList<Integer>> result){

        ArrayList<Integer> a = null;
        // Move single disk from source to destination
        if(noOfDisks == 1){
            a = new ArrayList();
            a.add(noOfDisks);
            a.add(source);
            a.add(destination);
            result.add(a);
            return;
        }

        // Move n-1 previous disks from source to middle via destination. 
        recurseSolve(noOfDisks-1,source,middle,destination, result);


        // Move nth disk from source to dstination. 
        a = new ArrayList();
        a.add(noOfDisks);
        a.add(source);
        a.add(destination);
        result.add(a);


        // Move n-1 disks from middle to destination via source. 
        recurseSolve(noOfDisks-1,middle,destination,source, result);


    }
}
