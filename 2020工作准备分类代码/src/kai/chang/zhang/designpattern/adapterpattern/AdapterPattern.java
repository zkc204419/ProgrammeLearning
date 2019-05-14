package kai.chang.zhang.designpattern.adapterpattern;

//Target Ŀ������࣬Ŀ������ඨ���˿ͻ�����Ҫ�Ľӿڣ�������һ����������߽ӿڣ�Ҳ�����Ǿ�����
interface  Target{
	
}

//�������ࣺ����������Ե�����һ���ӿڣ���Ϊת��������Adapter��Target�������䣬�ڶ����������У���ͨ��
//�̳�Target������һ��Adaptee����ʹ���߲�����ϵ��
class Adapter implements Target{
	private Adaptee adaptee;
	public Adapter (Adaptee adaptee) {
		this.adaptee = adaptee;
	}
	public void request() {
		adaptee.specificRequest();
	}
}

//Adaptee�������࣬������Ľ�ɫ����������һ���Ѿ����ڵĽӿڣ�����ӿ���Ҫ���䣬��������һ����һ�������࣬�����ͻ�ϣ��ʹ�õ�ҵ��
//�߼���������ĳЩ����¿���û�����������Դ���롣
class Adaptee{
	public void specificRequest() {
		
	}
}

//��������ģʽ��ʵ������
//����java���Բ�֧�ֶ�̳У���˴����������ܵ��ܶ����ơ�
class Adapter_C extends Adaptee implements Target{
	public void request() {
		specificRequest();
	}
}

//˫��������������
//ȱʡ��������������ģʽ��һ�ֱ��壬��Ӧ��Ҳ�ȽϹ㷺��
/*
 * ȱʡ������ģʽ��������Ҫʵ��һ���ӿ����ṩ�����з���ʱ���������һ��������ʵ�ָýӿڣ���Ϊ�ӿ��е�ÿ�������ṩһ��Ĭ�ϵ�ʵ�֣�
 * ��ô�ó�������������ѡ���Եĸ��Ǹ����ĳЩ������ʵ�֡�Ҳ�Ƶ��ӿ�������ģʽ��
 */
//ServiceInterface()�������ӿ�
//AbstractServiceClass��ȱʡ�������ࣩ
//ConcreteServiceClass����ҵ����
