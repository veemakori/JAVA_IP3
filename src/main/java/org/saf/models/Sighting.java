package org.saf.models;
import java.util.Date;
public class Sighting {
    private Integer id;
    private String animal;
    private Boolean endangered;
    private String age;
    private String health;
    private String location;
    private String ranger;
    private Date time;
    private Boolean deleted;

    public void setId(Integer id) { this.id = id; }
    public void setAnimal(String animal) { this.animal = animal;}
    public void setEndangered(Boolean endangered) { this.endangered = endangered; }
    public void setAge(String age) { this.age = age; }
    public void setHealth(String health) { this.health = health; }
    public void setLocation(String location) { this.location = location; }
    public void setRanger(String ranger) { this.ranger = ranger; }
    public void setTime(Date time) { this.time = time; }
    public void setDeleted(Boolean deleted) { this.deleted = deleted; }


    public Integer getId() { return id; }
    public String getAnimal() { return animal; }
    public Boolean getEndangered() { return endangered;}
    public String getAge() { return age; }
    public String getHealth() { return health; }
    public String getLocation() { return location; }
    public String getRanger() { return ranger; }
    public Date getTime() { return time; }
    public Boolean getDeleted() { return deleted; }

    public Sighting() {
        super();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }

    public Sighting(Integer id, String animal, Boolean endangered, String age, String health, String location, String ranger, Date time, Boolean deleted) {
        this.id = id;
        this.animal = animal;
        this.endangered = endangered;
        this.age = age;
        this.health = health;
        this.location = location;
        this.ranger = ranger;
        this.time = time;
        this.deleted = deleted;
    }

}
