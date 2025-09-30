import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;


import static org.junit.Assert.assertEquals;


@RunWith(MockitoJUnitRunner.class)
public class BurgerIngredientTest {

    @Mock
    private Bun bun;
    @Mock
    private Ingredient sauceIngredient;
    @Mock
    private Ingredient fillingIngredient;

    private Burger burger;

    @Before
    public void setUp() {
        burger = new Burger();
    }

    @Test
    public void testAddIngredient() {


        Ingredient expectedSauce = sauceIngredient;
        Ingredient expectedFilling = fillingIngredient;
        int expectedCount = 2;

        burger.addIngredient(expectedSauce);
        burger.addIngredient(expectedFilling);
        int actualCount = burger.ingredients.size();
        Ingredient actualSauce = burger.ingredients.get(0);
        Ingredient actualFilling = burger.ingredients.get(1);

        assertEquals("Должно быть два ингредиента", expectedCount, actualCount);
        assertEquals("Первый ингредиент должен быть соусом", expectedSauce, actualSauce);
        assertEquals("Второй ингредиент должен быть начинкой", expectedFilling, actualFilling);

    }


    @Test
    public void testRemoveIngredient() {

        burger.addIngredient(sauceIngredient);
        burger.addIngredient(fillingIngredient);
        int expectedCount = 1;


        burger.removeIngredient(0);
        int actualCount = burger.ingredients.size();


        assertEquals("Должен остаться один ингредиент", expectedCount, actualCount);
    }

    @Test
    public void testMoveIngredient() {

        burger.addIngredient(sauceIngredient);
        burger.addIngredient(fillingIngredient);


        Ingredient expectedSauceIngredient = fillingIngredient;
        Ingredient expectedFillingIngredient = sauceIngredient;


        burger.moveIngredient(0, 1);
        Ingredient actualFirstIngredient = burger.ingredients.get(0);
        Ingredient actualSecondIngredient = burger.ingredients.get(1);


        assertEquals("Первый ингредиент должен быть начинкой",
                expectedSauceIngredient, actualFirstIngredient);
        assertEquals("Второй ингредиент должен быть соусом",
                expectedFillingIngredient, actualSecondIngredient);
        assertEquals("Должно остаться два ингредиента", 2, burger.ingredients.size());
    }


}
