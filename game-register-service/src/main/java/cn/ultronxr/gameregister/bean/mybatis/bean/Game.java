package cn.ultronxr.gameregister.bean.mybatis.bean;

import java.math.BigDecimal;
import java.util.Date;

public class Game {
    private Integer id;

    private String name;

    private String nameEng;

    private String nameNick;

    private String nameBak;

    private String description;

    private String tag;

    private String url;

    private String logo;

    private String img;

    private String developer;

    private String publisher;

    private String lowestPriceCurrency;

    private BigDecimal lowestPrice;

    private BigDecimal lowestPriceRmb;

    private Integer boughtAccountId;

    private Date purchaseDate;

    private String purchasePriceCurrency;

    private BigDecimal purchasePrice;

    private BigDecimal purchasePriceRmb;

    private String actualShop;

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
        this.name = name == null ? null : name.trim();
    }

    public String getNameEng() {
        return nameEng;
    }

    public void setNameEng(String nameEng) {
        this.nameEng = nameEng == null ? null : nameEng.trim();
    }

    public String getNameNick() {
        return nameNick;
    }

    public void setNameNick(String nameNick) {
        this.nameNick = nameNick == null ? null : nameNick.trim();
    }

    public String getNameBak() {
        return nameBak;
    }

    public void setNameBak(String nameBak) {
        this.nameBak = nameBak == null ? null : nameBak.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag == null ? null : tag.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo == null ? null : logo.trim();
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img == null ? null : img.trim();
    }

    public String getDeveloper() {
        return developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer == null ? null : developer.trim();
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher == null ? null : publisher.trim();
    }

    public String getLowestPriceCurrency() {
        return lowestPriceCurrency;
    }

    public void setLowestPriceCurrency(String lowestPriceCurrency) {
        this.lowestPriceCurrency = lowestPriceCurrency == null ? null : lowestPriceCurrency.trim();
    }

    public BigDecimal getLowestPrice() {
        return lowestPrice;
    }

    public void setLowestPrice(BigDecimal lowestPrice) {
        this.lowestPrice = lowestPrice;
    }

    public BigDecimal getLowestPriceRmb() {
        return lowestPriceRmb;
    }

    public void setLowestPriceRmb(BigDecimal lowestPriceRmb) {
        this.lowestPriceRmb = lowestPriceRmb;
    }

    public Integer getBoughtAccountId() {
        return boughtAccountId;
    }

    public void setBoughtAccountId(Integer boughtAccountId) {
        this.boughtAccountId = boughtAccountId;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public String getPurchasePriceCurrency() {
        return purchasePriceCurrency;
    }

    public void setPurchasePriceCurrency(String purchasePriceCurrency) {
        this.purchasePriceCurrency = purchasePriceCurrency == null ? null : purchasePriceCurrency.trim();
    }

    public BigDecimal getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(BigDecimal purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public BigDecimal getPurchasePriceRmb() {
        return purchasePriceRmb;
    }

    public void setPurchasePriceRmb(BigDecimal purchasePriceRmb) {
        this.purchasePriceRmb = purchasePriceRmb;
    }

    public String getActualShop() {
        return actualShop;
    }

    public void setActualShop(String actualShop) {
        this.actualShop = actualShop == null ? null : actualShop.trim();
    }
}