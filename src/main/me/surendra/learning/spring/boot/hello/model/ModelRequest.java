package me.surendra.learning.spring.boot.hello.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;

import java.util.Objects;

@JsonAutoDetect
public class ModelRequest {

    private long id;
    private String name;
    private String city;

    private ModelRequest(final long id, final String name) {
        this.id = id;
        this.name = name;
    }

    @JsonCreator
    public static ModelRequest create(final long id, final String name) {
        return new ModelRequest(id, name);
    }

    public long getId() {
        return id;
    }

    public void setId(final long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof ModelRequest)) return false;
        final ModelRequest that = (ModelRequest) o;
        return getId() == that.getId() &&
            Objects.equals(getName(), that.getName()) &&
            Objects.equals(getCity(), that.getCity());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getCity());
    }

    @Override
    public String toString() {
        return "ModelRequest{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", city='" + city + '\'' +
            '}';
    }
}
