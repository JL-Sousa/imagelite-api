package com.tecsoftblue.imageliteapi.application.images;

import com.tecsoftblue.imageliteapi.domain.entity.Image;
import com.tecsoftblue.imageliteapi.domain.enums.ImageExtension;
import com.tecsoftblue.imageliteapi.domain.service.IImageService;
import com.tecsoftblue.imageliteapi.infra.repository.ImageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ImageServiceImpl implements IImageService {

    private final ImageRepository repository;

    @Override
    @Transactional
    public Image save(Image image) {
        return repository.save(image);
    }

    @Override
    public Optional<Image> getById(String id) {
        return repository.findById(id);
    }

    @Override
    public List<Image> search(ImageExtension extension, String query) {
        return repository.findByExtensionAndNameOrTagsLike(extension, query);
    }
}
