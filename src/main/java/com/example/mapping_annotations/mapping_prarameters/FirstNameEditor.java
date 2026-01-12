package com.example.mapping_annotations.mapping_prarameters;

import java.beans.PropertyEditorSupport;

public class FirstNameEditor extends PropertyEditorSupport {

    @Override
    public void setAsText(String text) throws IllegalArgumentException{
        setValue(text.trim().toLowerCase());
    }
}
