package com.huashan.utils;

import org.apache.ws.security.WSPasswordCallback;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import java.io.IOException;

public class ServerPasswordCallback implements CallbackHandler {

	//	@Override
//	public void handle(Callback[] callbacks) throws IOException,
//			UnsupportedCallbackException {
//		WSPasswordCallback pc = (WSPasswordCallback) callbacks[0];
//		 
//        if (pc.getIdentifier().equals("coocaaxxxx")) {
//            // set the password on the callback. This will be compared to the
//            // password which was sent from the client.
//            pc.setPassword("asd123");
//        }
//	}
	public void handle(Callback[] callbacks) throws IOException,
			UnsupportedCallbackException {
		WSPasswordCallback pc = (WSPasswordCallback) callbacks[0];

		if (pc.getIdentifier().equals("coocaaxxxx")) {
			// set the password on the callback. This will be compared to the
			// password which was sent from the client.
			pc.setPassword("asd123");
		}
	}

}