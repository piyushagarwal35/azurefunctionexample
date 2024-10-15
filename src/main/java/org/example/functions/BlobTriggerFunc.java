package org.example.functions;


import com.azure.storage.blob.BlobContainerClient;
import com.azure.storage.blob.BlobServiceClient;
import com.azure.storage.blob.BlobServiceClientBuilder;
import com.azure.storage.blob.models.BlobItem;
import com.fasterxml.jackson.core.type.TypeReference;
import com.microsoft.azure.functions.annotation.*;
import com.microsoft.azure.functions.*;
import com.opencsv.CSVParser;
import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;
import com.opencsv.exceptions.CsvException;
import org.example.functions.dto.Api6Request;
import org.example.functions.dto.CostResponse;
import org.example.functions.dto.Data3;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.functions.model.FocusExport;

import java.io.*;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
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
    @StorageAccount("AzureWebJobsStorage")
    public void run(
        @BlobTrigger(name = "content", path = "data/subhigherenv2/monthlycost-focus-cost/{name}", dataType = "binary") byte[] content,
        @BindingName("name") String name,
        @BindingName("BlobTrigger") String uri,
        final ExecutionContext context
    ) {
        context.getLogger().info("Java Blob trigger function processed a blob. Name: " + name + "\n  Size: " + content.length + " Bytes");
        context.getLogger().info("Triggered path: " + uri);

        CostResponse<Data3> response;
        try {
            String subscriptionId = "0f8c3763-9eeb-40f9-9037-2a5426da75e9"; // Replace with actual subscription ID
         //   String api5Response = callApi5(subscriptionId);

            context.getLogger().info("API 5 calling : ");
            //authentication take credential from key vault and pass it to api5
            CostResponse<Data3> response1 = callApi5(subscriptionId);
            context.getLogger().info("API 5 call response : " + response1.toString());

          //  ObjectMapper objectMapper = new ObjectMapper();
           // response = objectMapper.readValue(api5Response, CostResponse.class);

         List<FocusExport> usageMetrics = new ArrayList<>();
     //   for (String date : response1.getData().getDates()) {
            //data / subhigherenv2 / monthlycost-focus-cost / 20240901-20240930 / eedecc33-7c1e-4805-befd-0d882349889c/part_0_0001.csv
//            String csvFilePath = "/path/to/csv/" + subscriptionId + "_" + date + ".csv"; // will implement later
            String csvFilePath = "data/subhigherenv2/monthlycost-focus-cost/part_0_0001_v1.csv";
            if (Files.exists(Paths.get(csvFilePath))) {  //might be an issue
                context.getLogger().info("parsing csv fils on path : "+ csvFilePath );
                usageMetrics.addAll(parseCsvFile(csvFilePath));
                context.getLogger().info("parsed csv files data : " + usageMetrics.toString());
            }
           // context.getLogger().info("API 5 date : " + date);
           // String prefix = "data/subhigherenv2/monthlycost-focus-cost/" + date + "/";
//            String prefix = "subhigherenv2/monthlycost-focus-cost/" ;
//            List<String> blobPaths = listBlobs("data", prefix); // will change this for uri later or hardcode this
//            context.getLogger().info("blob path : " + blobPaths);
//            for (String blobPath : blobPaths) {
//                if (blobPath.endsWith(".csv")) {
//                    context.getLogger().info("parsing csv fils  : " );
//                    usageMetrics.addAll(parseCsvFile(blobPath));
//                    context.getLogger().info("parsed csv files data : " + usageMetrics.toString());
//                }
//            }

            // Check if CSV file exists for the date and subscriptionId
            // If exists, parse the CSV and add to usageMetrics
            // This is a placeholder for actual CSV parsing logic
//            FocusExport metric = new FocusExport();
//            metric.setBilledCost(BigDecimal.valueOf(100.950));
//            metric.setBillingAccountId("");
//            metric.setChargePeriodStart(new Date() );
//            metric.setChargePeriodEnd(new Date());
//            metric.setChargeDescription("Sample Description");
//            usageMetrics.add(metric);
     //   }

        // Step 5: Send data to API6
//            context.getLogger().info("API 6 calling : " );
        Api6Request api6Request = new Api6Request();
        api6Request.setSubscriptionId(response1.getData().getSubscriptionId());
        api6Request.setSubscriptionName(response1.getData().getSubscriptionName());
        api6Request.setUsageMetrics(usageMetrics);

            context.getLogger().info("API 6 calling : " );
        String res =  sendToApi6(api6Request,context);
            context.getLogger().info("API 6 call response  : " + res );
    } catch (Exception e) {
        context.getLogger().severe("Error processing blob: " + e.getMessage());
    }
    }

    private CostResponse<Data3> callApi5(String subscriptionId) throws IOException {
        //https://resource-usage-metrics.dev.hitachi-ai.io/resourceusagemetrics/v1/api/usagemetrics/datasync/susbcriptions/xyz/dates
        URL url = new URL("https://resource-usage-metrics.dev.hitachi-ai.io/resourceusagemetrics/v1/api/usagemetrics/datasync/susbcriptions/" + subscriptionId + "/dates");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-Type", "application/json");

        int responseCode = conn.getResponseCode();
        if (responseCode == 200) {
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder content = new StringBuilder();
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();
            conn.disconnect();

            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(content.toString(), new TypeReference<CostResponse<Data3>>() {});
        } else {
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
            StringBuilder errorContent = new StringBuilder();
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                errorContent.append(inputLine);
            }
            in.close();
            conn.disconnect();

            throw new IOException("Server returned HTTP response code: " + responseCode + " for URL: " + url + ". Response: " + errorContent.toString());
        }
    }

    private List<String> listBlobs(String containerName, String prefix) {
        BlobServiceClient blobServiceClient = new BlobServiceClientBuilder()
                .connectionString("abc")
                .buildClient();
        BlobContainerClient containerClient = blobServiceClient.getBlobContainerClient(containerName);

        List<String> blobPaths = new ArrayList<>();
        for (BlobItem blobItem : containerClient.listBlobsByHierarchy(prefix)) {
            blobPaths.add(blobItem.getName());
        }
        return blobPaths;
    }

  private List<FocusExport> parseCsvFile(String filePath) throws IOException, CsvException {
        List<FocusExport> usageMetrics = new ArrayList<>();
        List<FocusExport> records = null;

//        try (CSVReader csvReader = new CSVReader(new FileReader(filePath))) {
//            String[] values;
//            csvReader.readNext(); // Skip header
//            while ((values = csvReader.readNext()) != null) {
//                FocusExport metric = new FocusExport();
//                metric.setBilledCost(new BigDecimal(values[0]));
//                metric.setBillingAccountId(values[1]);
//                metric.setChargePeriodStart(new SimpleDateFormat("yyyy-MM-dd").parse(values[2]));
//                metric.setChargePeriodEnd(new SimpleDateFormat("yyyy-MM-dd").parse(values[3]));
//                metric.setChargeDescription(values[4]);
//                usageMetrics.add(metric);
//            }
//        try (Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
        try (Reader reader = new BufferedReader(new InputStreamReader(Files.newInputStream(Paths.get(filePath))))) {
            // Define mapping strategy
            HeaderColumnNameMappingStrategy<FocusExport> strategy = new HeaderColumnNameMappingStrategy<>();
            strategy.setType(FocusExport.class);

            // Create CsvToBean object
            CsvToBean<FocusExport> csvToBean = new CsvToBeanBuilder<FocusExport>(reader)
                    .withMappingStrategy(strategy)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            // Parse the CSV file into a list of FocusExport objects
            records = csvToBean.parse();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //return usageMetrics;

        return records;
    }


    private String sendToApi6(Api6Request request, ExecutionContext context) throws IOException {
      //  final ExecutionContext context ;
        context.getLogger().info("API 6 calling inside method : ");

        //https://resource-usage-metrics.dev.hitachi-ai.io/resourceusagemetrics/v1/api/usagemetrics/datasync/subscriptions/csc/loadusagemetrics
        URL url = new URL("https://resource-usage-metrics.dev.hitachi-ai.io/resourceusagemetrics/v1/api/usagemetrics/datasync/susbcriptions/" + request.getSubscriptionId() + "/loadusagemetrics");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "application/json");
        conn.setDoOutput(true);

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonInputString = objectMapper.writeValueAsString(request);
        context.getLogger().info("API 6 called inside method : ");
        //context.getLogger().info("API 6 calling : " );
        try (OutputStream os = conn.getOutputStream()) {
            byte[] input = jsonInputString.getBytes("utf-8");
            context.getLogger().info("Writing request body: " + jsonInputString);
            os.write(input, 0, input.length);
            context.getLogger().info("Request body written successfully.");
        }
        int responseCode = conn.getResponseCode();
        context.getLogger().info("API 6 response  : " + responseCode);
        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
        StringBuilder response = new StringBuilder();
        String responseLine;
        while ((responseLine = br.readLine()) != null) {
            response.append(responseLine.trim());
        }
        br.close();
        conn.disconnect();

        System.out.println("Response code :" + responseCode);
        System.out.println("Response : " + response.toString());
        return response.toString();
    }
}
