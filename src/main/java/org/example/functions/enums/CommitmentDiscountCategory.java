package org.example.functions.enums;

public enum CommitmentDiscountCategory {
    SPEND("SPEND"), USAGE("USAGE");

    private final String value;

    CommitmentDiscountCategory(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }

    public static CommitmentDiscountCategory fromString(String value) {
        for (CommitmentDiscountCategory category : CommitmentDiscountCategory.values()) {
            if (category.value.equalsIgnoreCase(value)) {
                return category;
            }
        }
        throw new IllegalArgumentException("Unknown enum value: " + value);
    }
}
