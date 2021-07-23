package com.example.skeleton.model;

import java.util.Date;
import java.util.UUID;

public class Insurance {
    private UUID id;
    private InsuranceType insuranceType;
    private String insuranceId;
    private Date validFromDate;
    private Date validToDate;
    private String s3bucket;
    private String s3path;
}
