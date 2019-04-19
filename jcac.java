
/*
Name: Tawanda Muzanenhamo
Joint Call Admission Control
*/

import java.util.*;
import java.io.*;

public class jcac{
   
   public static void main(String [] args){
      state state;
      LinkedList<state> states = new LinkedList<state>();
      
      int C_1 = 20; // RAT-1 capacity
      int C_2 = 45; // RAT-2 capacity
      int b_1 = 2;  // basic bandwidth unit for RAT-1
      int b_2 = 3;  // basic bandwidth unit for RAT-2
      int T_11 = 10; // Threshold for RAT-1
      int T_21 =10;
      int T_22 = 20;
      int T_23 = 25;
      
      for (int m_11 = 0; m_11*b_1<T_11+1;m_11++){
         for(int n_11 = 0;n_11*b_1<C_1+1;n_11++){
            for(int m_12 = 0; m_12*b_1<T_21+1;m_12++){
               for(int n_12 = 0;n_12*b_1<T_22+1;n_12++){
                  for(int m_22 = 0; m_22*b_2<(T_23-T_22)+1;m_22++){
                     for (int n_22=0; n_22*b_2<(C_2-T_22)+1;n_22++){
                        if(((m_11+n_11)*b_1<=C_1)&&((m_12+n_12)*b_1<=T_22)&&((m_22+n_22)*b_2<=(C_2-T_22))){    
                           state = new state(m_11,n_11,m_12,n_12,m_22, n_22);
                           states.add(state);                     
                     }
                  }   

                  }
               }
            }
         }
      }
      System.out.println(states.size());
      
      //blocking probability for class-1
      int count_blocking_1 = 0;
      for(int i = 0; i< states.size();i++){
         if(((b_1 + states.get(i).m_11*b_1>T_11)||(b_1 + states.get(i).m_11*b_1 + states.get(i).n_11*b_1>C_1))&&((b_1 + states.get(i).m_12*b_1>T_21)||(b_1 + states.get(i).m_12*b_1 + states.get(i).n_12*b_1>T_22))){
            count_blocking_1++;
         }
      }
      System.out.println("blocking probability for class-1 "+(double)count_blocking_1/(double)states.size());
   
      //blocking probability for class-2
      int count_blocking_2 = 0;
      for(int i = 0; i< states.size();i++){
         if(((b_2 + states.get(i).m_22*b_2>(T_23-T_22))||(b_2 + states.get(i).m_22*b_2 + states.get(i).n_22*b_2>(C_2-T_22)))){
            count_blocking_2++;
         }
      }
      System.out.println("blocking probability for class-2 "+(double)count_blocking_2/(double)states.size());
      
      //dropping probability for class-1
      int count_dropping_1 = 0;
      for(int i = 0; i< states.size();i++){
         if((b_1 + states.get(i).m_11*b_1 + states.get(i).n_11*b_1>C_1)&&(b_1 + states.get(i).m_12*b_1 + states.get(i).n_12*b_1>T_22)){
            count_dropping_1++;
         }
      }
      System.out.println("dropping probability for class-1 " +(double)count_dropping_1/(double)states.size());

      //dropping probability for class-2       
      int count_dropping_2 = 0;
      for(int i = 0; i< states.size();i++){
         if(b_2 + states.get(i).m_22*b_2 + states.get(i).n_22*b_2>(C_2-T_22)){
            count_dropping_2++;
         }
      }
      System.out.println("dropping probability for class-2 "+(double)count_dropping_2/(double)states.size());      
   }
   
}