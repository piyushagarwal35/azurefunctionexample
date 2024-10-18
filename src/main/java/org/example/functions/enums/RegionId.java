package org.example.functions.enums;

public enum RegionId {
    EASTUS("EASTUS"),EASTUS2("EASTUS2"),GLOBAL("GLOBAL"),NORTHCENTRALUS("NORTHCENTRALUS"),
    SOUTHCENTRALUS("SOUTHCENTRALUS"),WESTUS("WESTUS");

    private final String value;

    RegionId(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }

    public static RegionId fromString(String value) {
        for (RegionId region : RegionId.values()) {
            if (region.value.equalsIgnoreCase(value)) {
                return region;
            }
        }
        throw new IllegalArgumentException("Unknown enum value: " + value);
    }


}
