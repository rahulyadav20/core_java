package com.factory.factoryMethod;

import com.factory.product.PIZZATYPE;

public class Client {
	public static void main(String args[]){
		PizzaStore chicagoStore = new ChicagoPizzaStore();
		chicagoStore.orderPizza(PIZZATYPE.CHEESE);
		
		PizzaStore nyPizzaStore = new NYPizzaStore();
		nyPizzaStore.orderPizza(PIZZATYPE.VEGGIE);
	}

}
