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
public class Policy {

    @Id
    private String id;
    private String type;
    private String name;
    private double basePremium;
    private double coverageAmount;
    private String description;
    private int minAge;
    private int maxAge;
}
