package me.study.demomongo.example3.pat;

import me.study.demomongo.example3.common.BaseMongoTest;
import me.study.demomongo.pat.model.Pet;
import me.study.demomongo.pat.repository.PetRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PetRepositoryTest extends BaseMongoTest {

    @Autowired
    PetRepository petRepository;

    @AfterEach
    public void tearDown() throws Exception {
        mongoTemplate.dropCollection(Pet.class);
    }

    @DisplayName("Pet 저장 후 조회 테스트")
    @Test
    public void insertTest() {

        // given
        Pet pet = Pet.builder().kind("Cat").name("나비").age(2).build();
        petRepository.save(pet);
        petRepository.insert(pet);


        // when & then
        Pet findPet = petRepository.findById(pet.getId()).get();

        assertThat(pet.getId()).isEqualTo(findPet.getId());
        assertThat(pet.getName()).isEqualTo(findPet.getName());
        assertThat(pet.getKind()).isEqualTo(findPet.getKind());
        assertThat(pet.getAge()).isEqualTo(findPet.getAge());

    }

    @DisplayName("Pet 전체 조회 테스트")
    @Test
    public void findAllTest() {

        //given
        List<Pet> pets = getPets();

        petRepository.saveAll(pets);

        //when
        List<Pet> findPets = petRepository.findAll();

        //then
        assertThat(findPets.size()).isEqualTo(5);
    }

    @DisplayName("Pet 정보 수정 테스트")
    @Test
    public void updateNameTest() {

        // given
        Pet pet = Pet.builder().kind("Cat").name("나비").age(2).build();
        petRepository.save(pet);

        // when
        pet.updatePet("Cat", "나비이", 5);
        petRepository.save(pet);

        // then
        Pet findPet = petRepository.findById(pet.getId()).get();
        assertThat(findPet.getName()).isEqualTo(pet.getName());
    }

    @DisplayName("Pet 삭제 테스트")
    @Test
    public void deleteTest() {

        //given
        List<Pet> pets = getPets();

        petRepository.saveAll(pets);

        //when
        petRepository.deleteAll(pets);

        //then
        List<Pet> findPets = petRepository.findAll();
        assertThat(findPets.size()).isEqualTo(0);
    }


    @DisplayName("Pet 컬렉션을 멤버변수로 가지고 있는 Pet 객체를 저장 테스트")
    @Test
    public void insertSiblingTest() {

        //given
        List<Pet> sibling = getPets();
        Pet pet = Pet.builder().kind("Dog").age(0).name("랑이").sibling(sibling).build();
        petRepository.save(pet);

        //when & then
        Pet findPet = petRepository.findById(pet.getId()).get();
        assertThat(findPet.getSibling().size()).isEqualTo(5);

    }




    private List<Pet> getPets() {
        List<Pet> pets = Arrays.asList(
                Pet.builder().kind("Dog").name("멍멍이").age(1).build(),
                Pet.builder().kind("Dog").name("아지").age(2).build(),
                Pet.builder().kind("Dog").name("깜돌이").age(5).build(),
                Pet.builder().kind("Cat").name("야옹이").age(4).build(),
                Pet.builder().kind("Cat").name("나비").age(2).build()
        );
        return pets;
    }
}
