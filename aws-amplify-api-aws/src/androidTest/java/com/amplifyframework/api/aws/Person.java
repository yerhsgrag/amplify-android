/*
 * Copyright 2019 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
 *
 *  http://aws.amazon.com/apache2.0
 *
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */

package com.amplifyframework.api.aws;

import com.amplifyframework.AmplifyException;
import com.amplifyframework.core.model.Model;
import com.amplifyframework.core.model.annotations.Index;
import com.amplifyframework.core.model.annotations.ModelConfig;
import com.amplifyframework.core.model.annotations.ModelField;
import com.amplifyframework.core.model.query.predicate.QueryField;

import java.util.Date;
import java.util.UUID;

import static com.amplifyframework.core.model.query.predicate.QueryField.field;

/**
 * This is an autogenerated class representing the Person type in your schema.
 */
@SuppressWarnings("all")
@ModelConfig(targetName = "Person")
@Index(fields = {"firstName", "age"}, name = "firstNameBasedIndex")
public final class Person implements Model {
    // Constant QueryFields for each property in this model to be used for constructing conditions
    public static final QueryField ID = field("id");
    public static final QueryField FIRST_NAME = field("firstName");
    public static final QueryField LAST_NAME = field("lastName");
    public static final QueryField AGE = field("age");
    public static final QueryField DOB = field("dob");
    public static final QueryField RELATIONSHIP = field("relationship");

    @ModelField(targetName = "id", targetType = "ID", isRequired = true)
    private final String id;

    @ModelField(targetName = "first_name", targetType = "String", isRequired = true)
    private final String firstName;

    @ModelField(targetName = "last_name", targetType = "String", isRequired = true)
    private final String lastName;

    @ModelField(targetName = "age", targetType = "Int")
    private final Integer age;

    @ModelField(targetName = "dob", targetType = "AWSDate")
    private final Date dob;

    @ModelField(targetName = "relationship", targetType = "MaritalStatus")
    private final MaritalStatus relationship;

    private Person(String uniqueId,
                   String firstName,
                   String lastName,
                   Integer age,
                   Date dob,
                   MaritalStatus relationship) {
        this.id = uniqueId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.dob = dob;
        this.relationship = relationship;
    }

    /**
     * Returns an instance of the builder at the first required step.
     * @return an instance of the builder.
     */
    public static FirstNameStep builder() {
        return new Builder();
    }

    /**
     * Returns id.
     * @return id.
     */
    public String getId() {
        return id;
    }

    /**
     * Returns firstName.
     * @return firstName.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Returns lastName.
     * @return lastName.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Returns age.
     * @return age.
     */
    public Integer getAge() {
        return age;
    }

    /**
     * Returns dob.
     * @return dob.
     */
    public Date getDob() {
        return dob;
    }

    /**
     * Returns relationship.
     * @return relationship.
     */
    public MaritalStatus getRelationship() {
        return relationship;
    }

    /**
     * Interface for required firstName step.
     */
    public interface FirstNameStep {
        /**
         * Set firstName.
         * @param firstName firstName.
         * @return next step.
         */
        LastNameStep firstName(String firstName);
    }

    /**
     * Interface for lastName step.
     */
    public interface LastNameStep {
        /**
         * Set lastName.
         * @param lastName lastName.
         * @return next step.
         */
        FinalStep lastName(String lastName);
    }

    /**
     * Interface for final step.
     */
    public interface FinalStep {
        /**
         * Set id.
         * @param id id.
         * @return next step.
         * @throws AmplifyException Checks that ID is in the proper format
         */
        FinalStep id(String id) throws AmplifyException;

        /**
         * Set age.
         * @param age age.
         * @return next step.
         */
        FinalStep age(Integer age);

        /**
         * Set dob.
         * @param dob dob.
         * @return next step.
         */
        FinalStep dob(Date dob);

        /**
         * Set relationship.
         * @param relationship relationship.
         * @return next step.
         */
        FinalStep relationship(MaritalStatus relationship);

        /**
         * Returns the built Person object.
         * @return the built Person object.
         */
        Person build();
    }

    /**
     * Builder to build the Person object.
     */
    public static final class Builder implements
            FirstNameStep, LastNameStep, FinalStep {
        private String id;
        private String firstName;
        private String lastName;
        private Integer age;
        private Date dob;
        private MaritalStatus relationship;

        /**
         * WARNING: Do not set ID when creating a new object. Leave this blank and one will be auto generated for you.
         *          This should only be set when referring to an already existing object.
         * @param id id
         * @return Current Builder instance, for fluent method chaining
         * @throws AmplifyException Checks that ID is in the proper format
         */
        public FinalStep id(String id) throws AmplifyException {
            this.id = id;

            try {
                UUID.fromString(id); // Check that ID is in the UUID format - if not an exception is thrown
            } catch (Exception exception) {
                throw new AmplifyException("Model IDs must be unique in the format of UUID.",
                        exception,
                        "If you are creating a new object, leave ID blank and one will be autogenerated for you. " +
                        "Otherwise, if you are referencing an existing object, be sure you are getting the correct " +
                        "id for it. It's also possible you are referring to an item created outside of Amplify. We " +
                        "currently do not support this.",
                        false);
            }

            return this;
        }

        /**
         * Set firstName.
         * @param firstName firstName
         * @return Current Builder instance, for fluent method chaining
         */
        public LastNameStep firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        /**
         * Set lastName.
         * @param lastName lastName
         * @return Current Builder instance, for fluent method chaining
         */
        public FinalStep lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        /**
         * Set age.
         * @param age age
         * @return Current Builder instance, for fluent method chaining
         */
        public FinalStep age(Integer age) {
            this.age = age;
            return this;
        }

        /**
         * Set dob.
         * @param dob dob.
         * @return Current Builder instance, for fluent method chaining
         */
        public FinalStep dob(Date dob) {
            this.dob = new Date(dob.getTime());
            return this;
        }

        /**
         * Set relationship.
         * @param relationship relationship.
         * @return Current Builder instance, for fluent method chaining
         */
        public FinalStep relationship(MaritalStatus relationship) {
            this.relationship = relationship;
            return this;
        }

        /**
         * Returns the builder object.
         * @return the builder object.
         */
        public Person build() {
            String id = this.id != null ? this.id : UUID.randomUUID().toString();

            return new Person(
                    id,
                    firstName,
                    lastName,
                    age,
                    dob,
                    relationship);
        }
    }
}