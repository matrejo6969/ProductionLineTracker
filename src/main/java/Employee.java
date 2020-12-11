/**
 * Employee Class
 *
 * @author MiguelTrejo
 * The Employee class creates the information for an Employee Login,
 * containing employee data as well.
 */

import java.lang.Character;

class Employee{
  private final String name;
  private String username;
  private final String password;
  private String email;

  public int checkName (String name) {
    char space = ' ';
    int check = 0 , i ;
    int length = name.length();
    for ( i = 0; i < length; i++) {
      if(name.charAt(i) == space)
        check = 1;
    }
    return check;
  }

  public void setUsername (String name)   {
    int i, pos = 0;
    char space = ' ';
    String username = "";
    name.toLowerCase();

    int length = name.length();
    for(i = 0; i<length; i++) {
      if(name.charAt(i) == space)
      {
        pos = i + 1;
        break;
      }
    }
    username = username + name.charAt(0);
    for(i = pos; i < length; i++)
      username = username + name.charAt(i);
    this.username = username.toLowerCase();
  }

  public void setEmail (String name) {
    char c = ' ';
    int i;
    String email = "";
    name.toLowerCase();
    int length = name.length();
    for(i = 0; i<length; i++) {
      if(name.charAt(i) == c)
        email = email + ".";
      else
        email = email + name.charAt(i);
    }
    email = email.toLowerCase() + "@oracleacademy.Test";
    this.email=email;
  }
  public int isValidPassword(String password) {
    int checkTwo = 0, checkThree = 0, checkFour = 0, checkFive = 0, i;
    int length = password.length();
    for(i = 0;i < length; i++) {
      char ch = password.charAt(i);
      if(Character.isUpperCase(ch))
        checkThree = 1;
      else if(Character.isLowerCase(ch))
        checkTwo = 1;
      else if(ch=='"' ||ch=='!'||ch=='@'||ch=='&'||ch=='$'||ch=='#'||ch=='%'||ch=='^'||ch=='*')
        checkFour = 1;
      else
        checkFive = 1;
    }
    if(checkTwo == 1 && checkThree == 1 && checkFour == 1 && checkFive == 0)
      return 1;
    else
      return 0;
  }

  Employee(String name,String password) {
    this.name = name;
    if(checkName(name) == 1)
    {
      setUsername(name);
      setEmail(name);
    }
    else
    {
      this.username = "default";
      this.email = "user@oracleacademy.Test";
    }
    if(isValidPassword(password) == 1)
      this.password = password;
    else
      this.password = "pw";
  }

  @Override
  public String toString() {
    return "\n" + "Employee Details" + "\n"
        + "Name : " + this.name + "\n"
        + "Username : " + this.username + "\n"
        + "Email : " + this.email + "\n"
        + "Initial Password : " + this.password;
  }

}