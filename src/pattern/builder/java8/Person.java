package pattern.builder.java8;

import java.util.function.*;

public class Person {
  private String firstname, lastname, phonenumber;

  private Person(PersonBuilder builder){
    this.firstname = builder.firstname;
    this.lastname = builder.lastname;
    this.phonenumber = builder.phonenumber;
  }

  public String getFirstname(){
    return firstname;
  }

  public String toString(){
    return "Firstname: " + firstname + " lastname: " + lastname + " phonenumber: " + phonenumber;
  }

  public static class PersonBuilder {
    private String firstname, lastname, phonenumber;

    private PersonBuilder(){}

    public static Person build(Consumer<PersonBuilder> block) {
      PersonBuilder personBuilder = new PersonBuilder();
      block.accept(personBuilder);
      return new Person(personBuilder);
    }

    public PersonBuilder withFirstname(String firstname){
      this.firstname = firstname;
      return this;
    }

    public PersonBuilder withLastname(String lastname){
      this.lastname = lastname;
      return this;
    }

    public PersonBuilder withPhonenumber(String phonenumber){
      this.phonenumber = phonenumber;
      return this;
    }

    /**
     * Just a sprinkle of syntactic sugar
    **/
    public PersonBuilder and(){
      return this;
    }
  }

  public static void main(String[] args){
    Person person = PersonBuilder.build(
      builder -> builder
        .withFirstname("Sonni")
          .and()
        .withLastname("Nielsen")
          .and()
        .withPhonenumber("066123456")
    );

    System.out.println(person);
  }
}
