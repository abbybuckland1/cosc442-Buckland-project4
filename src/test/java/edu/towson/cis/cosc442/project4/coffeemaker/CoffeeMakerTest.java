package edu.towson.cis.cosc442.project4.coffeemaker;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CoffeeMakerTest {

    CoffeeMaker myCoffeeMaker;

    @BeforeEach 
    void setUp(){
        myCoffeeMaker = new CoffeeMaker();
    }

    @AfterEach 
    void tearDown(){
        myCoffeeMaker = null;
    }

    //add inventory tests
    @ParameterizedTest
    @CsvSource({
                        "1, 2, 3, 4",
                        "1, 1, 1, 1",
                        "10, 15, 19, 25"
        })
        void testAddInventoryValid(int coffee, int milk, int sugar, int chocolate) {
            //arrange in setup

            //act
            boolean result = myCoffeeMaker.addInventory(coffee, milk, sugar, chocolate);

            //assert
            assertTrue(result);

        }
    
    @ParameterizedTest
    @CsvSource({
                        "2, -2, 3, 4",
                        "2, 2, 2, -2",
                        "10, 15, -19, 25",
                        "-50, 12, 5, 9"
        })
        void testAddInventoryInvalid(int coffee, int milk, int sugar, int chocolate) {
            //arrange in setup

            //act
            boolean result = myCoffeeMaker.addInventory(coffee, milk, sugar, chocolate);

            //assert
            assertFalse(result);

        }

    @ParameterizedTest
    @CsvSource({
                        "-1, 0, 0, 0, false",
                        "0, -1, 0, 0, false",
                        "0, 0, -1, 0, false",
                        "0, 0, 0, -1, false",
                        "0, 0, 0, 0, true",
                        "1, 0, 0, 0, true",
                        "0, 1, 0, 0, true",
                        "0, 0, 1, 0, true",
                        "0, 0, 0, 1, true"

        })
        void testAddInventoryBoundary(int coffee, int milk, int sugar, int chocolate, boolean expected) {
            //arrange in setup

            //act
            boolean result = myCoffeeMaker.addInventory(coffee, milk, sugar, chocolate);

            //assert
            assertEquals(expected, result);

        }

    @Test
    void testAddRecipe() {

    }

    @Test
    void testCheckInventory() {

    }

    @Test
    void testDeleteRecipe() {

    }

    @Test
    void testEditRecipe() {

    }

    @Test 
    void testGetRecipeForName() {

    }

    @Test
    void testGetRecipes() {

    }

    @Test
    void testMakeCoffee() {

    }
}
