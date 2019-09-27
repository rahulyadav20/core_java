package com.factory.simpleFactory;

import com.factory.product.CheesePizza;
import com.factory.product.ClamPizza;
import com.factory.product.PIZZATYPE;
import com.factory.product.Pizza;
import com.factory.product.VeggiePizza;

public class SimplePizzaFactory {	
	
	private SimplePizzaFactory(){}

	public Pizza createPizza(PIZZATYPE type) {
		Pizza pizza = null;

		if (type.name().equals(PIZZATYPE.CHEESE.toString())) {
			pizza = new CheesePizza();
		} else if (type.name().equals(PIZZATYPE.PEPPERONI)) {
			pizza = new CheesePizza();
		} else if (type.name().equals(PIZZATYPE.CLAM)) {
			pizza = new ClamPizza();
		} else if (type.name().equals(PIZZATYPE.VEGGIE)) {
			pizza = new VeggiePizza();
		}
		return pizza;
	}

	public static SimplePizzaFactory getInstance() {
		return new SimplePizzaFactory();
	}
}
