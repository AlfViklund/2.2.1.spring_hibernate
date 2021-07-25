package hiber.model;

import javax.persistence.*;

import javax.persistence.Entity;

@Entity
@Table(name = "car")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "model")
    private String model;

    @Column(name = "series")
    private int series;
/*
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }*/

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id;}

    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }

    public int getSeries() { return series; }
    public void setSeries(int series) { this.series = series; }

    public Car() {}

    public Car(String model, int series) {
        this.model = model;
        this.series = series;
    }
}
