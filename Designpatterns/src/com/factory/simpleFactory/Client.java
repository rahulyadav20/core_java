package com.factory.simpleFactory;

import com.factory.product.PIZZATYPE;
import com.factory.product.Pizza;

public class Client {
	public static void main(String args[]){
		SimplePizzaFactory factory = SimplePizzaFactory.getInstance();
		PizzaStore store = new PizzaStore(factory);
		Pizza pizza = store.orderPizza(PIZZATYPE.CHEESE);
		
			System.out.println(pizza);
	}

}
