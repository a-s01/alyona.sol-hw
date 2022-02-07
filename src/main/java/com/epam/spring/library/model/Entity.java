package com.epam.spring.library.model;

/**
 * This is helper interface for list database emulation used for automatic
 * id generation. Will be removed in later versions of homework
 */
public interface Entity {

    void setId(int id);

    int getId();
}
