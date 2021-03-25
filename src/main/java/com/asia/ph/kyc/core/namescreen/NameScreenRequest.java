package com.asia.ph.kyc.core.namescreen;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class NameScreenRequest implements Serializable {

    private static final long serialVersionUID = 4874625939423721164L;

    private String firstName;

    private String middleName;

    private String lastName;

}
