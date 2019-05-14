package kai.chang.zhang.designpattern.Abstract;

//���󹤳�ģʽ

//���󹤳��������ڴ�����ͬ���͵Ĳ�Ʒ
abstract class AbstractFactory{
	public abstract AbstractProductA createProductA();
	public abstract AbstractProductB createProductB();
}

//���幤������һ����Ʒ�����
class ConcreteFactory1 extends AbstractFactory{
	public  AbstractProductA createProductA() {
		return new ConcreteProductA1();
	}
	
	public AbstractProductB createProductB() {
		return new ConcreteProductB1();
	}
}

//��Ʒ����ӿ�
interface AbstractProductA{
	
}

class ConcreteProductA1 implements AbstractProductA{
	
}

//��Ʒ����ӿ�
interface AbstractProductB{
	
}

class ConcreteProductB1 implements AbstractProductB{
	
}

public class AbstractFactoryPattern {

}
