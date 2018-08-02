package integrator.Api;

import integrator.Api.Method.AddProduct;
import integrator.Model.*;

public class ApiCaller {

    private final RootData marketData;
    private final ProductMapper productMapper;

    public ApiCaller(RootData marketData) {
        this.marketData = marketData;
        this.productMapper = new ProductMapper();
    }

    public void callProduct() {
        for (Products productsList : marketData.getList().getProducts()) {
            for (ProductData product : productsList.getProductData()) {
                ProductDTO dto = productMapper.mapToDto(product);
                AddProduct.create(productMapper.productToJSON(dto));
            }
        }
    }
}
