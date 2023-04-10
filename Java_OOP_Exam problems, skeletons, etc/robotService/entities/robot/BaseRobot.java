package robotService.entities.robot;

import robotService.common.ExceptionMessages;

public abstract class BaseRobot implements Robot {
    //name, kind, kilograms, price
    private String name;
    private String kind;
    private int kilograms;
    private double price;

    public BaseRobot(String name, String kind, int kilograms, double price) {
        this.setName(name);
        this.setKind(kind);
        this.setPrice(price);
        this.kilograms = kilograms;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(ExceptionMessages.ROBOT_NAME_CANNOT_BE_NULL_OR_EMPTY);
        }
    }

    public String getKind() {
        return kind;
    }

    @Override
    public int getKilograms() {
        return this.kilograms;
    }


    @Override
    public double getPrice() {
        return price;
    }
    @Override
    abstract public void eating();

    public void setKind(String kind) {
        if (kind == null || kind.trim().isEmpty()) {
            throw new NullPointerException(ExceptionMessages.ROBOT_KIND_CANNOT_BE_NULL_OR_EMPTY);
        }
        this.kind = kind;
    }

    public void setPrice(double price) {
        if(price <= 0){
            throw new IllegalArgumentException(ExceptionMessages.ROBOT_PRICE_CANNOT_BE_BELOW_OR_EQUAL_TO_ZERO);
        }
        this.price = price;
    }

    public void setKilograms(int kilograms) {
        this.kilograms = kilograms;
    }
}
