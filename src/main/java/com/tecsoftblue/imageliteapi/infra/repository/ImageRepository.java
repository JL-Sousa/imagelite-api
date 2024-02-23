package com.tecsoftblue.imageliteapi.infra.repository;

import com.tecsoftblue.imageliteapi.domain.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, String> {
}
