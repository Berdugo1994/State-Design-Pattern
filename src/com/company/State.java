package com.company;

public interface State {
    public void entry();
    public void exit();
    public void tm(int x);
    public void TempChanged(double r, double c);

}
