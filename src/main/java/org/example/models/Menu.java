package org.example.models;

import javax.persistence.*;

@Entity
@Table(name = "Menus")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) // default
@DiscriminatorColumn(name = "Discount",
        discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue(value = "true")
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;
    @Column(nullable = false)
    private String dishName;
    @Column(nullable = false)
    private double price;
    @Column(nullable = false)
    private int weight;

    public Menu() {}

    public Menu(String dishName, double price, int weight){
        this.dishName = dishName;
        this.price = price;
        this.weight = weight;
    }

    public Long getId() {
        return id;
    }
    public String getDishName() {
        return dishName;
    }
    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    public int getWeight() {
        return weight;
    }
    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString(){
        return "Menu{id="+id+", " +
                "dishName='"+dishName+"', " +
                "price="+price+", " +
                "weight="+weight+
                "}";
    }
}
