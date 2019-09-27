package com.factory.factoryMethod;

import com.factory.product.CheesePizza;
import com.factory.product.ClamPizza;
import com.factory.product.PIZZATYPE;
import com.factory.product.Pizza;
import com.factory.product.VeggiePizza;

public class ChicagoPizzaStore extends PizzaStore {

	public Pizza createPizza(PIZZATYPE type) {
		Pizza pizza = null;

		if (type.name().equals(PIZZATYPE.CHEESE.toString())) {
			pizza = new CheesePizza();
		} else if (type.name().equals(PIZZATYPE.PEPPERONI.toString())) {
			pizza = new CheesePizza();
		} else if (type.name().equals(PIZZATYPE.CLAM.toString())) {
			pizza = new ClamPizza();
		} else if (type.name().equals(PIZZATYPE.VEGGIE.toString())) {
			pizza = new VeggiePizza();
		}
		return pizza;
	}

}
