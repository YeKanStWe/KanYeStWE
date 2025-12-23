package com.ebottini.microservicomemes.memes.repositories;

import com.ebottini.microservicomemes.memes.entities.CategoriaMeme;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaMemeRepository extends JpaRepository<CategoriaMeme, Long> {
}
