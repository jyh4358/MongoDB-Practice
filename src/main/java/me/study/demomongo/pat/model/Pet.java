package me.study.demomongo.pat.model;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Getter
@ToString
@Document
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Pet {

    @Id
    private String id;

    private String kind;
    private String name;
    private int age;

    private List<Pet> sibling = new ArrayList<>();

    @Builder
    public Pet(String kind, String name, int age, List<Pet> sibling) {
        this.kind = kind;
        this.name = name;
        this.age = age;
        this.sibling = sibling;
    }

    public void updatePet(String kind, String name, int age) {
        this.kind = kind;
        this.name = name;
        this.age = age;
    }
}
