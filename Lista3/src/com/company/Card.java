package com.company;

/**
 * Created by matik on 17.03.2017.
 */
public class Card {
    private int value,color;
    private String colorName;
    private String valueName;
    private boolean hidden;

    public Card()
    {
        color=0;
        value=0;
        colorName=null;
        valueName=null;
        hidden=false;
    }

    public Card(int value, int color)
    {
        this.value=value;
        this.color=color;
        hidden=false;
        SetName();
    }

    private void SetName() {
        switch (value) {
            case 1:
                valueName = "As ";
                break;
            case 11:
                valueName = "Walet ";
                break;
            case 12:
                valueName = "Dama ";
                break;
            case 13:
                valueName = "Król ";
                break;
            case 14: {
                valueName = "{} ";
                hidden = true;
            }
            break;
            default:
                valueName = value + " ";
                break;
        }

        switch (color) {
            case 0:
                colorName = "Kier";
                break;
            case 1:
                colorName = "Karo";
                break;
            case 2:
                colorName = "Trefl";
                break;
            case 3:
                colorName = "Pik";
                break;
            default:
                colorName = "Nieznany";
                break;
        }
    }

    public static int getValueFromName(String colorName) {
        switch (colorName) {
            case "As":
                return 1;
            case "Walet":
                return 11;
            case "Dama":
                return 12;
            case "Król":
                return 13;
            case "{}": {
                return 14;
            }
            case "2":
            case "3":
            case "4":
            case "5":
            case "6":
            case "7":
            case "8":
            case "9":
            case "10":
                return Integer.parseInt(colorName);
            default:
                return 0;
        }
    }

        public static int getColorFromName(String valueName)
    {
        switch (valueName) {
            case "Kier":
                return 0;
            case "Karo":
                return 1;
            case "Trefl":
                return 2;
            case "Pik":
                return 3;
            default:
                return 0;
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
        return valueName+" "+colorName;
    }

}

