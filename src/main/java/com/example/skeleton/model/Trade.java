package com.example.skeleton.model;

import java.util.Date;
import java.util.UUID;

public class Trade {
    private UUID id;
    private TradeType tradeType;
    private Date approvedOn;
    private UUID approvedBy;
    private int level;

}
