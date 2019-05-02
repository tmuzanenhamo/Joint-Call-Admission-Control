import math

def new_call(c1,c2,t1,bbu,t2,y):
    
    states = 0
    Ab = 0
    Ad = 0
    Bb = 0
    bd = 0
    
    n1 = 0
    n2 = 0
    m1 = 0
    m2 = 0
    
    dep = 1
    
    loading_new = y/dep
    loading_hand = 0.6*loading_new
    
    Prob = 0
    Prob_in = 0
    Prob_im = 0
    G = 0
    Blocking_probability_A =0
    Dropping_probability_A =0
    Blocking_probability_B =0
    Dropping_probability_B =0
    
    for n1 in range(0,t1+1):
        for m1 in range(0,c1+1):
            for n2 in range(0,t2+1):
                for m2 in range(0,c2+1):
                    
                    ad_states = (((n1+m1)*bbu<= c1) and (n1*bbu<=t1) and ((n2+m2)*bbu <=c2) and (n2*bbu<=t2))
                    
                    blocking_state = (bbu + bbu*(n1+m1) > t1) and (bbu + bbu*(n2+m2)>t2)
                    dropping_state = (bbu +  bbu*(n1+m1) > c1) and (bbu + bbu*(n2+m2)>c2)
                    
                    if(ad_states):
                        states = states+1
                        e= loading_new**(n1+n2)
                        f= loading_new**(m1+m2)
                        Prob_in = e*f
                        a = math.factorial(n1)
                        b = math.factorial(m1)
                        c = math.factorial(n2)
                        d = math.factorial(m2)
                        
                        Prob_im = a*b*c*d
                        
                        Prob = (Prob_in)/(Prob_im)
                        #nomalization factor
                        G = G + Prob
                        
                        if(blocking_state):
                            Bb = Bb+1
                            Blocking_probability_B = Blocking_probability_B + Prob
                            
                        if(dropping_state):
                            
                            Bd = Bd = 1
                            
                            Dropping_probability_B = Dropping_probability_B + Prob
                            
                        if (bbu+(n1+m1)*bbu >t1):
                            Ab = Ab+1
                            Blocking_probability_A = Blocking_probability_A + Prob
                            
                        if (bbu + (n1+m1)*bbu >c1):
                            Ad =Ad+1
                            Dropping_probability_A = Dropping_probability_A + Prob
    print("The new call blocking probability for A is: ",Blocking_probability_A/G) 
    print("The handoff call dropping probability for A is: ",Dropping_probability_A/G)
    print("The new call blocking probability for B is: ", Blocking_probability_B/G )
    print("The handoff call dropping probability for B is: ", Dropping_probability_B/G )
    
    return Blocking_probability_A/G, Blocking_probability_B/G,    Dropping_probability_A/G,    Dropping_probability_B/G 
   # print("Tawanda")



                
arr= []
Blocking_probability_A = []
Blocking_probability_B = []
Dropping_probability_A = []
Dropping_probability_B = []



   
for y in range(1,7):
    c1 = 20
    c2 = 20
    t1 = int(10)
    t2 = int(10)
    bbu = 1
    
    Blocking_probability_A1,Dropping_probability_A1,Blocking_probability_B1,Dropping_probability_B1 = new_call(c1,c2,t1,t2,bbu,y)
    Blocking_probability_A.append(Blocking_probability_A1)
    Blocking_probability_B.append(Blocking_probability_B1)
    Dropping_probability_A.append(Dropping_probability_A1)
    Dropping_probability_B.append(Dropping_probability_B1)
    arr.append(y)
    
    
    
    
    
    
        
                
                            
    