package kai.chang.zhang.designpattern.sample;

abstract class Product{
	
	//简单工厂模式的简化，可以将工厂类的工厂方法合并到抽象产品类中
	public static Product getProduct(String arg) {
		Product product = null;
		if(arg.equalsIgnoreCase("A")) {
			product = new ConcreteProductA();
		}
		else if(arg.equalsIgnoreCase("B")) {
			product = new ConcreteProductB();
		}
		return product;
	}
	
	public void methodSame() {
	//公共方法的实现	
	}
	//声明抽象业务方法
	public abstract void methodDiff();
}

class ConcreteProductA extends Product{
	public void methodDiff() {
		//具体业务方法的实现
	}
}

class ConcreteProductB extends Product{
	public void methodDiff() {
		//具体业务实现的方法
	}
}

class FactoryPattern {
	public static Product getProduct(String arg) {
		Product product = null;
		if(arg.equalsIgnoreCase("A")) {
			product = new ConcreteProductA();
		}
		else if(arg.equalsIgnoreCase("B")) {
			product = new ConcreteProductB();
		}
		return product;
	}
}

public class SampleFactoryPattern{
	public static void main(String args[]) {
		Product product;
		product = FactoryPattern.getProduct("A");
		product.methodDiff();
		product.methodSame();
	}
}


