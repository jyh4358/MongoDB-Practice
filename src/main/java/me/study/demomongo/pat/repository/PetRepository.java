package me.study.demomongo.pat.repository;

import me.study.demomongo.pat.model.Pet;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PetRepository extends MongoRepository<Pet, String> {
}
