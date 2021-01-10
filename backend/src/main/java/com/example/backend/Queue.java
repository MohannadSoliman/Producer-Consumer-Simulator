package com.example.backend;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Queue {
	BlockingQueue<Product> allProducts = new LinkedBlockingQueue<Product>();
	boolean isEndQueue=false;
	private int ID;

	/*Queues have no brain, they just store and give products when they are called to 
	no need to initialize a timer for Queues as Machines does all the work for them
	the onyl Queue that needs a timer is queue0 as it receives products as input rate and this function should be 
	initialized in the simulator***/
	public void setID(int ID){
		this.ID = ID;
	}
	public int getID(){
		return this.ID;
	}
	public Queue(boolean isEndQueue, int ID){
		this.ID = ID;
		this.isEndQueue=isEndQueue;
	}
    public Product sendProduct(){
        try {
			return allProducts.take();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        return null;
    }
    public void receiveProduct(Product product){
        try {
			allProducts.put(product);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if(isEndQueue){
			Simulator.getInstance().addFinishedProduct();
		}
    }
}
