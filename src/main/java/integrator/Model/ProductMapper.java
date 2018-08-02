package integrator.Model;

import org.json.JSONArray;
import org.json.JSONObject;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

import java.util.Map;

public class ProductMapper {

    private static ModelMapper modelMapper;

    public ProductMapper() {
        modelMapper = new ModelMapper();
        modelMapper.addMappings(new PropertyMap<ProductData, ProductDTO>() {
            @Override
            protected void configure() {
                map().setProductDetails(source.getObjectData());
                map().setBasicInformation(source.getObjectData());
                map().setImages(source.getObjectData());
            }
        });
    }

    public ProductDTO mapToDto(ProductData productData) {

        return modelMapper.map(productData, ProductDTO.class);
    }

    public String productToJSON(ProductDTO productModel) {
        Map<String, String> productDetails = productModel.getProductDetails();
        JSONArray productDetailsJsonArray = new JSONArray();
        productDetailsJsonArray.put(productDetails);
        JSONArray imagesJsonArray = new JSONArray();
        Map<String, String> productImages = productModel.getProductImages();
        imagesJsonArray.put(productImages);

        JSONObject jsonObject = new JSONObject(productModel).put("productDetails", productDetailsJsonArray).put("images", imagesJsonArray);

        return jsonObject.toString();
    }
}
