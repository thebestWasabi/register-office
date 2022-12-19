package edu.javalesson.register.business;

import edu.javalesson.register.dao.MarriageDao;
import edu.javalesson.register.dao.PersonDao;
import edu.javalesson.register.domain.MarriageCertificate;
import edu.javalesson.register.view.MarriageRequest;
import edu.javalesson.register.view.MarriageResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service("marriageService")
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class MarriageManager {

    private static final Logger logger = LoggerFactory.getLogger(MarriageManager.class);

    private MarriageDao marriageDao;

    private PersonDao personDao;

    public MarriageResponse findMarriageCertificate(MarriageRequest request) {
        logger.info("findMarriageCertificate called");
        MarriageCertificate marriageCertificate = marriageDao.findMarriageCertificate(request);
        return new MarriageResponse();
    }

    @Autowired
    public void setMarriageDao(MarriageDao marriageDao) {
        this.marriageDao = marriageDao;
    }

    @Autowired
    public void setPersonDao(PersonDao personDao) {
        this.personDao = personDao;
    }
}
