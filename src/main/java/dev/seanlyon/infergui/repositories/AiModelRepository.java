package dev.seanlyon.infergui.repositories;


import dev.seanlyon.infergui.models.AiModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AiModelRepository extends JpaRepository<AiModel, Long> {

    List<AiModel> findByOwner(String owner);
}
