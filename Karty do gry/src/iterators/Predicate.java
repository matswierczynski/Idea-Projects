package iterators;;
import com.company.Card;
import static java.lang.Integer.parseInt;

/**
 * Created by matik on 18.03.2017.
 */
public class Predicate {
    private String condition;
    private int value;
    private String StringToInt;

    public Predicate() {
        condition = null;
        value=0;
        StringToInt=null;
    }

    public void acceptCondition(String condition, String value) {
        this.condition = condition;
        StringToInt = value;
        try {
            translateCondition();
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }
    }

    public void translateCondition() {
        switch (StringToInt) {
            case "As":
                value = 1;
                break;
            case "Walet":
                value = 11;
                break;
            case "Dama":
                value = 12;
                break;
            case "Król":
                value = 13;
                break;
            case "{}":
                value = 14;
                break;
            case "Kier":
                value = 0;
                break;
            case "Karo":
                value = 1;
                break;
            case "Trefl":
                value = 2;
                break;
            case "Pik":
                value = 3;
                break;
            default: {
                try {
                    value = parseInt(StringToInt);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }

            break;
        }
    }

    public boolean accept(Object ob) {
        switch (condition) {

            case "Color":
                return ((Card) ob).getColor() == value && !((Card) ob).isHidden();
            case "Value":
                return ((Card) ob).getValue() == value && !((Card) ob).isHidden();
            default:
                    return false;
        }


    }
}
