package com.ycit.innerclass;

/**
 * Created by xlch on 2017/1/25.
 */
public abstract class PropertySource<T> {

    @SuppressWarnings(value = "unchecked")
    public PropertySource(String name) {
        this(name, (T)new Object());
    }

    public PropertySource(String name, T source) {
        this.name = name;
        this.source = source;
    }

    private String name;

    private T source;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public T getSource() {
        return source;
    }

    public void setSource(T source) {
        this.source = source;
    }

    public abstract Object getProperty(String name);

    public static class StubPropertySource extends PropertySource<Object> {

        private StubPropertySource s = new StubPropertySource("file");

        public StubPropertySource(String name) {
            super(name, new Object());
        }

        public Object getProperty(String name) {
            return null;
        }
    }

}
