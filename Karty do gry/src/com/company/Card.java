package com.company;

/**
 * Created by matik on 17.03.2017.
 */
public class Card {
    private int value,color;
    private String name;
    private boolean hidden;

    public Card()
    {
        color=0;
        value=0;
        name=null;
        hidden=false;

    }

    public Card(int value, int color)
    {
        this.value=value;
        this.color=color;
        hidden=false;
        SetName();
    }

    private void SetName()
    {
        switch (value) {
            case 1:
                name = "As ";
                break;
            case 11:
                name = "Walet ";
                break;
            case 12:
                name = "Dama ";
                break;
            case 13:
                name = "Król ";
                break;
            case 14: {
                name = "{} ";
                hidden = true;
            }
                break;
            default:
                name = value + " ";
                break;
        }

        switch (color) {
            case 0:
                name += "Kier";
                break;
            case 1:
                name += "Karo";
                break;
            case 2:
                name += "Trefl";
                break;
            case 3:
                name += "Pik";
                break;
            default:
                name += "Nieznany";
                break;
        }

        }

    public int getColor() {
        return color;
    }

    public int getValue() {
        return value;
    }

    public boolean isHidden() {
        return hidden;
    }

    public String toString(){
        return name;
    }
}

