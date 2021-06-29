package com.ecommerce.shop.models.enums;


import java.util.Arrays;

/**
 * Enum describing the categories of the products.
 */
public enum CategoryType
{
    MOUSE("Mouse"),
    LAPTOP("Laptop"),
    MONITOR("Monitor"),
    KEYBOARD("Keyboard");
    
    private final String type;
    
    
    CategoryType(String type)
    {
        this.type = type;
    }
    
    
    public String getType()
    {
        return type;
    }
    
    
    /**
     * Get object of type {@link CategoryType} associated with the provided type
     *
     * @param type the type of the category
     * @return the {@link CategoryType} associated with the given type
     * @throws IllegalArgumentException if there is no such category with the provided type
     */
    public static CategoryType ofType(String type)
    {
        return Arrays.stream(CategoryType.values())
                .filter(categoryType -> categoryType.getType().equals(type))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No category with the provided type " + type));
    }
}
