package org.example.models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Discount")
public class DiscountMenu extends Menu{

    private double percentDiscount;

    public DiscountMenu() {}
    public DiscountMenu(String dishName, double price, int weight, double percentDiscount){
        super(dishName, price, weight);
        this.percentDiscount = percentDiscount;
    }

    public double getPercentDiscount() {
        return percentDiscount;
    }
    public void setPercentDiscount(double percentDiscount) {
        this.percentDiscount = percentDiscount;
    }

    @Override
    public String toString(){
        return "DiscountMenu{id=" + getId() +
                ", dishName='" + getDishName() + '\'' +
                ", price=" + getPrice() +
                ", weight=" + getWeight() +
                ", percentDiscount=" + percentDiscount +
                "}";
//                super.toString().replace("}","") +
//                ", percent of discount="+percentDiscount+
//                "}";
    }
}
