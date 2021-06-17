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
    public static final String RECEIPT_HEADER = "======Printing Orders======\n";
    private Order order;

    public OrderReceipt(Order order) {
        this.order = order;
    }

    public String getReceiptInfo() {
        StringBuilder receiptInfo = new StringBuilder();

        insertHeader(receiptInfo);

        insertCustomerInfo(receiptInfo);

        double totalTaxPayable = 0d;
        double totalAmountPayable = 0d;
        for (LineItem lineItem : order.getLineItems()) {
            insertOrderItemInfo(receiptInfo, lineItem);

            double salesTax = getSalesTax(lineItem);
            totalTaxPayable += salesTax;

            totalAmountPayable += lineItem.totalAmount() + salesTax;
        }

        insertPriceInfo(receiptInfo, totalTaxPayable, totalAmountPayable);
        return receiptInfo.toString();
    }

    private StringBuilder insertHeader(StringBuilder receiptInfo) {
        return receiptInfo.append(RECEIPT_HEADER);
    }

    private double getSalesTax(LineItem lineItem) {
        return lineItem.totalAmount() * TAX_RATE;
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
        output.append("Sales Tax").append('\t').append(totalTaxPayable);

        output.append("Total Amount").append('\t').append(totalAmountPayable);
    }

    private void insertCustomerInfo(StringBuilder output) {
        output.append(order.getCustomerName());
        output.append(order.getCustomerAddress());
    }
}