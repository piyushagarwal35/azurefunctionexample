package org.example.functions.model;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvCustomBindByName;


import jakarta.persistence.*;
import lombok.*;
import org.example.functions.converters.*;
import org.example.functions.enums.*;



import java.math.BigDecimal;
import java.util.Date;
import java.util.logging.Logger;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
//@Table(name = "resource_usage_metrics_data")
//@Entity
public class FocusExport {

    private static final Logger logger = Logger.getLogger(FocusExport.class.getName());

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "Id", nullable = false, updatable = false)
//   private Integer id;

   // @Column(name = "AvailabilityZone", columnDefinition = "text")
   @CsvBindByName(column="AvailabilityZone")
    private String AvailabilityZone;

//    @Column(name = "BilledCost", columnDefinition = "numeric(50, 18)")
    @CsvBindByName(column="BilledCost")
    private BigDecimal billedCost;

//    @Column(name = "BillingAccountId",  columnDefinition = "text")
    @CsvBindByName(column = "BillingAccountId")
    private String billingAccountId;

//    @Column(name = "BillingAccountName", columnDefinition = "text")
    @CsvBindByName(column = "BillingAccountName")
    private String BillingAccountName;

   @Enumerated(EnumType.STRING)
//    @Column(name = "BillingCurrency", length = 8)
    @CsvBindByName(column = "BillingCurrency")
    private BillingCurrency BillingCurrency;

//    @Column(name = "BillingPeriodEnd", columnDefinition = "timestamptz")
    @CsvBindByName(column = "BillingPeriodEnd")
    @CsvCustomBindByName(converter = CustomDateConverter.class)
    private Date BillingPeriodEnd;

//    @Column(name = "BillingPeriodStart", columnDefinition = "timestamptz")
    @CsvBindByName(column = "BillingPeriodStart")
    @CsvCustomBindByName(converter = CustomDateConverter.class)
    private Date BillingPeriodStart;

    @Enumerated(EnumType.STRING)
//    @Column(name = "ChargeCategory", length = 16)
    @CsvBindByName(column = "ChargeCategory")
    private ChargeCategory ChargeCategory;

//    @Column(name = "ChargeClass", columnDefinition = "text")
    @CsvBindByName(column = "ChargeClass")
    private String ChargeClass;

//    @Column(name = "ChargeDescription", columnDefinition = "text")
    @CsvBindByName(column = "ChargeDescription")
    private String ChargeDescription;

    @Enumerated(EnumType.STRING)
//    @Column(name = "ChargeFrequency", length = 32)
    @CsvCustomBindByName(column = "ChargeFrequency",converter= ChargeFrequencyConverter.class)
    private ChargeFrequency ChargeFrequency;

//    @Column(name = "ChargePeriodEnd", columnDefinition = "timestamptz")
    @CsvBindByName(column = "ChargePeriodEnd")
    @CsvCustomBindByName(converter = CustomDateConverter.class)
    private Date ChargePeriodEnd;

//    @Column(name = "ChargePeriodStart", columnDefinition = "timestamptz")
    @CsvBindByName(column = "ChargePeriodStart")
    @CsvCustomBindByName(converter = CustomDateConverter.class)
    private Date ChargePeriodStart;

//    @Column(name = "CommitmentDiscountCategory", columnDefinition = "text")
    @CsvBindByName(column = "CommitmentDiscountCategory")
    private String CommitmentDiscountCategory;

//    @Column(name = "CommitmentDiscountId", columnDefinition = "text")
    @CsvBindByName(column = "CommitmentDiscountID")
    private String CommitmentDiscountId;

 //   @Column(name = "CommitmentDiscountName", columnDefinition = "text")
    @CsvBindByName(column = "CommitmentDiscountName")
    private String CommitmentDiscountName;

//    @Column(name = "CommitmentDiscountStatus", columnDefinition = "text")
    @CsvBindByName(column = "CommitmentDiscount Status")
    private String CommitmentDiscountStatus;

 //   @Column(name = "CommitmentDiscountType", columnDefinition = "text")
    @CsvBindByName(column = "CommitmentDiscountType")
    private String CommitmentDiscountType;

  //  @Column(name = "ConsumedQuantity", columnDefinition = "numeric(25, 5    )")
    @CsvBindByName(column = "ConsumedQuantity")
    private BigDecimal ConsumedQuantity;

  //  @Enumerated(EnumType.STRING)
   // @Column(name = "ConsumedUnit", length = 32)
    @CsvCustomBindByName(column = "ConsumedUnit",converter = ConsumedUnitConverter.class)
    private ConsumedUnit ConsumedUnit;

   // @Column(name = "ContractedCost", columnDefinition = "numeric(50, 18)")
    @CsvBindByName(column = "ContractedCost")
    private BigDecimal ContractedCost;

   // @Column(name = "ContractedUnitPrice", columnDefinition = "numeric(50, 18)")
    @CsvBindByName(column = "ContractedUnitPrice")
    private BigDecimal ContractedUnitPrice;

