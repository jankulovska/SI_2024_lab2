import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SILab2Test {
    private List<Item> createItems(Item... items) {
        return new ArrayList<>(Arrays.asList(items));
    }

    @Test
    void EveryBranchTest(){
        RuntimeException ex;
        //FIRST TEST CASE - EMPTY LIST
        ex = assertThrows(RuntimeException.class, () -> SILab2.checkCart(null, 100));
        assertTrue(ex.getMessage().contains("allItems list can't be null!"));

        //SECOND TEST CASE - CHARACTER IN BARCODE
        ex = assertThrows(RuntimeException.class, () -> SILab2.checkCart( createItems(new Item("item1", "012a", 100, 0)),100));
        assertTrue(ex.getMessage().contains("Invalid character in item barcode!"));

        //THIRD TEST CASE - NAME IS NULL
        assertTrue(SILab2.checkCart( createItems(new Item(null, "123", 100, 0)),100));

        //FOURTH TEST CASE - NO BARCODE
        ex = assertThrows(RuntimeException.class, () -> SILab2.checkCart( createItems(new Item("item1", null, 100, 0)),100));
        assertTrue(ex.getMessage().contains("No barcode!"));

        //FIFTH TEST CASE - ALL GOOD - RETURN FALSE
        assertFalse(SILab2.checkCart( createItems(new Item("item1", "012", 350, 0.5F)),100));

    }
    @Test
    void MultipleConditionTest(){

        RuntimeException ex;
        //TTT
        assertFalse(SILab2.checkCart( createItems(new Item("item", "012", 350, 0.5f)),100));
        //TTF
        assertFalse(SILab2.checkCart( createItems(new Item("item", "123", 350, 0.5f)),100));
        //TFX
        assertFalse(SILab2.checkCart( createItems(new Item("item", "123", 350, 0)),100));
        //FXX
        assertFalse(SILab2.checkCart( createItems(new Item("item", "123", 250, 0)),100));

    }

}