package org.example.functions.enums;

public enum PricingCategory {
    STANDARD("STANDARD"), DISCOUNTED("DISCOUNTED"), OTHER("OTHER");

    private final String value;

    PricingCategory(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }

    public static PricingCategory fromString(String value) {
        for (PricingCategory category : PricingCategory.values()) {
            if (category.value.equalsIgnoreCase(value)) {
                return category;
            }
        }
        throw new IllegalArgumentException("Unknown enum value: " + value);
    }
}
