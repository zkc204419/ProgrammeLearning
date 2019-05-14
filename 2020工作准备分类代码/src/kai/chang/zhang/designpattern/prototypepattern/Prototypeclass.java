package kai.chang.zhang.designpattern.prototypepattern;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;

//ԭ��ģʽͨ��ʵ��
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

//javaǳ��¡����ʵ��
/*
 * ��ǳ��¡�У����ԭ�Ͷ���ĳ�Ա������ֵ���ͣ�������һ�ݸ���¡�������ԭ�Ͷ���ĳ�Ա�������������ͣ������ö���ĵ�ַ����һ�ݸ���¡����
 * Ҳ����˵ԭ�Ͷ���Ϳ�¡����ĳ�Ա����ָ����ͬ�ĵ�ַ���򵥵�˵����ǳ��¡�У������󱻸���ʱ��ֻ�Ǹ�������������а�����ֵ���ͳ�Ա������������
 * ���͵Ķ���û�и��ơ�
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

//java����Ĵ���ʵ��
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

//���л�ʵ�����
//����������������ɣ����ǣ���ͨ�������ʾ�Ĺ����¶��󲢸��ƻ��¡������Ŀ�¡�������Ķࡣ
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
 * ԭ�͹�����ʱ�����ԭ�Ͷ���洢��һ�������й��ͻ���ʹ�ã�����һ��ר�Ÿ����¡����Ĺ��������ж�����һ���������ڴ洢ԭ�Ͷ��������Ҫĳ��
 * ԭ�Ͷ����һ����¡������ͨ�����Ƽ����ж�Ӧ��ԭ�Ͷ�������ã���ԭ�͹���������Գ���ԭ�����̣��Ա���չ
 */
//ʵ����
//�����Ľӿڣ�Ҳ���Զ���Ϊ�����࣬�ṩclone()������ʵ�֣���ҵ�񷽷�����Ϊ���󷽷�

interface OfficialDocument extends Cloneable{
	public OfficialDocument clone();
}

class FAR implements OfficialDocument{
	public OfficialDocument clone() {
		OfficialDocument far = null;
		try {
			far = (OfficialDocument)super.clone();
		}catch(CloneNotSupportedException e) {
			System.out.println("��֧�ָ���");
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
			System.out.println("��֧�ָ���");
		}
		return srs;
	}
}

//ԭ�͹�������ʹ�ö�������ʵ�֣�
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
