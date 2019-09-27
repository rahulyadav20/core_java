package com.semaphore;

public class Semaphore extends Thread{
	static int _semaphore; 
    static int _busy = 0; 
    static int _free = 1; 
    
    static 
    { 
        _semaphore = _free; 
    } 
    
    public static void main(String[] args) 
    { 
        for (int i = 0; i < 5; i++) 
            new Semaphore(i + 1).start(); 
    } 
    
    private int id; 
    
    public Semaphore(int id) 
    { 
        this.id = id; 
    } 
    
    public void run() 
    { 
        _wait(this.id);  

        // Critical section 
        
        try 
        { 
            System.out.println(this.id + ": doing something"); 
            Thread.sleep(3000); 
            System.out.println(this.id + ": unlock"); 
        } 
        catch (InterruptedException e) 
        { 
            e.printStackTrace(); 
        }  

        // End of critical section  
       
        _unlock(); 
    } 
    
    static void _wait(int id) 
    { 
        System.out.println(id + ": waiting"); 
        while(_semaphore != _free); 
        _semaphore = _busy; 
    } 
    
    static void _unlock() 
    { 
        _semaphore = _free; 
    } 

}
