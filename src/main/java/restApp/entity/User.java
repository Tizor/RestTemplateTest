package restApp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class User implements Serializable {

    @Id
    @Column(name = "customer_number")
    private Long customerNumber;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private Long age;

    @Column(name = "city")
    private String city;

    public User(Long customerNumber, String name) {
        this.customerNumber = customerNumber;
        this.name = name;
    }

    public User(Long customerNumber, Long age, String city) {
        this.customerNumber = customerNumber;
        this.age = age;
        this.city = city;
    }
}
