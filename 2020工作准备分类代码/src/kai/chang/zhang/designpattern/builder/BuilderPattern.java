package kai.chang.zhang.designpattern.builder;

//������ģʽ
//�����Ʒ�ĸ�������
class Product{
	private String PartA;
	private String PartB;
	private String PartC;
}

//�ڳ����������ж����˲�Ʒ�Ĵ��������ͷ��ط���
abstract class Builder{
	protected Product product =  new Product();
	public abstract void buildPartA();
	public abstract void buildPartB();
	public abstract void buildPartC();
	public Product getResult() {
		return product;
	}
}

//ָ���ߣ�һ�����������˿ͻ��봴�����̣���һ���������Ʋ�Ʒ�Ĵ������̣�
class Director{
	private Builder builder;
	public Director(Builder builder) {
		this.builder = builder;
	}
	public void setBuilder(Builder builder) {
		this.builder = builder;
	}
	public Product construct() {
		builder.buildPartA();
		builder.buildPartB();
		builder.buildPartC();
		return builder.getResult();
	}
}

//ʵ�� Actor������帴�Ӳ�Ʒ
class Actor{
	private String type;
	private String sex;
	private String face;
	private String haistyle;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getFace() {
		return face;
	}
	public void setFace(String face) {
		this.face = face;
	}
	public String getHaistyle() {
		return haistyle;
	}
	public void setHaistyle(String haistyle) {
		this.haistyle = haistyle;
	}
}

//��ɫ�����ߣ���������
abstract class ActorBuilder{
	protected Actor actor = new Actor();
	public abstract void buildType();
	public abstract void buildSex();
	public abstract void buildFace();
	public abstract void buildHairstyle();
	public Actor createActor() {
		return actor;
	}
}

//Ӣ�۽�ɫ�����ߣ����彨����
class HeroBuilder extends ActorBuilder{
	public void buildType() {
		actor.setType("Ӣ��");
	}
	public void buildSex() {
		actor.setSex("��");
	}
	public void buildFace() {
		actor.setFace("Ӣ��");
	}
	public void buildHairstyle() {
		actor.setHaistyle("Ʈ��");
	}	
}

//��Ϸ��ɫ������������ָ����
class ActorController{
	public Actor construct(ActorBuilder ab) {
		ab.buildType();
		ab.buildFace();
		ab.buildSex();
		ab.buildHairstyle();
		return ab.createActor();
	}
}

public class BuilderPattern {

}
