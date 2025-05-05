package com.example.green.controller.product;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.example.green.model.product.*;
import com.example.green.repository.product.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.*;
import java.util.List;

@RestController
@RequestMapping("/green.by")
@CrossOrigin(origins = "http://localhost:4200")
public class ProductController {

    @Autowired private ProductRepo           productRepo;
    @Autowired private ProductTypeRepo       productTypeRepo;
    @Autowired private ProductCategoryRepo   productCategoryRepo;
    @Autowired private ProductSubcategoryRepo productSubcategoryRepo;
    @Autowired private ProductMakerRepo      productMakerRepo;

    /* ---------------- catalog / главная ---------------- */

    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    @GetMapping(value = "/catalog", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ProductType> getAllTypes() {
        return productTypeRepo.findAll();
    }

    @GetMapping(value = "/catalog/{type}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ProductCategory> getCategoriesByType(@PathVariable String type) {
        return productCategoryRepo.findByProductTypeC_ProductTypeEngName(type);
    }

    @GetMapping(value = "/catalog/product/{type}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Product> getProductsByType(@PathVariable String type) {
        return productRepo.findByProductType_ProductTypeEngName(type);
    }

    @GetMapping(value = "/catalog/{type}/{category}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ProductSubcategory> getSubcategoryByTypeAndCategory(@PathVariable String category) {
        return productSubcategoryRepo.findAllByProductCategoryS_ProductCategoryEngName(category);
    }

    @GetMapping(value = "/catalog/product/{type}/{category}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Product> getProductsByCategory(@PathVariable String type,
                                               @PathVariable String category) {
        return productRepo.findByProductType_ProductTypeEngNameAndProductCategory_ProductCategoryEngName(type, category);
    }

    @GetMapping(value = "/catalog/product/{type}/{category}/{subCategory}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Product> getProductsBySubcategory(@PathVariable String type,
                                                  @PathVariable String category,
                                                  @PathVariable String subCategory) {
        return productRepo.findByProductType_ProductTypeEngNameAndProductCategory_ProductCategoryEngNameAndProductSubcategory_ProductSubcategoryEngName(type, category, subCategory);
    }

    /* ---------------- изображения товара ---------------- */

    /**
     * Отдаёт файл-картинку товара.
     * В БД хранится «/images/pasta/fillini-vermicelli-400g.jpg».
     * Базовая директория на диске задаётся константой BASE_DIR.
     */
    private static final Path BASE_DIR = Paths.get("D:/green");

    @GetMapping("/image/{id}")
    public void image(@PathVariable Long id, HttpServletResponse resp) throws IOException {

        Product product = productRepo.findById(id)
        .orElseThrow(() -> new RuntimeException("Product id = " + id + " not found"));

        // убираем ведущий «/», если есть
        String rel = product.getProductImage().startsWith("/")
                     ? product.getProductImage().substring(1)
                     : product.getProductImage();

        Path file = BASE_DIR.resolve(rel);


        if (!Files.exists(file)) {                         // 404 если файла нет
            resp.setStatus(HttpStatus.NOT_FOUND.value());
            return;
        }

        // MIME-тип
        String mime = Files.probeContentType(file);        // image/jpeg, image/png …
        resp.setContentType(mime != null ? mime : "application/octet-stream");
        resp.setHeader("Cache-Control", "max-age=86400");

        try (InputStream in = Files.newInputStream(file)) {
            IOUtils.copy(in, resp.getOutputStream());
        }
    }

    /* ---------------- справочники ---------------- */

    @GetMapping("/makers")
    public List<ProductMaker> getAllProductMakers() {
        return productMakerRepo.findAll();
    }

    @GetMapping("/categories")
    public List<ProductCategory> getAllCategories() {
        return productCategoryRepo.findAll();
    }

    @GetMapping("/subCategories")
    public List<ProductSubcategory> getAllSubCategories() {
        return productSubcategoryRepo.findAll();
    }

    /* ---------------- карточка товара ---------------- */

    @GetMapping("/product/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productRepo.getOne(id);
    }

    /* ---------------- загрузка новой картинки (админ) --- */

    @PostMapping("/image/add")
    @ResponseStatus(HttpStatus.OK)
    public void addImage(@RequestParam("file") MultipartFile file) throws IOException {
        if (file.isEmpty()) return;

        Path saveTo = BASE_DIR.resolve(file.getOriginalFilename());
        Files.createDirectories(saveTo.getParent());
        Files.copy(file.getInputStream(), saveTo, StandardCopyOption.REPLACE_EXISTING);
    }
}
