package com.ao.billms.entities;

/**
 * 封装供应商名称
 *
 */
public class BillProvider extends Bill {

    private String providerName;

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }
}
