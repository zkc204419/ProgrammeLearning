package kai.chang.zhang.designpattern.compositepattern;

import java.util.ArrayList;

//���ģʽ
/*
 * ���ģʽ��Ϊ��ȫ���ģʽ��͸�����ģʽ���֣�
 * 1��͸�����ģʽ�У����󹹼�Component���������������ڹ����Ա����ķ���������add������remove�����Լ�getChild�����ȷ�����
 * 		�������ĺô�ʱȷ�����еĹ����඼����ͬ�Ľӿڣ��ڿͻ��˿�����Ҷ�Ӷ���������������ṩ�ķ���ʱһ�µģ��ͻ��˿�����ͬ�ĶԴ�����
 * 		�Ķ���
 * 2����ȫ���ģʽ�У��ڳ��󹹽�Component��û�������κ����ڹ����Ա����ķ�����������Composite��������ʵ������Щ������
 * 		�����������ǰ�ȫ�ģ���Ϊ��������Ҷ�Ӷ����ṩ��Щ�������ķ���������Ҷ�Ӷ��󣬿ͻ��˲����ܵ��õ���Щ������
 */
//���ģʽ�ı�׼��ʽ

abstract class Component{
	public abstract void add(Component c);
	public abstract void remove(Component c);
	public abstract Component getChild(int i);
	public abstract void operation();
}
//Ҷ�ӹ���
class Leaf extends Component{
	public void add(Component c) {
		//�쳣����
	}
	public void remove(Component c) {
		//�쳣����������ʾ
	}
	public Component getChild(int i) {
		//�쳣����������ʾ
		return null;
	}
	public void operation() {
		//Ҷ�ӹ�������ҵ�񷽷���ʵ��
	}
}

//��������
class Composite extends Component{
	private ArrayList<Component>list = new ArrayList<Component>();
	public void add(Component c){
		list.add(c);
	}
	public void remove(Component c) {
		list.remove(c);
	}
	public Component getChild(int i) {
		return (Component)list.get(i);
	}
	public void operation() {
		for(Object obj: list) {
			((Component)obj).operation();
		}
	}
}


public class CompositePattern {

}