//    @Column(name = "EffectiveCost", columnDefinition = "numeric(50, 18)")
  @CsvBindByName(column = "EffectiveCost")
    private BigDecimal EffectiveCost;

 //   @Column(name = "InvoiceIssuerName", columnDefinition = "text")
    @CsvBindByName(column = "InvoiceIssuer")
    private String InvoiceIssuerName;

//    @Column(name = "ListCost", columnDefinition = "numeric(50, 18)")
    @CsvBindByName(column = "ListCost")
    private BigDecimal ListCost;

//    @Column(name = "ListUnitPrice", columnDefinition = "numeric(50, 18)")
   @CsvBindByName(column = "ListUnitPrice")
    private BigDecimal ListUnitPrice;

    @Enumerated(EnumType.STRING)
   // @Column(name = "PricingCategory", length = 32)
    @CsvBindByName(column = "PricingCategory")
    private PricingCategory PricingCategory;

    //@Column(name = "PricingQuantity", columnDefinition = "numeric(25, 5)")
    @CsvBindByName(column = "PricingQuantity")
    private BigDecimal PricingQuantity;

   // @Enumerated(EnumType.STRING)
    //@Column(name = "PricingUnit", length = 32)
    @CsvCustomBindByName(column = "PricingUnit",converter = PricingUnitConverter.class)
    private PricingUnit PricingUnit;

    //@Column(name = "ProviderName", columnDefinition = "text")
    @CsvBindByName(column = "ProviderName")
    private String ProviderName;

    //@Column(name = "PublisherName", columnDefinition = "text")
    @CsvBindByName(column = "PublisherName")
    private String PublisherName;

    @Enumerated(EnumType.STRING)
    //@Column(name = "RegionId", length = 32)
    @CsvBindByName(column = "RegionId")
    private RegionId RegionId;

    @Enumerated(EnumType.STRING)
    //@Column(name = "RegionName", length = 32)
    @CsvCustomBindByName(column = "RegionName",converter = RegionNameConverter.class)
    private RegionName RegionName;

    //@Column(name = "ResourceId", columnDefinition = "text")
    @CsvBindByName(column = "ResourceID")
    private String ResourceId;

   // @Column(name = "ResourceName", columnDefinition = "text")
    @CsvBindByName(column = "ResourceName")
    private String ResourceName;

    //@Enumerated(EnumType.STRING)
    //@Column(name = "ResourceType", columnDefinition = "text")
    //@CsvCustomBindByName(column = "ResourceType",converter = ResourceTypeConverter.class)
    @CsvBindByName(column = "ResourceType")
    private String ResourceType;

    @Enumerated(EnumType.STRING)
    //@Column(name = "ServiceCategory", columnDefinition = "text")
    @CsvCustomBindByName(column = "ServiceCategory",converter = ServiceCategoryConverter.class)
    @CsvBindByName(column = "ServiceCategory")
    private String ServiceCategory;

    //@Enumerated(EnumType.STRING)
    //@Column(name = "ServiceName", columnDefinition = "text")
    //@CsvCustomBindByName(column = "ServiceName",converter = ServiceNameConverter.class)
    @CsvBindByName(column = "ServiceName")
    private String ServiceName;

    //@Column(name = "SkuId", columnDefinition = "text")
    @CsvBindByName(column = "SkuId")
    private String SkuId;

    //@Column(name = "SkuPriceId", columnDefinition = "text")
    @CsvBindByName(column = "SkuPriceId")
    private String SkuPriceId;

    //@Column(name = "SubAccountId", columnDefinition = "text")
    @CsvBindByName(column = "SubAccountId")
    private String SubAccountId;

    //@Enumerated(EnumType.STRING)
    //@Column(name = "SubAccountName", columnDefinition = "text")
   @CsvBindByName(column = "SubAccountName")
   private String SubAccountName;
  
  
    public void setSubAccountId(String subAccountId) {
        if (subAccountId != null && subAccountId.startsWith("/subscriptions/")) {
            this.SubAccountId = subAccountId.substring("/subscriptions/".length());
        } else {
            this.SubAccountId = subAccountId;
        }
    }

     


   // @Column(name = "Tags", length = 800)
    @CsvBindByName(column = "Tags")
    private String Tags;
}