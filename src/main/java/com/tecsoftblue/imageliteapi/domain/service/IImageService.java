package com.tecsoftblue.imageliteapi.domain.service;

import com.tecsoftblue.imageliteapi.domain.entity.Image;

import java.util.Optional;

public interface IImageService {

    Image save(Image image);

    Optional<Image> getById(String id);
}
