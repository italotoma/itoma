package groupid_mcgill.artifactid_mcgill.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Author {
    private String dni;
    private String firstName;
    private String lastNameFather;
    private String lastNameMother;
    private Integer age;
    private String biography;
}
