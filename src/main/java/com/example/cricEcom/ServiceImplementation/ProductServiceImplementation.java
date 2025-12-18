package com.example.cricEcom.ServiceImplementation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import com.example.cricEcom.Mapper.SubCategoryMapper;
import com.example.cricEcom.entities.Category;
import com.example.cricEcom.entities.SubCategory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.cricEcom.Mapper.ProductMapper;
import com.example.cricEcom.Repo.ImageRepo;
import com.example.cricEcom.Repo.ProductRepo;
import com.example.cricEcom.Repo.SubCategoryRepo;
import com.example.cricEcom.RequestDto.AddStockRequestDto;
import com.example.cricEcom.RequestDto.ProductRequestDto;
import com.example.cricEcom.RequestDto.ProductTypeRequestDto;
import com.example.cricEcom.ResponsDto.ImageResponseDto;
import com.example.cricEcom.ResponsDto.ProductResponseDto;
import com.example.cricEcom.ResponsDto.ProductTypeResponseDto;
import com.example.cricEcom.Service.ProductService;
import com.example.cricEcom.Service.ProductTypeService;
import com.example.cricEcom.entities.Product;
import com.example.cricEcom.entities.ProductImage;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductServiceImplementation implements ProductService{
	
	
	
	
	private final ProductRepo productRepo;
	private final ProductMapper productMapper;
	private final ImageRepo imageRepo;
	private final SubCategoryRepo subCategoryRepo;
	private final SubCategoryMapper subCategoryMapper;

	
	
	@Override
	public ProductResponseDto AddProduct(ProductRequestDto dto, List<MultipartFile> images) throws IOException {

	    // 1. Fetch ProductType
	Product product = productMapper.toEntity(dto);

	SubCategory subcategory =subCategoryRepo.findByName(dto.subcategoryName())
				.orElseThrow(() -> new RuntimeException("Type not found"));

		product.setSubCategory(subcategory);

		productRepo.save(product);
	    // 2. Convert DTO → Entity

//	    product.setProductType(type);

	    // 3. Save product first
	    Product saved = productRepo.save(product);

	    // 4. Prepare image list
	    List<ProductImage> imageList = new ArrayList<>();

	    // 5. Convert MultipartFile → Base64 and save into DB
	    for (MultipartFile file : images) {

	        String base64 = 
	                "data:" + file.getContentType() + ";base64," +
	                Base64.getEncoder().encodeToString(file.getBytes());

	        ProductImage img = new ProductImage();
	        img.setProduct(saved);              // VERY IMPORTANT
	        img.setProductImageUrl(base64);

	        imageRepo.save(img);
	        imageList.add(img);

	        System.out.println("BASE64 LENGTH = " + base64.length());
	    }

	    // 6. Attach images to product  
	    saved.setImages(imageList);

	    // 7. Return DTO
	    return productMapper.toDto(saved);
	}    

	@Override
	public List<ProductResponseDto> getAll() {
		
				return productRepo.findAll()
						.stream()
	                    .map(productMapper::toDto)
	                    .toList();
	}
	
	@Override
	public String addStock(AddStockRequestDto dto) {
		 Product product = productRepo.findById(dto.productId())
		            .orElseThrow(() -> new RuntimeException("Product not found"));

		    if (dto.quantityToAdd() <= 0) {
		        throw new RuntimeException("Quantity must be greater than zero");
		    }

//		    product.setStockQuantity(product.getStockQuantity() + dto.quantityToAdd());
//
//		    if (!product.isAvailability() && product.getStockQuantity() > 0) {
//		        product.setAvailability(true);
//		    }

//		    productRepo.save(product);  // <--- YOU FORGOT THIS

		    return "Stock Add Successfully";
	
	}
}