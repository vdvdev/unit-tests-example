package entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@AllArgsConstructor
@Getter @Setter
public class Person{
    String name;
    int age;
    Gender gender;
}

