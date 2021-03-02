package com.epam.task.five.component;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Composite implements Component {
    private List<Component> components = new ArrayList<>();

    public Composite(List<Component> components) {
        this.components = components;
    }

    public Composite() {
    }

    public void add(Component component) {
        components.add(component);
    }

    public List<Component> getChildren() {
        return components;
    }

    public void remove(Component component) {
        components.remove(component);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Composite)) {
            return false;
        }
        Composite composite = (Composite) o;
        return Objects.equals(components, composite.components);
    }

    @Override
    public int hashCode() {
        return Objects.hash(components);
    }
}
