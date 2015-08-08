package com.meibaorui.manygirlfriends.bean;

/**
 * Created by meibaorui on 2015/8/5.
 */
public class GirlFriend {
    private final int nameMaxLength = 5;
    private final int nameMinLength = 1;
    private final int ageMaxValue = 150;
    private String name;
    private int age;


    public GirlFriend(String name, int age) throws NameLengthOutOfRangeException, AgeOutOfRangeException {
        this.setName(name);
        this.setAge(age);
    }

    private void setName(String name) throws NameLengthOutOfRangeException {
        if (name.length() > nameMaxLength || name.length() < nameMinLength) {
            throw (new NameLengthOutOfRangeException(nameMinLength, nameMaxLength));
        }

        this.name = name;
    }

    private void setAge(int age) throws AgeOutOfRangeException {
        if (age > ageMaxValue) {
            throw (new AgeOutOfRangeException(ageMaxValue));
        }
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }


    public String toString() {
        String nameStr = "name:" + name + ",";
        String ageStr = "age:" + age;
        String blankStr = "      ";
        blankStr = blankStr.substring(0, nameMaxLength - name.length() + 1);
        return nameStr + blankStr + ageStr;
    }

    /**
     * 年龄超过范围异常
     */
    public class AgeOutOfRangeException extends Exception {
        public AgeOutOfRangeException() {
            super("Age is out of range.");
        }

        public AgeOutOfRangeException(int minAge, int maxAge) {
            super("Age must greater than " + (minAge - 1) + " and less than " + (maxAge + 1));
        }

        public AgeOutOfRangeException(int maxAge) {
            super("Age must greater than -1 and less than " + (maxAge + 1));
        }
    }

    /**
     * 名字长度长过范围异常
     */
    public class NameLengthOutOfRangeException extends Exception {
        public NameLengthOutOfRangeException() {
            super("The length of name is out of range.");
        }

        public NameLengthOutOfRangeException(int minLength, int maxLength) {
            super("The length of name must greater than " + (minLength - 1) + " and less than " + (maxLength + 1));
        }

        public NameLengthOutOfRangeException(int maxLength) {
            super("The length of name must greater than 0 and less than " + (maxLength + 1));
        }
    }
}
