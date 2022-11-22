package edu.javalesson.register.dao;

import edu.javalesson.register.domain.MarriageCertificate;
import edu.javalesson.register.view.MarriageRequest;
import jakarta.persistence.EntityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MarriageDao {

    private static final Logger logger = LoggerFactory.getLogger(MarriageDao.class);
    private EntityManager entityManager;

    @Value("${test.value}")
    private String test;

    public MarriageCertificate findMarriageCertificate(MarriageRequest request) {
        logger.info("findMarriageCertificate called:{}", test);
        return null;
    }

    public void setTest(String test) {
        this.test = test;
    }
}
