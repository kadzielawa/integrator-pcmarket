package integrator.Model;

import lombok.Getter;

import java.io.Serializable;
import java.util.HashMap;

@Getter
public class ProductDTO implements Serializable {

    private HashMap<String, String> productDetails = new HashMap<>();
    private HashMap<String, String> productImages = new HashMap<>();
    private String sku;
    private Integer price;
    private String stockUnit;
    private String brand;
    private String type;
    private String position;
    private String active;
    private String inStock;
    private String deliverable;
    private String trackStock;

    void setProductDetails(final ProductData productData) {
        this.productDetails.put("title", productData.getName());
        this.productDetails.put("language", "en");
        this.productDetails.put("shortDescription", productData.getDescription());
    }

    void setImages(final ProductData productData) {
        this.productImages.put("url",
                //na razie tymczasowy randomowy obrazek docelowo bedzie tutaj productData.getProductImages
                "http://3.bp.blogspot.com/-6LksHNiEWnE/UYRO_rkoz3I/AAAAAAAAC3Y/EKAXGoV9Dmc/s1600/singingintherainumbrella.jpg");
    }

    void setBasicInformation(final ProductData productData) {
        sku = productData.getSku();
        type = "Scannable";
        position = "1";
        active = "true";
        inStock = "true";
        trackStock = "false";
        deliverable = "false";
        stockUnit = "kg";
        price = getIntegerPrice(productData.getPrice());
        brand = productData.getManufacturer_id();
    }

    private Integer getIntegerPrice(String stringPrice){
        Float f = new Float("20.75f");
        Float tempPrice =  f.parseFloat(stringPrice) * 100;

        return  tempPrice.intValue();
    }

}
