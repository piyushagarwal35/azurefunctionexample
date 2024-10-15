package org.example.functions;

import com.microsoft.azure.functions.annotation.*;
import com.microsoft.azure.functions.*;

/**
 * Azure Functions with Azure Blob trigger.
 */
public class blobtest {
    /**
     * This function will be invoked when a new or updated blob is detected at the specified path. The blob contents are provided as input to this function.
     */
    @FunctionName("blobtest")
    @StorageAccount("FUNCTIONS_WORKER_RUNTIME")
    public void run(
            @BlobTrigger(name = "content", path = "data/subhigherenv2/monthlycost-focus-cost/{name}", dataType = "binary") byte[] content,
            @BindingName("name") String name,
            @BindingName("BlobTrigger") String uri,
            final ExecutionContext context
    ) {
        context.getLogger().info("Java Blob trigger function processed a blob. Name: " + name + "\n  Size: " + content.length + " Bytes");
        context.getLogger().info("Triggered path: " + uri);
    }
}
