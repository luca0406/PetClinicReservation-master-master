package ro.fasttrackit.finalproject.petclinicreservation.model.entity;

import ro.fasttrackit.finalproject.petclinicreservation.model.ReservationType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Reservation {
  @Id
  @GeneratedValue
  private Integer id;

  private String name;
  private double price;
  private ReservationType type;

  public Reservation(){

  }

  public Reservation( String name, double price, ReservationType type ){
    this.name = name;
    this.price = price;
    this.type = type;
  }
  public Integer getId(){
    return id;
  }

  public void setId( Integer id ){
    this.id = id;
  }

  public String getName(){
    return name;
  }

  public void setName( String name ){
    this.name = name;
  }

  public double getPrice(){
    return price;
  }

  public void setPrice( double price ){
    this.price = price;
  }

  public ReservationType getType(){
    return type;
  }

  public void setType( ReservationType type ){
    this.type = type;
  }



  @Override
  public String toString(){
    return "Reservation{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", price=" + price +
            ", type=" + type +
            '}';
  }
}