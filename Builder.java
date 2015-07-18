public class Person{
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

    public Person build() {
      return new Person(this);
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
    Person person = new PersonBuilder()
      .withFirstname("Sonni")
        .and()
      .withLastname("Nielsen")
        .and()
      .withPhonenumber("066123456")
      .build();

    System.out.println(person);
  }
}
