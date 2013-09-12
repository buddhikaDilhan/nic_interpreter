package com.tuna.nic;

import org.joda.time.DateTime;

/**
 * container for NIC result details
 */
public class NICDetails {
    public static enum Gender {
        MALE, FEMALE
    };
    private final DateTime birthday;
    private final boolean voter;
    private final Gender gender;

    public DateTime getBirthday() {
        return birthday;
    }

    public boolean isVoter() {
        return voter;
    }

    public Gender getGender() {
        return gender;
    }

    public NICDetails(DateTime birthday, Gender gender, boolean voter) {
        this.birthday = birthday;
        this.voter = voter;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Nic [" + "birthday=[year=" + birthday.getYear() + ", month=" + birthday.getMonthOfYear() +
                ", date=" + birthday.getDayOfMonth() + "], gender=" + gender.name() +
                ", isVoter=" + voter + ']';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + (this.birthday != null ? this.birthday.hashCode() : 0);
        hash = 41 * hash + (this.voter ? 1 : 0);
        hash = 41 * hash + (this.gender != null ? this.gender.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final NICDetails other = (NICDetails) obj;
        if (this.birthday != other.birthday && (this.birthday == null || !this.birthday.equals(other.birthday))) {
            return false;
        }
        if (this.voter != other.voter) {
            return false;
        }
        if (this.gender != other.gender) {
            return false;
        }
        return true;
    }
}
