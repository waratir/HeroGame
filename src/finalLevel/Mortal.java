package finalLevel;

public interface Mortal {

    boolean isAlive ();

    default double calculateDamage (double minValue, double maxValue){
        return (double) Math.round(((minValue + Math.random() * maxValue) * 10.0) / 10.0);
    }
}
