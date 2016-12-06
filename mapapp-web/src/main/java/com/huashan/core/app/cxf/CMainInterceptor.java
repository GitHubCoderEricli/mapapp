package com.huashan.core.app.cxf;

import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;
import org.springframework.stereotype.Component;

@Component
public class CMainInterceptor extends AbstractPhaseInterceptor<SoapMessage> {

	public CMainInterceptor(String phase) {
		super(phase);
	}
	
	public CMainInterceptor() {
		super( Phase.RECEIVE );
	}

	public void handleMessage(SoapMessage soapMessage) throws Fault {
//		System.out.println("------------------111222-------------------");
	}
}
