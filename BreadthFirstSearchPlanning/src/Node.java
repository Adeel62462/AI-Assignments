
public class Node {
    int state;
    int action;
    int cost;
    Node parent;
    
    public Node(int state, int action, int cost, Node parent) {
        this.state = state;
        this.action = action;
        this.cost = cost;
        this.parent = parent;
    }
    
}

//output printing
        
//        System.out.println();
//        System.out.println("States:  "+numOfStates);
//        System.out.println("Actions:  "+numOfActions);
//        System.out.println("Plans:  "+numOfProblems);
//        System.out.println();
//        for(int i=0;i<numOfStates;i++)
//            System.out.println(states.get(i));
//        System.out.println();
//        for(int i=0;i<numOfActions;i++)
//            System.out.println(actions.get(i));
//        System.out.println();
//        for(int i=0;i<numOfStates;i++){
//            for(int j=0;j<numOfActions;j++)
//                System.out.print(transitionTable[i][j]+" ");
//            System.out.println();
//        }
//        System.out.println();
//        for(int i=0;i<numOfProblems;i++)
//            System.out.println(problems.get(i));
//        System.out.println();
