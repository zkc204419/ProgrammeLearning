package kai.chang.zhang.designpattern.Factory;

//��������ģʽ

interface Product{
	//��Ʒ�Ĺ�������
	public void methodSame();
	
}

interface Factory{
	public Product factoryMethod(); 
}

class ConcreteFactoryA implements Factory{
	//����Ĺ����������Զ�������
	//ͨ���ṩ��ͬ�Ĳ����б�ʵ������
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
		//ʵ�־����Ʒ����
	}
}

class ConcreteProductB implements Product{
	public void methodSame() {
		//ʵ�־���Ĳ�Ʒ����
	}
}









public class FactoryMethodPattern {

}
