package com.flipkart.bean;

/**
 * PaymentType enum represents different types of payment methods supported in the FlipFit system.
 * It includes options for card payment, UPI (Unified Payments Interface), and bank transfer.
 */
public enum PaymentType {
    /**
     * Represents payment via card.
     */
    CARD,            // Represents payment via card
    /**
     * Represents payment via UPI (Unified Payments Interface).
     */
    UPI,             // Represents payment via UPI (Unified Payments Interface)
    /**
     * Represents payment via bank transfer.
     */
    BANKTRANSFER     // Represents payment via bank transfer
}
