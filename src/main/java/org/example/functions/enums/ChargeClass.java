package org.example.functions.enums;

public enum ChargeClass {
    CORRECTION("CORRECTION");

    private final String value;

    ChargeClass(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }

    public static ChargeClass fromString(String value) {
        for (ChargeClass chargeclass : ChargeClass.values()) {
            if (chargeclass.value.equalsIgnoreCase(value)) {
                return chargeclass;
            }
        }
        throw new IllegalArgumentException("Unknown enum value: " + value);
    }

}
