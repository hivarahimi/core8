package com.snap.food.model.domain;

public interface Entity<ID> {

    public ID getId();

    public Class entityType();

}
