package kai.chang.zhang.designpattern.adapterpattern;

//Target 目标抽象类，目标抽象类定义了客户所需要的接口，可以是一个抽象类或者接口，也可以是具体类
interface  Target{
	
}

//适配器类：适配器类可以调用另一个接口，作为转换器，对Adapter和Target进行适配，在对象适配器中，它通过
//继承Target并关联一个Adaptee对象使二者产生联系。
class Adapter implements Target{
	private Adaptee adaptee;
	public Adapter (Adaptee adaptee) {
		this.adaptee = adaptee;
	}
	public void request() {
		adaptee.specificRequest();
	}
}

//Adaptee适配者类，被适配的角色，它定义了一个已经存在的接口，这个接口需要适配，适配者类一般是一个具体类，包含客户希望使用的业务
//逻辑方法，在某些情况下可能没有适配者类的源代码。
class Adaptee{
	public void specificRequest() {
		
	}
}

//类适配器模式：实例代码
//由于java语言不支持多继承，因此此类适配器受到很多限制。
class Adapter_C extends Adaptee implements Target{
	public void request() {
		specificRequest();
	}
}

//双向适配器很少用
//缺省适配器是适配器模式的一种变体，其应用也比较广泛。
/*
 * 缺省适配器模式：当不需要实现一个接口所提供的所有方法时，可先设计一个抽象类实现该接口，并为接口中的每个方法提供一个默认的实现，
 * 那么该抽象类的子类可以选择性的覆盖父类的某些方法来实现。也称单接口适配器模式。
 */
//ServiceInterface()适配器接口
//AbstractServiceClass（缺省适配器类）
//ConcreteServiceClass具体业务类
