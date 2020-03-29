import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

public class Processing {
    int numOfStates;
    int numOfActions;
    int numOfProblems;
    ArrayList<String> states = new ArrayList<>();
    ArrayList<String> actions = new ArrayList<>();
    int[][] transitionTable;
    ArrayList<String> problems = new ArrayList<>();
    Node goal;
    
    public int getState(String arg){
        for(int i=0;i<states.size();i++){
            if(states.get(i).equals(arg))
                return i;
        }
        return -1;
    }
    
    public boolean goalTest(Node temp){
        if(temp.state==goal.state)
            return true;
        return false;
    }
    
    public String getAction(int index){
        return actions.get(index);
    }
    
    public void input(){
        Scanner input = new Scanner(System.in);
        
        //Taking M & N & T
        numOfStates = input.nextInt();
        numOfActions = input.nextInt();
        numOfProblems = input.nextInt();
        //Ignoring Line
        input.skip("\n\n");
        //Taking input states
        for(int i=0;i<numOfStates;i++)
            states.add(input.nextLine());
        
        //Ignoring Line
        input.skip("\n");
        //Taking input actions
        for(int i=0;i<numOfActions;i++)
            actions.add(input.nextLine());
        
        //Ignoring Line
        input.skip("\n");
        //Taking input of transition table
        transitionTable = new int[numOfStates][numOfActions];
        for(int i=0;i<numOfStates;i++){
            for(int j=0;j<numOfActions;j++)
                transitionTable[i][j]=input.nextInt();
        }
        
        //Ignoring Line
        input.skip("\n\n");
        for(int i=0;i<numOfProblems;i++)
            problems.add(input.nextLine());
    }
    
    public void start(){
        input();
        
        System.out.println("\n=> SOLUTIONS <=");
        
        for(int i=0; i<problems.size(); i++){
            String[] problemStates = problems.get(i).split("\t");
            Node root = new Node(getState(problemStates[0]), -1, 0, null);
            goal = new Node(getState(problemStates[1]), -1, 0, null);
            
            Queue<Node> frontier = new LinkedList<>();
            
            Set<Integer> exploredSet = new HashSet<>();
            
            frontier.add(root);
            
            if(goalTest(frontier.peek()))
                System.out.println("=> Starting state is the goal state!");
            
            else{
                while(!frontier.isEmpty()&&!goalTest(frontier.peek())){
                    Node temp = frontier.poll();
                    exploredSet.add(temp.state);
                    for(int j=0;j<actions.size();j++){
                        Node child = new Node(transitionTable[temp.state][j], j, temp.cost++, temp);
                        if(!exploredSet.contains(child.state))
                            frontier.add(child);
                    }
                }
                goal = frontier.poll();
                if(goal==null)
                    System.out.println("=> NO Plan exists for this problem!");
                else{
                    Stack<Node> stack = new Stack<>();
                    while(goal.parent!=null){
                        stack.push(goal);
                        goal=goal.parent;
                    }
                    while(!stack.empty()){
                        System.out.print(getAction(stack.pop().action));
                        if(!stack.isEmpty())
                            System.out.print("->");
                    }
                    System.out.println();
                    stack.clear();
                }
            }
            frontier.clear();
            exploredSet.clear();
        }
        System.out.println();
        states.clear();
        actions.clear();
        problems.clear();
    }
}
