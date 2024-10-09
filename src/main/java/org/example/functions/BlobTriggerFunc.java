package org.example.functions;

import com.microsoft.azure.functions.annotation.*;
import com.microsoft.azure.functions.*;
import org.example.functions.dto.Api6Request;
import org.example.functions.dto.CostResponse;
import org.example.functions.dto.Data3;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.functions.model.FocusExport;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Azure Functions with Azure Blob trigger.
 */
public class BlobTriggerFunc {
    /**
     * This function will be invoked when a new or updated blob is detected at the specified path. The blob contents are provided as input to this function.
     */
    @FunctionName("BlobTriggerFunc")
    @StorageAccount("FUNCTIONS_WORKER_RUNTIME")
    public void run(
        @BlobTrigger(name = "content", path = "mycontainer/{name}", dataType = "binary") byte[] content,
        @BindingName("name") String name,
        final ExecutionContext context
    ) {
        context.getLogger().info("Java Blob trigger function processed a blob. Name: " + name + "\n  Size: " + content.length + " Bytes");


        CostResponse<Data3> response;
        try {
            String subscriptionId = "0f8c3763-9eeb-40f9-9037-2a5426da75e9"; // Replace with actual subscription ID
         //   String api5Response = callApi5(subscriptionId);

            //
            CostResponse<Data3> response1 = callApi5(subscriptionId);


            ObjectMapper objectMapper = new ObjectMapper();
           // response = objectMapper.readValue(api5Response, CostResponse.class);

         List<FocusExport> usageMetrics = new ArrayList<>();
        for (String date : response1.getData().getDates()) {
            // Check if CSV file exists for the date and subscriptionId
            // If exists, parse the CSV and add to usageMetrics
            // This is a placeholder for actual CSV parsing logic
            FocusExport metric = new FocusExport();
            metric.setBilledCost(BigDecimal.valueOf(100.950));
            metric.setBillingAccountId("");
            metric.setChargePeriodStart(new Date() );
            metric.setChargePeriodEnd(new Date());
            metric.setChargeDescription("Sample Description");
            usageMetrics.add(metric);
        }

        // Step 5: Send data to API6
        Api6Request api6Request = new Api6Request();
        api6Request.setSubscriptionId(response1.getData().getSubscriptionId());
        api6Request.setSubscriptionName(response1.getData().getSubscriptionName());
        api6Request.setUsageMetrics(usageMetrics);

        sendToApi6(api6Request);

    } catch (Exception e) {
        context.getLogger().severe("Error processing blob: " + e.getMessage());
    }
    }

    private CostResponse<Data3> callApi5(String subscriptionId) throws IOException {
        URL url = new URL("http://localhost:8080/resourceusagemetrics/v1/api/usagemetrics/datasync/susbcriptions/" + subscriptionId + "/duration");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-Type", "application/json");

        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String inputLine;
        CostResponse<Data3> content = new CostResponse<>();
        content = (CostResponse<Data3>) conn.getContent();
//        StringBuilder content = new StringBuilder();
//        while ((inputLine = in.readLine()) != null) {
//            content.append(inputLine);
//        }
        in.close();
        conn.disconnect();

        return content;
    }

    private void sendToApi6(Api6Request request) throws IOException {
        URL url = new URL("http://localhost:8080/resourceusagemetrics/v1/api/usagemetrics/datasync/susbcriptions/" + request.getSubscriptionId() + "/load");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "application/json");
        conn.setDoOutput(true);

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonInputString = objectMapper.writeValueAsString(request);

        try (OutputStream os = conn.getOutputStream()) {
            byte[] input = jsonInputString.getBytes("utf-8");
            os.write(input, 0, input.length);
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
        StringBuilder response = new StringBuilder();
        String responseLine;
        while ((responseLine = br.readLine()) != null) {
            response.append(responseLine.trim());
        }
        br.close();
        conn.disconnect();
    }
}
