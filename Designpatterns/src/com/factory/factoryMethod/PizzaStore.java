package com.factory.factoryMethod;

import com.factory.product.PIZZATYPE;
import com.factory.product.Pizza;

abstract public class PizzaStore {

	public Pizza orderPizza(PIZZATYPE type) {
		Pizza pizza = createPizza(type);
		pizza.prepare();
		pizza.bake();
		pizza.cut();
		pizza.box();
		return pizza;
	}

	protected abstract Pizza createPizza(PIZZATYPE type); //FactoryMethod

}
