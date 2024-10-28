package com.dws.challenge.domain;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Transfer {
    private String accountFrom;
    private String accountTo;
    private String amountToTransfer;
}
