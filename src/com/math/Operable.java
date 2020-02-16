package com.math;

public interface Operable{
    public Operable add(Operable B);
    public Operable minus(Operable B);
    public Operable multiply(Operable B);
    public Operable divide(Operable B);
    public String show();
}
