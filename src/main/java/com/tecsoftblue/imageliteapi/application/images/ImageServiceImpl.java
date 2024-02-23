package com.tecsoftblue.imageliteapi.application.images;

import com.tecsoftblue.imageliteapi.domain.entity.Image;
import com.tecsoftblue.imageliteapi.domain.service.IImageService;
import com.tecsoftblue.imageliteapi.infra.repository.ImageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ImageServiceImpl implements IImageService {

    private final ImageRepository repository;

    @Override
    @Transactional
    public Image save(Image image) {
        return repository.save(image);
    }
}