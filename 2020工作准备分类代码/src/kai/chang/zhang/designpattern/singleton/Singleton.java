package kai.chang.zhang.designpattern.singleton;

import java.util.HashMap;
import java.util.Map;


//一般单例模式,在多线程里会出现问题，可能会创建多个实例对象

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

//饿汉式单例类。

class EagerSingleton{
	private static final EagerSingleton instance = new EagerSingleton();
	private EagerSingleton() {
		
	}
	public static EagerSingleton getInstance() {
		return instance;
	}
}

//懒汉式单例类（双重检查锁定）
//使用双层检查锁定来实现懒汉式单例类，需要在静态成员变量instance之前增加修饰符volatile，
//并且在jdk1.5以上版本中才可以正确执行，单volatile会屏蔽java虚拟机所作的一些优化代码，可能会导致系统运行效率低。

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

//饿汉式单例类不能实现延迟加载，不管将来用不用，始终占据内存;懒汉式单例类线程安全控制繁琐，而且性能受影响。

//Initialization Demand Holder(IoDH)技术
//在IoDH中，我们在单例类中增加一个静态内部类，在该内部类中创建单例对象，再将该单例对象通过getInstance（）方法返回给外部使用。

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

//单例模式延申，指定数量的实例对象
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



