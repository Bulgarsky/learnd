package com.example.market.services;

import com.example.market.models.Image;
import com.example.market.models.Product;
import com.example.market.repositories.ImageRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ImageService {
    private final ImageRepository imageRepository;

    public ImageService(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    @Transactional
    public void deleteImage(int id){
        imageRepository.deleteById(id);
    }

    public List<Image> findImagesByProductId(int product_id) {
        List<Image> imageList = imageRepository.findAllByProduct_Id(product_id);
        return imageList;
    }
}
