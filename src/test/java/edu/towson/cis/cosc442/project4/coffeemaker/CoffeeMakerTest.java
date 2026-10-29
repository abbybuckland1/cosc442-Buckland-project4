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
        myRecipe1.setPrice(3);
        myRecipe1.setAmtCoffee(2);
        myRecipe1.setAmtMilk(0);
        myRecipe1.setAmtSugar(0);
        myRecipe1.setAmtChocolate(0);

        myRecipe2 = new Recipe();
        myRecipe2.setName("Vanilla Latte");
        myRecipe2.setPrice(5);
        myRecipe2.setAmtCoffee(2);
        myRecipe2.setAmtMilk(3);
        myRecipe2.setAmtSugar(1);
        myRecipe2.setAmtChocolate(0);

        myRecipe3 = new Recipe();
        myRecipe3.setName("Mocha Latte");
        myRecipe3.setPrice(5);
        myRecipe3.setAmtCoffee(2);
        myRecipe3.setAmtMilk(3);
        myRecipe3.setAmtSugar(1);
        myRecipe3.setAmtChocolate(2);

        myRecipe4 = new Recipe();
        myRecipe4.setName("Espresso");
        myRecipe4.setPrice(3);
        myRecipe4.setAmtCoffee(3);
        myRecipe4.setAmtMilk(0);
        myRecipe4.setAmtSugar(0);
        myRecipe4.setAmtChocolate(0);

        myRecipe5 = new Recipe();
        myRecipe5.setName("Decaf");
        myRecipe5.setPrice(3);
        myRecipe5.setAmtCoffee(2);
        myRecipe5.setAmtMilk(0);
        myRecipe5.setAmtSugar(0);
        myRecipe5.setAmtChocolate(0);
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

    //edit recipe tests
    @Test
    void testEditRecipeValid() {
        //arrange
        myCoffeeMaker.addRecipe(myRecipe1);
        //act
        boolean result = myCoffeeMaker.editRecipe(myRecipe1, myRecipe2);
        //assert
        assertTrue(result);
        assertEquals(null, myCoffeeMaker.getRecipeForName("Black Coffee").getName());
        assertEquals("Vanilla Latte", myCoffeeMaker.getRecipeForName("Vanilla Latte").getName());
    }

    @Test
    void testEditRecipeInvalidRecipeDoesNotExist() {
        //arrange
        myCoffeeMaker.addRecipe(myRecipe1);
        //act
        boolean result = myCoffeeMaker.editRecipe(myRecipe2, myRecipe3);
        //assert
        assertFalse(result);
    }


    @Test
    void testEditRecipeBoundaryFull() {
        //arrange
        myCoffeeMaker.addRecipe(myRecipe1);
        myCoffeeMaker.addRecipe(myRecipe2);
        myCoffeeMaker.addRecipe(myRecipe3);
        myCoffeeMaker.addRecipe(myRecipe4);

        //act
        boolean result = myCoffeeMaker.editRecipe(myRecipe2, myRecipe5);

        //assert
        assertTrue(result);
        assertEquals(null, myCoffeeMaker.getRecipeForName("Vanilla Latte").getName());
        assertEquals("Decaf", myCoffeeMaker.getRecipeForName("Decaf").getName());

    }

    @Test 
    void testGetRecipeForNameValid() {
        //arrange
        myCoffeeMaker.addRecipe(myRecipe1);
        myCoffeeMaker.addRecipe(myRecipe2);

        //act
        Recipe result = myCoffeeMaker.getRecipeForName(myRecipe2.getName());

        //assert
        assertEquals(myRecipe2.getName(),result.getName());
    }

    @Test 
    void testGetRecipeForNameInvalidNameDoesNotExist() {
        //arrange
        myCoffeeMaker.addRecipe(myRecipe1);

        //act
        Recipe result = myCoffeeMaker.getRecipeForName(myRecipe2.getName());

        //assert
        assertEquals(null, result.getName());
    }

    @Test
    void testGetRecipesValid() {
        //arrange
        myCoffeeMaker.addRecipe(myRecipe1);
        myCoffeeMaker.addRecipe(myRecipe2);

        //act
        Recipe[] result = myCoffeeMaker.getRecipes();

        //assert
        assertEquals(4, result.length);
        assertEquals("Black Coffee", result[0].getName());
        assertEquals("Vanilla Latte", result[1].getName());

    }

    @Test
    void testGetRecipesBoundaryEmpty() {
        //arrange in setup

        //act
        Recipe[] result = myCoffeeMaker.getRecipes();

        //assert
        assertEquals(4, result.length);
        assertEquals(null, result[0].getName());
        assertEquals(null, result[1].getName());
        assertEquals(null, result[2].getName());
        assertEquals(null, result[3].getName());
    }

    @ParameterizedTest
    @CsvSource({
        "5, 0",
        "6, 1",
        "10, 5"
    })
    void testMakeCoffeeValid(int amountPaid, int expectedChange) {
        //arrange in setup

        //act
        int result = myCoffeeMaker.makeCoffee(myRecipe3, amountPaid);

        //assert
        assertEquals(expectedChange, result);
        assertEquals(13, myCoffeeMaker.checkInventory().getCoffee());
        assertEquals(12, myCoffeeMaker.checkInventory().getMilk());
        assertEquals(14, myCoffeeMaker.checkInventory().getSugar());
        assertEquals(13, myCoffeeMaker.checkInventory().getChocolate());
    }

    @ParameterizedTest
    @CsvSource({
        "0, 0",
        "3, 3",
        "4, 4"
    })
    void testMakeCoffeeInvalidMoney(int amountPaid, int expectedChange) {
        //arrange in setup

        //act
        int result = myCoffeeMaker.makeCoffee(myRecipe2, amountPaid);

        //assert
        assertEquals(expectedChange, result);
        assertEquals(15, myCoffeeMaker.checkInventory().getCoffee());
        assertEquals(15, myCoffeeMaker.checkInventory().getMilk());
        assertEquals(15, myCoffeeMaker.checkInventory().getSugar());
    }

    @Test
    void testMakeCoffeeInvalidIngredients() {
        //arrange
        myCoffeeMaker.makeCoffee(myRecipe2, 5);
        myCoffeeMaker.makeCoffee(myRecipe2, 5);
        myCoffeeMaker.makeCoffee(myRecipe2, 5);
        myCoffeeMaker.makeCoffee(myRecipe2, 5);
        myCoffeeMaker.makeCoffee(myRecipe2, 5);

        //act
        int result = myCoffeeMaker.makeCoffee(myRecipe2, 5);
//last one rejected so customer should get 5 back

        //assert
        assertEquals(5, result);
        assertEquals(5, myCoffeeMaker.checkInventory().getCoffee());
        assertEquals(0, myCoffeeMaker.checkInventory().getMilk());
        assertEquals(10, myCoffeeMaker.checkInventory().getSugar());
        assertEquals(15, myCoffeeMaker.checkInventory().getChocolate());
    }
    

}
