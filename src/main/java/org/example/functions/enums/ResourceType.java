package org.example.functions.enums;

public enum ResourceType {
    API_MANAGEMENT_SERVICE("API MANAGEMENT SERVICE"),
    APP_CONFIGURATION("APP CONFIGURATION"),

    APP_SERVICE_PLAN("APP SERVICE PLAN"),
    APP_SERVICE_WEB_APP("APP SERVICE WEB APP"),

    APPLICATION_INSIGHTS_APP("APPLICATION INSIGHTS APP"),
    AZURE_DATABASE_FOR_POSTGRESQL_FLEXIBLE_SERVER("AZURE DATABASE FOR POSTGRESQL FLEXIBLE SERVER"),
    AZURE_AI_SERVICES("AZURE AI SERVICES"),
    CONTAINER_REGISTRY("CONTAINER REGISTRY"),
    CONTAINER_REGISTRY_REPLICATION("CONTAINER REGISTRY REPLICATION"),

    DATA_FACTORY_V2("DATA FACTORY (V2)"),
    DISK("DISK"),

    EVENT_GRID_TOPIC("EVENT GRID TOPIC"),
    KEY_VAULT("KEY VAULT"),
    KUBERNETES_SERVICE("KUBERNETES SERVICE"),
    LOAD_BALANCER("LOAD BALANCER"),
    LOG_ANALYTICS_WORKSPACE("LOG ANALYTICS WORKSPACE"),
    NETWORK_WATCHER("NETWORK WATCHER"),
    PRIVATE_DNS_ZONE("PRIVATE DNS ZONE"),
    DNS_ZONE("DNS ZONE"),
    PRIVATE_ENDPOINT("PRIVATE ENDPOINT"),
    PUBLIC_IP_ADDRESS("PUBLIC IP ADDRESS"),
    SAAS("SAAS"),

    SEARCH_SERVICE("SEARCH SERVICE"),
    SNAPSHOT("SNAPSHOT"),
    STORAGE_ACCOUNT("STORAGE ACCOUNT"),
    VIRTUAL_MACHINE("VIRTUAL MACHINE"),
    VIRTUAL_MACHINE_SCALE_SET("VIRTUAL MACHINE SCALE SET");

    private final String resourceType;

    ResourceType(String resourceType) {
        this.resourceType = resourceType;
    }

    @Override
    public String toString() {
        return this.resourceType;
    }

    public static ResourceType fromString(String resourceType) {
        for (ResourceType type : ResourceType.values()) {
            if (type.resourceType.equalsIgnoreCase(resourceType)) {
                return type;
            }
        }
        throw new IllegalArgumentException("Unknown enum value: " + resourceType);
    }
}
