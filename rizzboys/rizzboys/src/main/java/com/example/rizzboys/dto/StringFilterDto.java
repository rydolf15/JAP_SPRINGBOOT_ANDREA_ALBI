package com.example.rizzboys.dto;

public class StringFilterDto {
    Long idCustomer;
    String criterion;

    public Long getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(Long idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getCriterion() {
        return criterion;
    }

    public void setCriterion(String criterion) {
        this.criterion = criterion;
    }
}
