package ci.ayiyikoh.dto;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {
    private Long customerId;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String emailAdreesse;
    private String street;
    private String country;
    private String city;
}
