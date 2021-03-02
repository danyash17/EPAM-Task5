package com.epam.task.five.component;

public interface Component {
    public void add(Component component);

    public Object getChildren();


    public void remove(Component component);
}
