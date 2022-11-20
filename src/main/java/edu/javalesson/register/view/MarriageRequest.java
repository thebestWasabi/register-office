package edu.javalesson.register.view;

import java.io.Serializable;
import java.time.LocalDate;

public class MarriageRequest implements Serializable {

    private String husbandSureName;
    private String husbandGivenName;
    private String husbandPatronymic;
    private LocalDate husbandDateBirth;
    private String husbandPassportSeries;
    private String husbandPassportNumber;
    private LocalDate husbandPassportIssueDate;

    private String wifeSureName;
    private String wifeGivenName;
    private String wifePatronymic;
    private LocalDate wifeDateBirth;
    private String wifePassportSeries;
    private String wifePassportNumber;
    private LocalDate wifePassportIssueDate;

    private String marriageCertificateNumber;
    private LocalDate marriageCertificateDate;
}
