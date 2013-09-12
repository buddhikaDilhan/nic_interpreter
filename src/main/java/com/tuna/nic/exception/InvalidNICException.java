/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tuna.nic.exception;

/**
 *
 * @author Janaka
 */
public class InvalidNICException extends RuntimeException {
    public InvalidNICException(String description) {
        super(description);
    }
}
