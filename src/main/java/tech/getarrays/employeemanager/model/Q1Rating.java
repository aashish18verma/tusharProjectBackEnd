package tech.getarrays.employeemanager.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Q1Rating implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(columnDefinition = "integer default 0")
    private Integer targetsAchieved;
    @Column(columnDefinition = "integer default 0")
    private Integer attendance;
    @Column(columnDefinition = "integer default 0")
    private Integer studentsAssessment;
    @Column(columnDefinition = "integer default 0")
    private Integer presentation;
    @Column(columnDefinition = "integer default 0")
    private Integer avg;
}
