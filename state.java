/*
Name: Tawanda Muzanenhamo
Joint Call Admission Control
*/

import java.util.*;
import java.io.*;

public class state{
   int m_11; // new class 1 calls in rat1
   int n_11; // handoff calls in rat1
   
   int m_12; //  new class 1 calls in rat 2 
   int n_12; // handoff calls in rat 2
   
   int n_21; // new class 2 calls in rat 1
  // int m_22; // handpff cca;;s in rat 1
   
   int m_22; // new class 2 calls in rat 2
   int n_22; // handoff calls in rat 2
  
   
   public state(int m_11, int n_11, int m_12, int n_12, int m_22, int n_22){
      this.m_11 =m_11;
      this.n_11 = m_11;
      this.m_12 = m_12;
      this.n_12 = n_12;
      this.m_22 = m_22;
      this.n_22 = n_22;
   }

}