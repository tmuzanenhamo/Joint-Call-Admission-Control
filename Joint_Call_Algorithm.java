/**
Joint Call Admission Control Algorithm for Heterogenous Networks.
**/

import java.util.ArrayList;
import java.util.*;

public class Joint_Call_Algorithm{
   public static void main(String[] args){
   
   //Network specifications
   int c1 = 100; //RAT1 Capacity
   int c2 = 100; //RAT2 Capacity
   int t1 = 20; //RAT1 Threshold
   int t2 = 20; //RAT2 Threshold
   
   //basic bandwidth unit
   
   int bbu = 1;
   
   // Blocking and Dropping States Constants
   int admissible_states = 0;
   int class_A_newcall_blockingstate = 0;
   int class_A_handoff_droppingngstate = 0;
   int class_B_handoff_droppingstate = 0;
   int class_B_newcall_blockingstate = 0;
   
   ArrayList<ArrayList> admissable = new ArrayList<>();
   
   for (int m1 = 0; m1<t1+1; m1++ ){
       ArrayList<Integer> t = new ArrayList<>();
      for(int n1 =0; n1<c1+1; n1++){
         for(int m2 = 0; m2<t2+1; m2++){
            for(int n2 = 0; n2<c2+1; n2++){
            if((m1 + n1 > c1) || (m2 + n2 > c2)){
                  break;
             }
             //Calculating the Blocking states 
             if((bbu+bbu*(m1+n1)) > c1) class_A_handoff_droppingngstate++;
             if((bbu+bbu*(m1+n1))> t1) class_A_newcall_blockingstate++;
             if((bbu+bbu*(m1+n1) > c1) && (bbu+bbu*(m2+n2) > c2 )) class_B_handoff_droppingstate++;
             if((bbu+bbu*( m1+n1) > t1) && (bbu+bbu*(m2+n2) > t2)) class_B_newcall_blockingstate++;
             t.add(m1);
             t.add(n1);
             t.add(m2);
             t.add(n2);
             admissible_states ++;
                           
            }
         
         }
      }
      admissable.add(t);
      
   
   } 
   
   //printing the admissible states
   
   ArrayList<Integer> admissible_state = new ArrayList();
   for(ArrayList admissible_ : admissable){
            for(int i = 0; i <= admissible_.size()-1; i+=4){
                admissible_state.add((int)admissible_.get(i));
                admissible_state.add((int)admissible_.get(i+1));
                admissible_state.add((int)admissible_.get(i+2));
                admissible_state.add((int)admissible_.get(i+3));
                System.out.print(admissible_state.toString()+" ");
                admissible_state.clear();
            }
            System.out.println();
        }
    System.out.println("****************************************************************************");    
    //Admissible state calculated value
    // Blocking and Dropping States Calculated Values
    System.out.println("Number of Admissable States :"+ admissible_states);
    System.out.println("Number of Blocking States for Class A Handoff Calls :"+ class_A_handoff_droppingngstate);
    System.out.println("Number of Blocking States for Class A  New Calls :"+ class_A_newcall_blockingstate);
    System.out.println("Number of Blocking States for Class B Handoff Calls :"+ class_B_handoff_droppingstate);
    System.out.println("Number of Blocking States for Class B New Calls  :"+ class_B_newcall_blockingstate);
    System.out.println("****************************************************************************");
   
   // Calculating Probabilities 
    double Handoff_probA = (double)(class_A_handoff_droppingngstate)/(double)(admissible_states);
   // System.out.println(admissible_states);
    //System.out.println(class_A_handoff_droppingngstate);
    //System.out.println((double)class_A_handoff_droppingngstate/(double)admissible_states);
    double Newcall_probA = (double)class_A_newcall_blockingstate/(double)admissible_states;
    double Handoff_probB = (double)class_B_handoff_droppingstate/(double)admissible_states;
    double Newcall_probB = (double)class_B_newcall_blockingstate/(double)admissible_states;
    System.out.println("****************************************************************************");
    System.out.println("Blocking probability for class A HandoffCalls :"+ Handoff_probA);
    System.out.println("Blocking probability for Class A NewCalls :"+ Newcall_probA);
    System.out.println("Blocking probability for Class B HandoffCalls :"+ Handoff_probB);
    System.out.println("Blocking Probability for Class B NewCalls  :"+ Newcall_probB);
    System.out.println("****************************************************************************");
    
   
   
   
   
   
   
   
   
   
   }


}