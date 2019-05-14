package kai.chang.zhang.designpattern.Abstract;

//抽象工厂模式

//抽象工厂方法用于创建不同类型的产品
abstract class AbstractFactory{
	public abstract AbstractProductA createProductA();
	public abstract AbstractProductB createProductB();
}

//具体工厂生产一个产品族对象
class ConcreteFactory1 extends AbstractFactory{
	public  AbstractProductA createProductA() {
		return new ConcreteProductA1();
	}
	
	public AbstractProductB createProductB() {
		return new ConcreteProductB1();
	}
}

//产品对象接口
interface AbstractProductA{
	
}

class ConcreteProductA1 implements AbstractProductA{
	
}

//产品对象接口
interface AbstractProductB{
	
}

class ConcreteProductB1 implements AbstractProductB{
	
}

public class AbstractFactoryPattern {

}
