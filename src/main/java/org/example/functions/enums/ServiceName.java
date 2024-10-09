package org.example.functions.enums;

public enum ServiceName {
    API_MANAGEMENT("API MANAGEMENT"),
    APP_CONFIGURATION("APP CONFIGURATION"),
    AZURE_AI_SERVICES("AZURE AI SERVICES"),
    AZURE_APP_SERVICE("AZURE APP SERVICE"),

    AZURE_COGNITIVE_SEARCH("AZURE COGNITIVE SEARCH"),
    AZURE_CONTAINER_REGISTRY("AZURE CONTAINER REGISTRY"),

    AZURE_DATA_FACTORY("AZURE DATA FACTORY"),

    AZURE_DB_FOR_POSTGRESQL("AZURE DB FOR POSTGRESQL"),
    AZURE_DNS("AZURE DNS"),
    AZURE_KUBERNETES_SERVICE("AZURE KUBERNETES SERVICE"),
    AZURE_MARKETPLACE("AZURE MARKETPLACE"),
    AZURE_MONITOR("AZURE MONITOR"),
    AZURE_PRIVATE_LINK("AZURE PRIVATE LINK"),

    CONTAINER_REGISTRY("CONTAINER REGISTRY"),

    EVENT_GRID("EVENT GRID"),
    KEY_VAULT("KEY VAULT"),
    LOAD_BALANCER("LOAD BALANCER"),
    NETWORK_WATCHER("NETWORK WATCHER"),
    STORAGE_ACCOUNTS("STORAGE ACCOUNTS"),
    VIRTUAL_MACHINES("VIRTUAL MACHINES"),
    VIRTUAL_MACHINE_SCALE_SETS("VIRTUAL MACHINE SCALE SETS"),
    VIRTUAL_NETWORK("VIRTUAL NETWORK");

    private final String serviceName;

    ServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    @Override
    public String toString() {
        return this.serviceName;
    }

    public static ServiceName fromString(String serviceName) {
        for (ServiceName service : ServiceName.values()) {
            if (service.serviceName.equalsIgnoreCase(serviceName)) {
                return service;
            }
        }
        throw new IllegalArgumentException("Unknown enum value: " + serviceName);
    }
}
