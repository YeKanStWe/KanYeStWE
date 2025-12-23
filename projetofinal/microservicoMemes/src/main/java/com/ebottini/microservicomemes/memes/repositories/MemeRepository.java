package com.ebottini.microservicomemes.memes.repositories;

import com.ebottini.microservicomemes.memes.entities.Meme;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemeRepository extends JpaRepository<Meme, Long> {
}
