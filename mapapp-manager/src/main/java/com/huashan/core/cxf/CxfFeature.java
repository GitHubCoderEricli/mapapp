package com.huashan.core.cxf;

import org.apache.cxf.Bus;
import org.apache.cxf.feature.AbstractFeature;
import org.apache.cxf.interceptor.Interceptor;
import org.apache.cxf.interceptor.InterceptorProvider;
import org.apache.cxf.message.Message;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Component
public class CxfFeature extends AbstractFeature {
	
	@Resource(name="CMainInterceptor")
	CMainInterceptor cMainInterceptor;
	
	protected void initializeProvider(InterceptorProvider provider, Bus bus) {
		Map<String, Object> properties = bus.getProperties();
		//在cxf中使用配置避免增加字段导致客户端必须更新的问题
		properties.put("set-jaxb-validation-event-handler", false);

		List<Interceptor<? extends Message>> inInterceptors = provider.getInInterceptors();
		inInterceptors.add(cMainInterceptor);//拦截器 cxf 扩展
	}
}
