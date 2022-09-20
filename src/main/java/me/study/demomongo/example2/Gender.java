package me.study.demomongo.example2;

public enum Gender {
    MALE("남자"),
    FEMALE("여자");

    private String desc;

    Gender(String desc) {
        this.desc = desc;
    }
}
