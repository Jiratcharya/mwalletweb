package com.mfu.ejb;

import javax.ejb.Remote;
import javax.ejb.Stateless;

@Stateless
@Remote(Mwallet.class)

public class MwalletBean implements Mwallet{

	
	public MwalletBean(){
		
	}
	
	public String sayHello(String name) {
		String msg = "Hello "+ name;
		System.out.println(msg);
		return msg;
	}

}
