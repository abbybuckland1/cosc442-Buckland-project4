package edu.towson.cis.cosc442.project4.coffeemaker;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class InventoryTest {

    Inventory myInventory;

    @BeforeEach 
    void setUp(){
        myInventory = new Inventory();
    }

    @AfterEach 
    void tearDown(){
        myInventory=null;
    }

    @Test
    void testEnoughIngredients() {

    }

    @Test
    void testGetChocolate() {
        //arrange in set up
        //assert+act
        assertEquals(15, myInventory.getChocolate());
    }

    @Test
    void testGetCoffee() {
        //arrange in set up
        //assert+act
        assertEquals(15, myInventory.getCoffee());
    }

    @Test
    void testGetMilk() {
        //arrange in set up
        //assert+act
        assertEquals(15, myInventory.getMilk());
    }


    @Test
    void testGetSugar() {
        //arrange in set up
        //assert+act
        assertEquals(15, myInventory.getSugar());
    }

    
    @Test
    void testSetChocolateValid() {
        //arrange
        //act
        myInventory.setChocolate(10);
        //assert
        assertEquals(10, myInventory.getChocolate());

    }

    @Test
    void testSetChocolateInvalidNegative() {
        //arrange
        //act
        myInventory.setChocolate(-10);
        //assert
        assertEquals(0, myInventory.getChocolate());
    }

    @ParameterizedTest
    @CsvSource({
        "-1, 0",
        "0, 0",
        "1, 1"
    })
    void testSetChocolateBoundary(int amount, int expected) {
        //arrange in setup

        //act
        myInventory.setChocolate(amount);

        //assert
        assertEquals(expected, myInventory.getChocolate());
    }

    @Test
    void testSetCoffeeValid() {
        //arrange
        //act
        myInventory.setCoffee(10);
        //assert
        assertEquals(10, myInventory.getCoffee());

    }

    @Test
    void testSetCoffeeInvalidNegative() {
        //arrange
        //act
        myInventory.setCoffee(-10);
        //assert
        assertEquals(0, myInventory.getCoffee());
    }

    @ParameterizedTest
    @CsvSource({
        "-1, 0",
        "0, 0",
        "1, 1"
    })
    void testSetCoffeeBoundary(int amount, int expected) {
        //arrange in setup

        //act
        myInventory.setCoffee(amount);

        //assert
        assertEquals(expected, myInventory.getCoffee());
    }

    

    
    @Test
    void testSetMilkValid() {
        //arrange
        //act
        myInventory.setMilk(10);
        //assert
        assertEquals(10, myInventory.getMilk());

    }

    @Test
    void testSetMilkInvalidNegative() {
        //arrange
        //act
        myInventory.setMilk(-10);
        //assert
        assertEquals(0, myInventory.getMilk());
    }

    @ParameterizedTest
    @CsvSource({
        "-1, 0",
        "0, 0",
        "1, 1"
    })
    void testSetMilkBoundary(int amount, int expected) {
        //arrange in setup

        //act
        myInventory.setMilk(amount);

        //assert
        assertEquals(expected, myInventory.getMilk());
    }

    @Test
    void testSetSugarValid() {
        //arrange
        //act
        myInventory.setSugar(10);
        //assert
        assertEquals(10, myInventory.getSugar());

    }

    @Test
    void testSetSugarInvalidNegative() {
        //arrange
        //act
        myInventory.setSugar(-10);
        //assert
        assertEquals(0, myInventory.getSugar());
    }

    @ParameterizedTest
    @CsvSource({
        "-1, 0",
        "0, 0",
        "1, 1"
    })
    void testSetSugarBoundary(int amount, int expected) {
        //arrange in setup

        //act
        myInventory.setSugar(amount);

        //assert
        assertEquals(expected, myInventory.getSugar());
    }

    @Test
    void testToString() {

    }
}
