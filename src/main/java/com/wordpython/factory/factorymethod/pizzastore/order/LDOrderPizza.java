package com.wordpython.factory.factorymethod.pizzastore.order;

import com.wordpython.factory.factorymethod.pizzastore.pizza.BJCheesePizza;
import com.wordpython.factory.factorymethod.pizzastore.pizza.BJPepperPizza;
import com.wordpython.factory.factorymethod.pizzastore.pizza.LDCheesePizza;
import com.wordpython.factory.factorymethod.pizzastore.pizza.LDPepperPizza;
import com.wordpython.factory.factorymethod.pizzastore.pizza.Pizza;

//工厂子类
public class LDOrderPizza extends OrderPizza {

    @Override
    Pizza createPizza(String orderType) {

        Pizza pizza = null;
        if (orderType.equals("cheese")) {
            pizza = new LDCheesePizza();
        } else if (orderType.equals("pepper")) {
            pizza = new LDPepperPizza();
        }
        // TODO Auto-generated method stub
        return pizza;
    }

}
