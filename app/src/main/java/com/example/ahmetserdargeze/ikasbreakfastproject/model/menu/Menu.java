package com.example.ahmetserdargeze.ikasbreakfastproject.model.menu;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by ahmetserdargeze on 28.06.2018.
 */

public class Menu {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("sku")
    @Expose
    private Object sku;
    @SerializedName("barcode")
    @Expose
    private Object barcode;
    @SerializedName("sell_price")
    @Expose
    private Double sellPrice;
    @SerializedName("sell_price_without_tax")
    @Expose
    private Double sellPriceWithoutTax;
    @SerializedName("discount_price")
    @Expose
    private Object discountPrice;
    @SerializedName("discount_price_without_tax")
    @Expose
    private Integer discountPriceWithoutTax;
    @SerializedName("tax_id")
    @Expose
    private Integer taxId;
    @SerializedName("image_url")
    @Expose
    private Object imageUrl;
    @SerializedName("is_favorite")
    @Expose
    private Boolean isFavorite;
    @SerializedName("keep_stock")
    @Expose
    private Boolean keepStock;
    @SerializedName("branch_stock_count")
    @Expose
    private Object branchStockCount;
    @SerializedName("brand_name")
    @Expose
    private Object brandName;
    @SerializedName("variations")
    @Expose
    private List<Variation> variations = null;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getSku() {
        return sku;
    }

    public void setSku(Object sku) {
        this.sku = sku;
    }

    public Object getBarcode() {
        return barcode;
    }

    public void setBarcode(Object barcode) {
        this.barcode = barcode;
    }

    public Double getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(Double sellPrice) {
        this.sellPrice = sellPrice;
    }

    public Double getSellPriceWithoutTax() {
        return sellPriceWithoutTax;
    }

    public void setSellPriceWithoutTax(Double sellPriceWithoutTax) {
        this.sellPriceWithoutTax = sellPriceWithoutTax;
    }

    public Object getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(Object discountPrice) {
        this.discountPrice = discountPrice;
    }

    public Integer getDiscountPriceWithoutTax() {
        return discountPriceWithoutTax;
    }

    public void setDiscountPriceWithoutTax(Integer discountPriceWithoutTax) {
        this.discountPriceWithoutTax = discountPriceWithoutTax;
    }

    public Integer getTaxId() {
        return taxId;
    }

    public void setTaxId(Integer taxId) {
        this.taxId = taxId;
    }

    public Object getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(Object imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Boolean getIsFavorite() {
        return isFavorite;
    }

    public void setIsFavorite(Boolean isFavorite) {
        this.isFavorite = isFavorite;
    }

    public Boolean getKeepStock() {
        return keepStock;
    }

    public void setKeepStock(Boolean keepStock) {
        this.keepStock = keepStock;
    }

    public Object getBranchStockCount() {
        return branchStockCount;
    }

    public void setBranchStockCount(Object branchStockCount) {
        this.branchStockCount = branchStockCount;
    }

    public Object getBrandName() {
        return brandName;
    }

    public void setBrandName(Object brandName) {
        this.brandName = brandName;
    }

    public List<Variation> getVariations() {
        return variations;
    }

    public void setVariations(List<Variation> variations) {
        this.variations = variations;
    }
}
