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
    Recipe myRecipe1;
    Recipe myRecipe2;
    Recipe myRecipe3;
    Recipe myRecipe4;
    Recipe myRecipe5;

    @BeforeEach 
    void setUp(){
        myCoffeeMaker = new CoffeeMaker();

        myRecipe1 = new Recipe();
        myRecipe1.setName("Black Coffee");

        myRecipe2 = new Recipe();
        myRecipe2.setName("Vanilla Latte");

        myRecipe3 = new Recipe();
        myRecipe3.setName("Caramel Latte");

        myRecipe4 = new Recipe();
        myRecipe4.setName("Espresso");

        myRecipe5 = new Recipe();
        myRecipe5.setName("Decaf");
    }

    @AfterEach 
    void tearDown(){
        myCoffeeMaker = null;
        myRecipe1 = null;
        myRecipe2 = null;
        myRecipe3 = null;
        myRecipe4 = null;
        myRecipe5 = null;
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

    //Add Recipe tests
    @Test
    void testAddRecipeValid() {
        //arrange in setup

        //act
        boolean result = myCoffeeMaker.addRecipe(myRecipe1);
        boolean result2 = myCoffeeMaker.addRecipe(myRecipe2);

        //assert
        assertTrue(result);
        assertTrue(result2);
    }

    @Test 
    void testAddRecipeInvalidFull(){
        //arrange in setup

        //act
        boolean result = myCoffeeMaker.addRecipe(myRecipe1);
        boolean result2 = myCoffeeMaker.addRecipe(myRecipe2);
        boolean result3 = myCoffeeMaker.addRecipe(myRecipe3);
        boolean result4 = myCoffeeMaker.addRecipe(myRecipe4);
        boolean result5 = myCoffeeMaker.addRecipe(myRecipe5);

        //assert
        assertTrue(result);
        assertTrue(result2);
        assertTrue(result3);
        assertTrue(result4);
        assertFalse(result5);
    }

    @Test
    void testAddRecipeInvalidDuplicateName(){
        //arrange
        myRecipe2.setName("Black Coffee");
        myCoffeeMaker.addRecipe(myRecipe1);

        //act
        boolean result = myCoffeeMaker.addRecipe(myRecipe2);

        //assert
        assertFalse(result);
    }

    @Test
    void testCheckInventory() {
        //arrange
        myCoffeeMaker.addInventory(2,3,4,5);
        //act
        Inventory result = myCoffeeMaker.checkInventory();
        //assert
        assertEquals(17,result.getCoffee());
        assertEquals(18,result.getMilk());
        assertEquals(19,result.getSugar());
        assertEquals(20,result.getChocolate());
    }

    @Test
    void testDeleteRecipeValid() {
        //arrange
        myCoffeeMaker.addRecipe(myRecipe1);
        myCoffeeMaker.addRecipe(myRecipe2);
        myCoffeeMaker.addRecipe(myRecipe3);

        //act
        boolean result = myCoffeeMaker.deleteRecipe(myRecipe2);

        //assert
        assertTrue(result);
        for(Recipe recipe : myCoffeeMaker.getRecipes()) {
            assertFalse(myRecipe2.equals(recipe));
        } //checks to make sure no recipe equals recipe2 
    }

    @Test
    void testDeleteRecipeInvalidDoesNotExist() {
        //arrange
        myCoffeeMaker.addRecipe(myRecipe1);
        myCoffeeMaker.addRecipe(myRecipe2);
        myCoffeeMaker.addRecipe(myRecipe3);

        //act
        boolean result = myCoffeeMaker.deleteRecipe(myRecipe4);

        //assert
        assertFalse(result);

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
