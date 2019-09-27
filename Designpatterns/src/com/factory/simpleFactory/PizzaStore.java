package com.factory.simpleFactory;

import com.factory.product.PIZZATYPE;
import com.factory.product.Pizza;


public class PizzaStore {
	
	SimplePizzaFactory pizzaFactory;
	
	public PizzaStore(SimplePizzaFactory pizzaFactory){
		this.pizzaFactory = pizzaFactory;
	}

	
	public Pizza orderPizza(PIZZATYPE type){
		Pizza pizza = pizzaFactory.createPizza(type);
		pizza.prepare();
		pizza.bake();
		pizza.cut();
		pizza.box();
		return pizza;
	}
}
