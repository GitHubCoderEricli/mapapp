package test;

import com.huashan.core.beans.job.Schedulejob;
import com.huashan.core.webservice.SchedulejobService;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.quartz.SchedulerException;

import java.util.List;

/**
 * Created by lixu on 2016-10-18.
 */
public class Test {
    public static void main(String[] args) {
        JaxWsProxyFactoryBean soapFactoryBean = new JaxWsProxyFactoryBean();
        soapFactoryBean.setAddress("http://localhost:8088/services/schedulejobService");
        soapFactoryBean.setServiceClass(SchedulejobService.class);
        Object o = soapFactoryBean.create();
        SchedulejobService service = (SchedulejobService)o;

        List<Schedulejob> list = service.findAll();
        System.out.print(list.get(0));
        System.out.print(service.Test());
    }
}
