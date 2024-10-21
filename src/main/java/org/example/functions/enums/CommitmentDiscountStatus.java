package org.example.functions.enums;

public enum CommitmentDiscountStatus {

    Used("Used"), Unused("Unused");

    private final String value;

    CommitmentDiscountStatus(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }

    public static CommitmentDiscountStatus fromString(String value) {
        for (CommitmentDiscountStatus status : CommitmentDiscountStatus.values()) {
            if (status.value.equalsIgnoreCase(value)) {
                return status;
            }
        }
        throw new IllegalArgumentException("Unknown enum value: " + value);
    }
}

