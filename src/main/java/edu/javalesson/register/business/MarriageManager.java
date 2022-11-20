package edu.javalesson.register.business;

import edu.javalesson.register.dao.MarriageDao;
import edu.javalesson.register.view.MarriageRequest;
import edu.javalesson.register.view.MarriageResponse;

public class MarriageManager {

    private MarriageDao dao;

    public MarriageResponse findMarriageCertificate(MarriageRequest request) {
        dao = new MarriageDao();
        throw new UnsupportedOperationException("Unsupported");
    }
}
