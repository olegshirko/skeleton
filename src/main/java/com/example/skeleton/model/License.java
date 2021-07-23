package com.example.skeleton.model;

import java.util.Date;
import java.util.UUID;

public class License {
    private UUID id;
    private LicenseType licenseType;
    private String licenseId;
    private Date validFromDate;
    private Date validToDate;
    private String s3bucket;
    private String s3path;
    private Date approvedOn;
    private UUID approvedBy;
}
