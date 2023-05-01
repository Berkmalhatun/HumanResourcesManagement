package com.hrm.repository.entity;

import com.hrm.repository.enums.EVocationStatus;
import lombok.*;
import lombok.experimental.SuperBuilder;
import nonapi.io.github.classgraph.json.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Document
public class Vocation extends BaseEntity{
    @Id
    private String id;

    private String vocationType;
    @Builder.Default
    private EVocationStatus vocationStatus=EVocationStatus.PENDING;
    private String companyManagerId;
    private String employeeId;
    private LocalDate startOfVocationDate;
    private LocalDate endOfVocationDate;
    private LocalDate responseOfRequestDate;
    private Long vocationDuration;
}