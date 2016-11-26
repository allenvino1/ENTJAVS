package apc.entjava.quiz1.businesslogic;

/**
 * Created by Allen Baldovino on 11/25/2016.
 */
import javax.faces.bean.*;
@ManagedBean
public class NumGenerator {
    public double getRandomNum() {
        return(Math.random());
    }
}