package generalized;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface FieldInfo {
    String label();            // Label for the form field: sexe
    String type();             // Input type: text, number, select, etc.
    boolean required() default true; // Whether the field is required on, atao false rehefa miauto-increment ohatra 
    String[] options() default {};  // For select dropdowns: homme, femme
}
