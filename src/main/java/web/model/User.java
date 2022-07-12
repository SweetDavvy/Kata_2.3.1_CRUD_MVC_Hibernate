package web.model;


import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;


    @Column(name = "lastName")
    private String lastName;

    @Column(name = "age")
    private int age;

    public User(String name, String lastName, Integer age) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;

    }

    public User() {

    }

    public void setId(Long id) {

        this.id = id;
    }

    public void setName(String name) {

        this.name = name;
    }

    public void setLastName(String lastName) {

        this.lastName = lastName;
    }

    public void setAge(Integer age) {

        this.age = age;
    }

    public long getId() {

        return id;
    }

    public String getName() {

        return name;
    }

    public String getLastName() {

        return lastName;
    }

    public int getAge() {

        return age;
    }

    @Override
    public String toString() {
        return id +
                ", " + name +
                ", " + lastName +
                ", " + age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age && Objects.equals(id, user.id) && Objects.equals(name, user.name) && Objects.equals(lastName, user.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, lastName, age);
    }
}
