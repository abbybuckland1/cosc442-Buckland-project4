package edu.towson.cis.cosc442.project4.coffeemaker;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class RecipeTest {

    Recipe myRecipe;

    @BeforeEach 
    void setUp(){
        myRecipe = new Recipe();
        myRecipe.setName("Mocha Latte");
        myRecipe.setPrice(5);
        myRecipe.setAmtCoffee(2);
        myRecipe.setAmtMilk(3);
        myRecipe.setAmtSugar(1);
        myRecipe.setAmtChocolate(2);
    }

    @AfterEach 
    void tearDown(){
        myRecipe = null;
    }

    @Test
    void testEqualsValid() {
        //arrange
        Recipe recipe2 = new Recipe();
        recipe2.setName("Mocha Latte");

        //assert+act
        assertTrue(myRecipe.equals(recipe2));
    }

    @Test
    void testEqualsInvalidDifferentName() {
        //arrange
        Recipe recipe2 = new Recipe();
        recipe2.setName("Black Coffee");

        //assert+act
        assertFalse(myRecipe.equals(recipe2));
    }

    @Test
    void testEqualsOtherNameNull() {
        //arrange
        Recipe recipe2 = new Recipe(); //if null

        //assert+act
        assertFalse(myRecipe.equals(recipe2));
    }

    @Test
    void testEqualsMyNameNull() {
        //arrange
        Recipe recipe2 = new Recipe();
        recipe2.setName("Mocha Latte");

        //act
        myRecipe.setName(null);

        //assert
        assertFalse(myRecipe.equals(recipe2));
    }

    @Test
    void testGetAmtChocolate() {
        //arrange in setup
        //assert+act
        assertEquals(2, myRecipe.getAmtChocolate());
    }

    @Test
    void testGetAmtCoffee() {
        //arrange in setup
        //assert+act
        assertEquals(2, myRecipe.getAmtCoffee());
    }

    @Test
    void testGetAmtMilk() {
        //arrange in setup
        //assert+act
        assertEquals(3, myRecipe.getAmtMilk());
    }

    @Test
    void testGetAmtSugar() {
        //arrange in setup
        //assert+act
        assertEquals(1, myRecipe.getAmtSugar());
    }

    @Test
    void testGetName() {
        //arrange in setup
        //assert+act
        assertEquals("Mocha Latte", myRecipe.getName());
    }

    @Test
    void testGetPrice() {
        //arrange in setup
        //assert+act
        assertEquals(5, myRecipe.getPrice());
    }

    @Test
    void testSetAmtChocolateValid() {
        //arrange in setup
        //act
        myRecipe.setAmtChocolate(10);
        //assert
        assertEquals(10, myRecipe.getAmtChocolate());
    }
    @Test
    void testSetAmtChocolateInvalidNegative() {
        //arrange in setup
        //act
        myRecipe.setAmtChocolate(-10);
        //assert
        assertEquals(0, myRecipe.getAmtChocolate());
    }

    @ParameterizedTest
    @CsvSource({
        "-1, 0",
        "0, 0",
        "1, 1"
    })
    void testSetAmtChocolateBoundary(int input, int expected) {
        //arrange in setup
        //act
        myRecipe.setAmtChocolate(input);
        //assert
        assertEquals(expected, myRecipe.getAmtChocolate());
    }

    @Test
    void testSetAmtCoffeeValid() {
        //arrange in setup
        //act
        myRecipe.setAmtCoffee(10);
        //assert
        assertEquals(10, myRecipe.getAmtCoffee());
    }
    @Test
    void testSetAmtCoffeeInvalidNegative() {
        //arrange in setup
        //act
        myRecipe.setAmtCoffee(-10);
        //assert
        assertEquals(0, myRecipe.getAmtCoffee());
    }

    @ParameterizedTest
    @CsvSource({
        "-1, 0",
        "0, 0",
        "1, 1"
    })
    void testSetAmtCoffeeBoundary(int input, int expected) {
        //arrange in setup
        //act
        myRecipe.setAmtCoffee(input);
        //assert
        assertEquals(expected, myRecipe.getAmtCoffee());
    }

    @Test
    void testSetAmtMilkValid() {
        //arrange in setup
        //act
        myRecipe.setAmtMilk(10);
        //assert
        assertEquals(10, myRecipe.getAmtMilk());
    }
    @Test
    void testSetAmtMilkInvalidNegative() {
        //arrange in setup
        //act
        myRecipe.setAmtMilk(-10);
        //assert
        assertEquals(0, myRecipe.getAmtMilk());
    }

    @ParameterizedTest
    @CsvSource({
        "-1, 0",
        "0, 0",
        "1, 1"
    })
    void testSetAmtMilkBoundary(int input, int expected) {
        //arrange in setup
        //act
        myRecipe.setAmtMilk(input);
        //assert
        assertEquals(expected, myRecipe.getAmtMilk());
    }

    @Test
    void testSetAmtSugarValid() {
        //arrange in setup
        //act
        myRecipe.setAmtSugar(10);
        //assert
        assertEquals(10, myRecipe.getAmtSugar());
    }

    @Test
    void testSetAmtSugarInvalidNegative() {
        //arrange in setup
        //act
        myRecipe.setAmtSugar(-10);
        //assert
        assertEquals(0, myRecipe.getAmtSugar());
    }

    @ParameterizedTest
    @CsvSource({
        "-1, 0",
        "0, 0",
        "1, 1"
    })
    void testSetAmtSugarBoundary(int input, int expected) {
        //arrange in setup
        //act
        myRecipe.setAmtSugar(input);
        //assert
        assertEquals(expected, myRecipe.getAmtSugar());
    }

    @Test
    void testSetNameValid() {
        //arrange in setup
        //act
        myRecipe.setName("Black Coffee");
        //assert
        assertEquals("Black Coffee", myRecipe.getName());
    }

    @Test
    void testSetNameEmpty() {
        //arrange in setup

        //act
        myRecipe.setName("");

        //assert
        assertEquals("", myRecipe.getName());
    }

    @Test
    void testSetNameNull() {
        //arrange in setup

        //act
        myRecipe.setName(null);

        //assert
        assertNull(myRecipe.getName());
    }

    @Test
    void testSetPriceValid() {
        //arrange in setup
        //act
        myRecipe.setPrice(10);
        //assert
        assertEquals(10, myRecipe.getPrice());
    }

    @Test
    void testSetPriceInvalidNegative() {
        //arrange in setup
        //act
        myRecipe.setPrice(-10);
        //assert
        assertEquals(0, myRecipe.getPrice());
    }

    @ParameterizedTest
    @CsvSource({
        "-1, 0",
        "0, 0",
        "1, 1"
    })
    void testSetPriceBoundary(int input, int expected) {
        //arrange in setup
        //act
        myRecipe.setPrice(input);
        //assert
        assertEquals(expected, myRecipe.getPrice());
    }

    @Test
    void testToString() {
        //arrange in setup

        //assert+act
        assertEquals("Mocha Latte", myRecipe.toString());
    }
}
