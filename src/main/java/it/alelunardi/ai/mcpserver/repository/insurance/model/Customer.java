package it.alelunardi.ai.mcpserver.repository.insurance.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table
public class Customer {

    @Id
    private String id;
    private String fullName;
    private int age;
    private String profession;
    private double grossAnnualIncome;
    private String address;
    private boolean smoker;
}
