package kai.chang.zhang.designpattern.sample;

abstract class Product{
	
	//�򵥹���ģʽ�ļ򻯣����Խ�������Ĺ��������ϲ��������Ʒ����
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
	//����������ʵ��	
	}
	//��������ҵ�񷽷�
	public abstract void methodDiff();
}

class ConcreteProductA extends Product{
	public void methodDiff() {
		//����ҵ�񷽷���ʵ��
	}
}

class ConcreteProductB extends Product{
	public void methodDiff() {
		//����ҵ��ʵ�ֵķ���
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


