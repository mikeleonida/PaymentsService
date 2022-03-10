package com.eventdriven.estore.PaymentsService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.security.NoTypePermission;

@SpringBootApplication
public class PaymentsServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaymentsServiceApplication.class, args);
	}
	
//	@Bean
//    XStream xstream() {
//        XStream xstream = new XStream();
//        // clear out existing permissions and set own ones
//        xstream.addPermission(NoTypePermission.NONE);
//        // allow any type from the same package
//        xstream.allowTypesByWildcard(new String[] {
//                "com.appsdeveloperblog.estore.core.**",
//                "com.appsdeveloperblog.estore.OrdersService.**",
//                "com.eventdriven.estore.**",
//                "org.axonframework.**",
//                "java.**",
//                "com.thoughtworks.xstream.**"
//        });
//
//        return xstream;
//    }

}
