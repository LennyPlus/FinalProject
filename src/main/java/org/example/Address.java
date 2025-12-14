package org.example;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@EqualsAndHashCode
@ToString
@Getter
@Setter
public class Address {
    private int streetNo;
    private String street;
    private String city;
    private Province province;
    private String postalCode;

    public Address(int streetNo, String street, String city, Province province, String postalCode) {
        if (isPostalCodeValid(postalCode)) {
            this.streetNo = streetNo;
            this.street = street;
            this.city = city;
            this.province = province;
            this.postalCode = postalCode.toUpperCase();
        } else {
            this.streetNo = 0;
            this.street = null;
            this.city = null;
            this.province = null;
            this.postalCode = null;
        }
    }

    /**
     * Checks if a postal code is valid or not
     * @param postalCode The postal code to be checked
     * @return True if the postal code is valid, otherwise false
     */
    public static boolean isPostalCodeValid(String postalCode) {
        if (postalCode == null || postalCode.length() != 6) {
            return false;
        }

        for (int i = 0; i < 6; i++) {
            char c = postalCode.charAt(i);

            if (i % 2 == 0 && !Character.isLetter(c)) {
                return false;
            }
            if(i % 2 == 1 && !Character.isDigit(c)) {
                return false;
            }
        }

        return true;
    }

    public enum Province {
        ON,
        QC,
        NS,
        NB,
        MB,
        BC,
        PE,
        SK,
        AB,
        NL
    }
}
