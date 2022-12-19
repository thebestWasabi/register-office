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

    private static final Logger log = LoggerFactory.getLogger(MarriageDao.class);

    private EntityManager entityManager;

    @Value("${test.value}")
    private String test;

    public MarriageCertificate findMarriageCertificate(MarriageRequest request) {
        log.info("findMarriageCertificate called:{}", test);
        return null;
    }

}
