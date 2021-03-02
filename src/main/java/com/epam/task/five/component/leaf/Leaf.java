package com.epam.task.five.component.leaf;

import com.epam.task.five.component.Component;

import java.util.Objects;

public class Leaf implements Component {
    private final LeafEnum leafType;
    private final String lexeme;

    public void add(Component component) {

    }

    public String getChildren() {
        return lexeme;
    }

    public void remove(Component component) {

    }

    public Leaf(LeafEnum type, String lexeme) {
        this.leafType = type;
        this.lexeme = lexeme;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Leaf)) return false;
        Leaf leaf = (Leaf) o;
        return leafType == leaf.leafType &&
                Objects.equals(lexeme, leaf.lexeme);
    }

    @Override
    public int hashCode() {
        return Objects.hash(leafType, lexeme);
    }
}
