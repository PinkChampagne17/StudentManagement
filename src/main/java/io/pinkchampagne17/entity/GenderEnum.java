package io.pinkchampagne17.entity;

public enum GenderEnum {
    MALE(0), FEMALE(1), OTHER(2), SECRET(3);

    private int gender;

    GenderEnum(int gender) {
        this.gender = gender;
    }

    public int getGender() {
        return this.gender;
    }
}
