package kai.chang.zhang.designpattern.compositepattern;

import java.util.ArrayList;

//组合模式
/*
 * 组合模式分为安全组合模式，透明组合模式两种，
 * 1、透明组合模式中，抽象构件Component中声明了所有用于管理成员对象的方法，包括add（），remove（）以及getChild（）等方法，
 * 		这样做的好处时确保所有的构建类都有相同的接口，在客户端看来，叶子对象和容器对象所提供的方法时一致的，客户端可以相同的对待所有
 * 		的对象。
 * 2、安全组合模式中，在抽象构建Component中没有声明任何用于管理成员对象的方法，而是在Composite中声明并实现了这些方法。
 * 		这样的做法是安全的，因为根本不向叶子对象提供这些管理对象的方法，对于叶子对象，客户端不可能调用到这些方法。
 */
//组合模式的标准形式

abstract class Component{
	public abstract void add(Component c);
	public abstract void remove(Component c);
	public abstract Component getChild(int i);
	public abstract void operation();
}
//叶子构件
class Leaf extends Component{
	public void add(Component c) {
		//异常处理
	}
	public void remove(Component c) {
		//异常处理或错误提示
	}
	public Component getChild(int i) {
		//异常处理或错误提示
		return null;
	}
	public void operation() {
		//叶子构建具体业务方法的实现
	}
}

//容器构件
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












