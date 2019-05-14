package kai.chang.zhang.designpattern.prototypepattern;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;

//原型模式通用实现
interface Prototype {
	public void setAttr(String attr);
	public String getAttr();
}

class ConretePrototype implements Prototype,Cloneable{
	private String attr;
	public void setAttr(String attr) {
		this.attr = attr;
	}
	public String getAttr() {
		return this.attr;
	}
	public Prototype clone() {
		Prototype prototype = new ConretePrototype();
		prototype.setAttr(this.attr);
		return prototype;
	}
	
}

//java浅克隆代码实例
/*
 * 在浅克隆中，如果原型对象的成员变量是值类型，将复制一份给克隆对象；如果原型对象的成员变量是引用类型，则将引用对象的地址复制一份给克隆对象，
 * 也就是说原型对象和克隆对象的成员变量指向相同的地址。简单的说，在浅克隆中，当对象被复制时，只是复制它本身和其中包含的值类型成员变量，而引用
 * 类型的对象并没有复制。
 */
class A implements Cloneable{
	public A clone() {
		Object object = null;
		try {
			object = super.clone();
		}catch(CloneNotSupportedException exception) {
			System.out.println("Not support cloneable");
		}
		return (A) object;
	}
}

//java深拷贝的代码实例
class B implements Cloneable{
	public int age;
	public B clone() throws CloneNotSupportedException {
		
		return (B)super.clone();
	}
}
class AA implements Cloneable{
	public int id;
	public String name;
	public B b = new B();
	public AA(int id, String name) {
		this.id = id;
		this.name = name;
	}
	public AA clone() throws CloneNotSupportedException {
		AA a_clone = (AA)super.clone();
		a_clone.b = b.clone();
		return a_clone;
	}
}

//序列化实现深拷贝
//尽管这个方法很灵巧，但是，它通常会比显示的构建新对象并复制或克隆数据域的克隆方法慢的多。
class C implements Serializable{
	public int age;
}
class D implements Serializable{
	public int id;
	public String name;
	public C c = new C();
	public D(int id, String name) {
		this.id = id;
		this.name = name;
	}
	public D deepClone() throws IOException, ClassNotFoundException{
		ByteArrayOutputStream bao = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(bao);
		oos.writeObject(this);
		
		ByteArrayInputStream bis = new ByteArrayInputStream(bao.toByteArray());
		ObjectInputStream ois = new ObjectInputStream(bis);
		return (D)ois.readObject();
	}	
}

/*
 * 原型管理器时将多个原型对象存储在一个集合中共客户端使用，他是一个专门负责克隆对象的工厂，其中定义了一个集合用于存储原型对象，如果需要某个
 * 原型对象的一个克隆，可以通过复制集合中对应的原型对象来获得，在原型管理器中针对抽象原型类编程，以便扩展
 */
//实例：
//抽象公文接口，也可以定义为抽象类，提供clone()方法的实现，将业务方法声明为抽象方法

interface OfficialDocument extends Cloneable{
	public OfficialDocument clone();
}

class FAR implements OfficialDocument{
	public OfficialDocument clone() {
		OfficialDocument far = null;
		try {
			far = (OfficialDocument)super.clone();
		}catch(CloneNotSupportedException e) {
			System.out.println("不支持复制");
		}
		return far;
	}
}

class SRS implements OfficialDocument{
	public OfficialDocument clone() {
		OfficialDocument srs = null;
		try {
			srs = (OfficialDocument)super.clone();
		}catch(CloneNotSupportedException e) {
			System.out.println("不支持复制");
		}
		return srs;
	}
}

//原型管理器（使用饿汉单例实现）
class PrototypeManager{
	private HashMap<String,OfficialDocument> hp = new HashMap<>();
	private static PrototypeManager pm = new PrototypeManager();
	private PrototypeManager() {
		hp.put("far", new FAR());
		hp.put("srs", new SRS());
	}
	public void addOfficialDocument(String key, OfficialDocument doc) {
		hp.put(key, doc);
	}
	public OfficialDocument getOfficialDocument(String key) {
		return (OfficialDocument)hp.get(key).clone();
	}
	public static PrototypeManager getProtopeManager() {
		return pm;
	}
}

public class Prototypeclass {

}
