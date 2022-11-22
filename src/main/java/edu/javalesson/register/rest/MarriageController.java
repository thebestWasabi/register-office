package edu.javalesson.register.rest;

import edu.javalesson.register.business.MarriageManager;
import edu.javalesson.register.view.MarriageRequest;
import edu.javalesson.register.view.MarriageResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("marriageController")
public class MarriageController {

    private static final Logger logger = LoggerFactory.getLogger(MarriageController.class);
    private MarriageManager marriageManager;

    public MarriageResponse findMarriageCertificate(MarriageRequest request) {
        logger.info("findMarriageCertificate called");
        return marriageManager.findMarriageCertificate(request);
    }

    @Autowired
    @Qualifier("marriageManager")
    public void setMarriageManager(MarriageManager marriageManager) {
        this.marriageManager = marriageManager;
    }
}
