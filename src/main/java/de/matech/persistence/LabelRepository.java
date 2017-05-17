package de.matech.persistence;

import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface LabelRepository extends CrudRepository<LabelEntity, UUID> {
}
