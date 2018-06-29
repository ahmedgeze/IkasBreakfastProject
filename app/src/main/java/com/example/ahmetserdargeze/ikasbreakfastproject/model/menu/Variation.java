package com.example.ahmetserdargeze.ikasbreakfastproject.model.menu;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by ahmetserdargeze on 28.06.2018.
 */

public class Variation {
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
    private Float sellPrice;
    @SerializedName("sell_price_without_tax")
    @Expose
    private Double sellPriceWithoutTax;
    @SerializedName("discount_price")
    @Expose
    private Object discountPrice;
    @SerializedName("discount_price_without_tax")
    @Expose
    private Integer discountPriceWithoutTax;
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
    @SerializedName("parent_id")
    @Expose
    private Integer parentId;
    @SerializedName("variation_1_id")
    @Expose
    private Integer variation1Id;
    @SerializedName("variation_2_id")
    @Expose
    private Object variation2Id;

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

    public float getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(float sellPrice) {
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

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getVariation1Id() {
        return variation1Id;
    }

    public void setVariation1Id(Integer variation1Id) {
        this.variation1Id = variation1Id;
    }

    public Object getVariation2Id() {
        return variation2Id;
    }

    public void setVariation2Id(Object variation2Id) {
        this.variation2Id = variation2Id;
    }
}
