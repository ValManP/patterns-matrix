package edu.university.matrix.errorhandling;

public class MatrixOperationException extends RuntimeException {
    public MatrixOperationException(String message) {
        System.out.println(message);
    }
}
