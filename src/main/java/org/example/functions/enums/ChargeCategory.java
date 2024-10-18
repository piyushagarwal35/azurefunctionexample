package org.example.functions.enums;

public enum ChargeCategory {
    USAGE("USAGE"), SUBSCRIPTION("SUBSCRIPTION"), OTHER("OTHER");

    private final String value;

    ChargeCategory(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }

    public static ChargeCategory fromString(String value) {
        for (ChargeCategory category : ChargeCategory.values()) {
            if (category.value.equalsIgnoreCase(value)) {
                return category;
            }
        }
        throw new IllegalArgumentException("Unknown enum value: " + value);
    }

}
