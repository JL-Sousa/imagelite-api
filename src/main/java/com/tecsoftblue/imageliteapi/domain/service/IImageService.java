package com.tecsoftblue.imageliteapi.domain.service;

import com.tecsoftblue.imageliteapi.domain.entity.Image;
import com.tecsoftblue.imageliteapi.domain.enums.ImageExtension;

import java.util.List;
import java.util.Optional;

public interface IImageService {

    Image save(Image image);

    Optional<Image> getById(String id);

    List<Image> search(ImageExtension extension, String query);
}
