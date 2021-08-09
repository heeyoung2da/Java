package com.jungsuk.variable;

class Person{
	static int age = 0;
	void goOut(){
		System.out.println("안에서 밖으로 나간다.");
	}
}
class Parent extends Person{
	int age = 1;
	void goOut(){
		System.out.println("출근..");
	}
}
class Child extends Parent{
	int age = 2;
	void goOut(){
		System.out.println("놀러가자!");
	}
}
public class Example {
	public static void main(String[] args) {
		Child child = new Child(); //1
		Parent parent = new Parent();//2
		Person person = new Child();//3
		Parent parent1 = new Child();//4
//		Child child1 = new Person();//5
		System.out.println(person.age);//6
		System.out.println(parent.age);//7
		System.out.println(child.age);//8
		child.goOut();//9
		parent.goOut();//10
		parent1.goOut();//11
		person.goOut();//12
//		child1.goOut();//13
	}
}
