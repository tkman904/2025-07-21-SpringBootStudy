package com.sist.main;

import java.util.*;

class A {
	public void disp() {
		System.out.println("A:disp() Call...");
	}
}

class Container {
	Map map = new HashMap();
	public Container() {
		map.put("a", new A());
		// XML / Annotation을 읽어서 저장
	}
	
	public Object getBean(String key) {
		return map.get(key);
	}
}

public class MainClass5 {
	public static void main(String[] args) {
			Container c = new Container();
			A a = (A)c.getBean("a");
			A b = (A)c.getBean("a");
			A f = (A)c.getBean("a");
			A d = (A)c.getBean("a");
			A e = (A)c.getBean("a");
			
			System.out.println("a= "+a);
			System.out.println("b= "+b);
			System.out.println("f= "+f);
			System.out.println("d= "+d);
			System.out.println("e= "+e);
	}
}
