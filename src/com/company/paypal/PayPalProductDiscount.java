package com.company.paypal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/*
Question: Products and discounts
Find the minimum amount needed to purchase all products.
Inputs:
2D products array.

It can have N no of products and each product can have 0 or more discount tags. Discount tags are given in the discount array which is the second input.
Format: [[<product_price>, <name of discount tag 1>, < name of discount tag 2>, ...]]
Examples: [["product1_price", "d1", "d2" ,"d3"]. ["product2_price", "EMPTY", "d2"], ["product3_price"]]
Like seen in example, "EMPTY" could also mean null - it is not a tag. We have to ignore "EMPTY" tags. As seen for product3, we can have 0 discount tags too. There can be more than 1 "EMPTY" tag for a product.
All elements are strings - even the product price.
Product price can be between "1" and "100000". No fractions - all whole numbers.
There can be a maximum of 100 products in the 2D array.
Note that the product price given here in the original price of the product.
2D discounts array.

These are discounts that can be applied to each product and each 1D array is exactly of size 3: in the format: [<discount_tag_name>, <discount_type>, <discount_amount>].
Example: [["d1", 0, "500"], ["d2", 1, "40"], ["d3", 2, "200"]].
Each discount tag has a unique name.
Discount Type meaning:
Type "0": Fixed price after discount is given in the array. In given example, for "d1" we have 0 type. This means the price of the product is 500 if we apply d1 discount. Original price can be 1000 or whatever. For type 0, the final price is the value found in the 3rd position in the discount tag array. So, no need to refer to the original price in the product array.
Type "1": Percentage discount. For "d2", we have type 1 --> we need to apply 40% discount to the original price of the product. Get original price from product array.
Type "2": Discount amount is subtracted. In "d3", we have 200 as discount amount. We need to subtract this amount from the original price.
There can be a maximum of 100 different discount tags per test case.
For product 1, we have 3 tags : d1, d2 and d3. We have to apply each discount based on the discount type and find the least value.
For product 2, we ignore the empty tag and apply the d2 discount and take that value.
For product 3, we do not apply any discounts and use the original price.


For each product, we have to find the minimum value that we can get after applying only 1 discount.
If there are more than 1 discount tags for a product, we need to find which tag will give us the least final amount for that product and take that value.
We cannot apply more than 1 discounts for a product. We have to find the best discount to apply for each product.


Obviously, for each product, we can only apply the discounts for it given in the product array.
If there are no discounts, or if there only "EMPTY" tags for it, we simply take the original price as the best price for that product.


Fins such lowest price for each product and add them all up and return the final amount.
Since type 1 discounts can make the final price float, round them to the nearest integer before adding to total amount --> MUST DO as it is a condition given in the problem statement.


Note: Note that all inputs are strings including price, discount amount, discount type.
In java, both 2D arrays were given as 2D arraylists: List<List< String >> products, List<List< String >> discounts.
There can be a maximum of 100 products with each product containing 0 or more tags. So each 1D array can be of different size.
In discount array, each 1D array is of size 3 and there can be a maximum of 100 discounts.
ASSUME that applying a discount always gives a lesser value than the original price.
Covert to integer before adding to total value. Final output is a single integer.
Can finally apply only 1 discount to a product. Find the best discount to apply. Find minimum value by applying each discount one by one. Cannot apply one discount over another discount. Always apply discount to original price.
Output: Minimum total amount of money needed to buy all the products. It is an integer.


I passed 5 test cases but all other test cases failed. Not sure what the corner cases were. Did not get TLE so my guess is either I made a mistake in rounding the float values or missed some corner case.


 */
public class PayPalProductDiscount {
    public static void main(String[] args) {
        List<List<String>> products = new ArrayList<>();
        products.add(new ArrayList<>(Arrays.asList("100", "d1", "d2", "d3")));
        products.add(new ArrayList<>(Arrays.asList("200", "EMPTY", "d2")));
        products.add(new ArrayList<>(Arrays.asList("300")));

        List<List<String>> discounts = new ArrayList<>();
        discounts.add(new ArrayList<>(Arrays.asList("d1", "0", "500")));
        discounts.add(new ArrayList<>(Arrays.asList("d2", "1", "40")));
        discounts.add(new ArrayList<>(Arrays.asList("d3", "2", "200")));

        System.out.println(findMinProdDisc(products, discounts));

    }
    public static Integer findMinProdDisc(List<List<String>> products, List<List<String>> discounts){
        HashMap<String, Integer> fixed = new HashMap<>();
        HashMap<String, Float> percent = new HashMap<>();
        HashMap<String, Integer> subtraction = new HashMap<>();

        for(List<String> discount : discounts){
            String tag = discount.get(0);
            int type = Integer.parseInt(discount.get(1));
            int value = Integer.parseInt(discount.get(2));

            if (type == 0){
                fixed.put(tag, value);
            } else if (type == 1) {
                percent.put(tag, value / 100.0f);
            }else {
                subtraction.put(tag, value);
            }
        }
        int total=0;

        for( List<String> prod : products){
            int price  = Integer.parseInt(prod.get(0));
            int bestPrice = price;

            for(int i = 1 ; i < prod.size(); i++){
                String tag = prod.get(i);
                if(tag.equals("EMPTY")){
                    continue;
                }
                int currentPrice = price;
                if(fixed.containsKey(tag)){
                    currentPrice = fixed.get(tag);
                }else if(percent.containsKey(tag)){
                    currentPrice = Math.round(price - (price * percent.get(tag)));
                }else if(subtraction.containsKey(tag)){
                    currentPrice = price - subtraction.get(tag);
                }
                if(currentPrice > 0){
                    bestPrice = Math.min(bestPrice, currentPrice);
                }
            }
            total += bestPrice;
        }
        return total;
    }
}
