package com.tw.academy.basic.$7_long_method;

/**
 * This class is a example for bad smell;
 *
 * @author  Thoughtworks
 * @version 1.0
 * @since   2018-1-1
 */
public class OrderReceipt {
    public static final double TAX_RATE = .10;
    private Order order;

    public OrderReceipt(Order order) {
        this.order = order;
    }

    //todo: rename -- Tom
    public String printReceipt() {
        StringBuilder output = new StringBuilder();

        // print headers
        output.append("======Printing Orders======\n");

        // print date, bill no, customer name
        insertCustomerInfo(output);

        // prints lineItems
        double totalTaxPayable = 0d;
        double totalAmountPayable = 0d;
        for (LineItem lineItem : order.getLineItems()) {
            insertOrderItemInfo(output, lineItem);

            // calculate sales tax @ rate of 10%
            double salesTax = lineItem.totalAmount() * TAX_RATE;
            totalTaxPayable += salesTax;

            // calculate total amount of lineItem = price * quantity + 10 % sales tax
            totalAmountPayable += lineItem.totalAmount() + salesTax;
        }

        insertPriceInfo(output, totalTaxPayable, totalAmountPayable);
        return output.toString();
    }

    private void insertOrderItemInfo(StringBuilder output, LineItem lineItem) {
        output.append(lineItem.getDescription());
        output.append('\t');
        output.append(lineItem.getPrice());
        output.append('\t');
        output.append(lineItem.getQuantity());
        output.append('\t');
        output.append(lineItem.totalAmount());
        output.append('\n');
    }

    private void insertPriceInfo(StringBuilder output, double totalTaxPayable, double totalAmountPayable) {
        // prints the state tax
        output.append("Sales Tax").append('\t').append(totalTaxPayable);

        // print total amount
        output.append("Total Amount").append('\t').append(totalAmountPayable);
    }

    private void insertCustomerInfo(StringBuilder output) {
        output.append(order.getCustomerName());
        output.append(order.getCustomerAddress());
    }
}