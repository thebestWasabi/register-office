package edu.javalesson.register;

import edu.javalesson.register.rest.MarriageController;
import edu.javalesson.register.view.MarriageRequest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Starter {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"spring_context.xml"});
        MarriageController controller = context.getBean("marriageController", MarriageController.class);
        controller.findMarriageCertificate(new MarriageRequest());

    }
}
