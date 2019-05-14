package kai.chang.zhang.designpattern.singleton;

import java.util.HashMap;
import java.util.Map;


//һ�㵥��ģʽ,�ڶ��߳����������⣬���ܻᴴ�����ʵ������

class TaskManager{
	private static TaskManager tm = null;
	private TaskManager() {
		
	}
	public static TaskManager getInstance() {
		if (tm == null) {
			tm = new TaskManager();
		}
		return tm;
	}
}

//����ʽ�����ࡣ

class EagerSingleton{
	private static final EagerSingleton instance = new EagerSingleton();
	private EagerSingleton() {
		
	}
	public static EagerSingleton getInstance() {
		return instance;
	}
}

//����ʽ�����ࣨ˫�ؼ��������
//ʹ��˫����������ʵ������ʽ�����࣬��Ҫ�ھ�̬��Ա����instance֮ǰ�������η�volatile��
//������jdk1.5���ϰ汾�вſ�����ȷִ�У���volatile������java�����������һЩ�Ż����룬���ܻᵼ��ϵͳ����Ч�ʵ͡�

class LazySingleton{
	private volatile static LazySingleton instance = null;
	private LazySingleton() {
		
	}
	public static LazySingleton getInstance() {
		if(instance == null) {
			synchronized(LazySingleton.class) {
				if(instance == null) {
					instance = new LazySingleton();
				}
			}
		}
		return instance;
	}
}

//����ʽ�����಻��ʵ���ӳټ��أ����ܽ����ò��ã�ʼ��ռ���ڴ�;����ʽ�������̰߳�ȫ���Ʒ���������������Ӱ�졣

//Initialization Demand Holder(IoDH)����
//��IoDH�У������ڵ�����������һ����̬�ڲ��࣬�ڸ��ڲ����д������������ٽ��õ�������ͨ��getInstance�����������ظ��ⲿʹ�á�

class Singleton{
	private Singleton() {
		
	}
	
	private static class HolderClass{
		private final static Singleton instance = new Singleton();
	}
	
	public static Singleton getInstance() {
		return HolderClass.instance;
	}
}

//����ģʽ���ָ꣬��������ʵ������
class NumSingleton{
	private static int num = 1;
	private static final int MAX_NUM=3;
	private static Map<Integer,NumSingleton> catche = new HashMap<Integer,NumSingleton>();
	private int value = num;
	private NumSingleton() {};
	public static  NumSingleton getInstance() {
		NumSingleton t = catche.get(num);
		if(t==null) {
			t = new NumSingleton(); 
			catche.put(num, t);
		}
		num++;
		if(num > MAX_NUM) {
			num = 1;
		}
		return t;
	}
}



