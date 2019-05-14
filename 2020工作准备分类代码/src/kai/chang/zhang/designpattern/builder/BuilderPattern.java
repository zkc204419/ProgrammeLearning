package kai.chang.zhang.designpattern.builder;

//建造者模式
//定义产品的各个部件
class Product{
	private String PartA;
	private String PartB;
	private String PartC;
}

//在抽象建造者类中定义了产品的创建方法和返回方法
abstract class Builder{
	protected Product product =  new Product();
	public abstract void buildPartA();
	public abstract void buildPartB();
	public abstract void buildPartC();
	public Product getResult() {
		return product;
	}
}

//指挥者：一方面它隔离了客户与创建过程；另一方面它控制产品的创建过程；
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

//实例 Actor代表具体复杂产品
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

//角色建造者：抽象建造者
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

//英雄角色建造者：具体建造者
class HeroBuilder extends ActorBuilder{
	public void buildType() {
		actor.setType("英雄");
	}
	public void buildSex() {
		actor.setSex("男");
	}
	public void buildFace() {
		actor.setFace("英俊");
	}
	public void buildHairstyle() {
		actor.setHaistyle("飘逸");
	}	
}

//游戏角色创建控制器：指挥者
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
