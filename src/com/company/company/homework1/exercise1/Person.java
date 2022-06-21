package com.company.company.homework1.exercise1;

public class
Person {

    private String firstName;
    private String lastName;



    public static class Builder {
        private Person newPerson;

        public Builder() {
           newPerson = new Person();
        }

        public Builder withName(String firstName){
            newPerson.firstName=firstName;
            return this;
        }

        public Builder withLastName(String lastName) {
            newPerson.lastName = lastName;
            return this;
        }

        public Person build(){
            return newPerson;
        }

        //и т.д.
    }

}
