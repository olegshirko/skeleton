package com.example.skeleton.model;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.UUID;

@Document(collection = "user")
@TypeAlias("vendor")
@Getter
public class Vendor extends User {
    private List<License> licenseList;
    private List<Insurance> insuranceList;
    private List<Trade> tradeList;
    private String companyName;
    private String promoCode;
    private Boolean tosAccepted;
    private Boolean payoutEnabled;
    private String stripeId;
    private String qbId;

    @Builder
    public Vendor(String id, String firstName, String middleName, String lastName, List<Email> email, Number phone, String picture, Address address, String type, List<License> licenseList, List<Insurance> insuranceList, List<Trade> tradeList, String companyName, String promoCode, Boolean tosAccepted, Boolean payoutEnabled, String stripeId, String qbId) {
        super(id, firstName, middleName, lastName, email, phone, picture, address, type);
        this.licenseList = licenseList;
        this.insuranceList = insuranceList;
        this.tradeList = tradeList;
        this.companyName = companyName;
        this.promoCode = promoCode;
        this.tosAccepted = tosAccepted;
        this.payoutEnabled = payoutEnabled;
        this.stripeId = stripeId;
        this.qbId = qbId;
    }
}
