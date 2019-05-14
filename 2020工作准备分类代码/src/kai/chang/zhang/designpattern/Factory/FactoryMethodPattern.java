package kai.chang.zhang.designpattern.Factory;

//工厂方法模式

interface Product{
	//产品的公共方法
	public void methodSame();
	
}

interface Factory{
	public Product factoryMethod(); 
}

class ConcreteFactoryA implements Factory{
	//这里的工厂方法可以定义多个，
	//通过提供不同的参数列表实现重载
	public Product factoryMethod() {
		return new ConcreteProductA();
	}
}

class ConcreteFactoryB implements Factory{
	public Product factoryMethod() {
		return new ConcreteProductB();
	}
}

class ConcreteProductA implements Product{
	public void methodSame() {
		//实现具体产品方法
	}
}

class ConcreteProductB implements Product{
	public void methodSame() {
		//实现具体的产品方法
	}
}









public class FactoryMethodPattern {

}
