package io.pinkchampagne17.entity;

public enum GenderEnum {
    SECRET(0), MALE(1), FEMALE(2), OTHER(3);

    private int gender;

    GenderEnum(int gender) {
        this.gender = gender;
    }

    public int getGender() {
        return this.gender;
    }
}
