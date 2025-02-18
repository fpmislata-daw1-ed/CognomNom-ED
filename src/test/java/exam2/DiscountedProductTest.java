package exam2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class DiscountedProductTest {
    @ParameterizedTest
    @CsvSource({
            "Producte 1, 10, 10",
            "Producte 2, -10, 0",
    })
    @DisplayName("DiscountedProduct(String name, double price)")
    void constructorWithNameAndPrice(String name, double price, double expectedPrice){
        DiscountedProduct p = new DiscountedProduct(name, price);

        assertAll(
                () -> assertEquals(name, p.getName()),
                () -> assertEquals(expectedPrice, p.getPrice()),
                () -> assertEquals(0, p.getDiscount())
        );
    }

    @ParameterizedTest
    @CsvSource({
            "Producte 1, 10, 10, 10, 10",
            "Producte 2, -10, 10, 0, 10",
            "Producte 3, 10, -10, 10, 0",
            "Producte 4, 10, 60, 10, 50",
    })
    @DisplayName("DiscountedProduct(String name, double price, double discount)")
    void constructorWithNamePriceDiscount(String name, double price, double discount, double expectedPrice, double expectedDiscount){
        DiscountedProduct p = new DiscountedProduct(name, price, discount);

        assertAll(
                () -> assertEquals(name, p.getName()),
                () -> assertEquals(expectedPrice, p.getPrice()),
                () -> assertEquals(expectedDiscount, p.getDiscount())
        );
    }

    @ParameterizedTest
    @CsvSource({
            "10, 20, 20",
            "10, -10, 10"
    })
    @DisplayName("setPrice")
    void setPrice(double initialPrice, double newPrice, double expectedPrice){
        // Arrange
        DiscountedProduct p = new DiscountedProduct("Producte", initialPrice, 0);

        // Act
        p.setPrice(newPrice);

        // Assert
        assertEquals(expectedPrice, p.getPrice());
    }

    @ParameterizedTest
    @CsvSource({
            "10, 20, 20",
            "10, -10, 10",
            "10, 60, 10",
    })
    @DisplayName("setDiscount")
    void setDiscount(double initialDiscount, double newDiscount, double expectedDiscount){
        // Arrange
        DiscountedProduct p = new DiscountedProduct("Producte", 0, initialDiscount);

        // Act
        p.setDiscount(newDiscount);

        // Assert
        assertEquals(expectedDiscount, p.getDiscount());
    }

    @ParameterizedTest
    @CsvSource({
            "50, 0, 50",
            "50, 10, 45",
            "50, 50, 25",
            "0, 10, 0",
    })
    @DisplayName("getFinalPrice")
    void getFinalPrice(double price, double discount, double expectedFinalPrice){
        // Arrange
        DiscountedProduct p = new DiscountedProduct("Producte", price, discount);

        // Act
        double finalPrice = p.getFinalPrice();

        // Assert
        assertEquals(expectedFinalPrice, finalPrice);
    }
}