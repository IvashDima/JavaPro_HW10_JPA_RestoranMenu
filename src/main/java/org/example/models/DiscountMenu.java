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
}
