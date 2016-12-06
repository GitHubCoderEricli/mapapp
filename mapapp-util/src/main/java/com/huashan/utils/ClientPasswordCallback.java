package com.huashan.utils;

import org.apache.ws.security.WSPasswordCallback;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import java.io.IOException;

public class ClientPasswordCallback implements CallbackHandler {

	//	@Override
	public void handle(Callback[] callbacks) throws IOException,
			UnsupportedCallbackException {
		WSPasswordCallback pc = (WSPasswordCallback) callbacks[0];
		/*int usage = pc.getUsage();
		System.out.println("Identifier: " + pc.getIdentifier() + " , usage: " + pc.getUsage());
        if(usage == WSPasswordCallback.USERNAME_TOKEN) {
        	pc.setIdentifier("admin");
        	//pc.setPassword("password");
        } else if(usage== WSPasswordCallback.SIGNATURE) {
	        pc.setPassword("keyPassword");
        }*/
		pc.setPassword("asd123");
	}

}
//import java.io.IOException;
//import javax.security.auth.callback.Callback;
// import javax.security.auth.callback.CallbackHandler;
// import javax.security.auth.callback.UnsupportedCallbackException;
//import org.apache.ws.security.WSPasswordCallback;
//public class ClientPasswordCallback implements CallbackHandler {
////  @Override
//  public void handle(Callback[] callbacks) throws IOException,
//                UnsupportedCallbackException {
//      WSPasswordCallback pc = (WSPasswordCallback) callbacks[0];
//      pc.setPassword("asd123");//客户端配置密码
//  }
//}