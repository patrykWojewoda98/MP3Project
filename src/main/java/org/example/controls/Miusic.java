package org.example.controls;

public class Miusic implements Comparable<Miusic> {
    private String name;
    private String localization;

    public Miusic(){}

    public Miusic(String name, String localization) {
        this.name = name;
        this.localization = localization;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocalization() {
        return localization;
    }

    public void setLocalization(String localization) {
        this.localization = localization;
    }

    @Override
    public int compareTo(Miusic o) {
        return name.compareTo(o.name);
    }

    @Override
    public String toString() {
        return "Title:" + name + ' ' +
                "localization: " + localization;
    }
}
