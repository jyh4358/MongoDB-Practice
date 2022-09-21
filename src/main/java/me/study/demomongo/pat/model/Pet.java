package me.study.demomongo.pat.model;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Document
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Pet {

    @Id
    private String id;

    private String kind;
    private String name;
    private int age;

    @Builder
    public Pet(String kind, String name, int age) {
        this.kind = kind;
        this.name = name;
        this.age = age;
    }

    public void updatePet(String kind, String name, int age) {
        this.kind = kind;
        this.name = name;
        this.age = age;
    }
}
