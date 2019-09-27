package com.anonymous;

import static java.lang.System.out;  

public class Popcorn   
{   
    public void pop()   
    {   
        out.println("Ordinary popcorn");   
    }//end pop
 
       
    private void go()   
    {   
        Popcorn p = new Popcorn();   
        p.pop();   
        out.printf("p instanceof Popcorn: %b, p.getClass().getName(): %s%n",   
                p instanceof Popcorn, p.getClass().getName());   
        Popcorn pp = new Popcorn()   
        {   
            @Override  
            public void pop()   
            {   
                out.println("Extraordinary popcorn");   
            }//end pop method   
        };//end anonymous inner class   
        out.printf("pp instanceof Popcorn: %b, pp.getClass().getName(): %s%n",   
                pp instanceof Popcorn, pp.getClass().getName());   
        pp.pop();   
        Popcorn ppp = new Popcorn()   
        {   
            @Override  
            public void pop()   
            {   
                out.println("Much better popcorn");   
                testMe();
            }//end pop method   
            
            public void testMe(){
            	out.println("testMe");
            }
        };//end anonymous inner class   
        ppp.pop();
        
        out.printf("ppp instanceof Popcorn: %b, ppp.getClass().getName(): %s%n",   
                ppp instanceof Popcorn, ppp.getClass().getName());   
    }//end go   
       
    public static void main(String[] args)   
    {   
        new Popcorn().go();   
    }//end main   
}//end class  
