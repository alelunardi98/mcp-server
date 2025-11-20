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
public class Claim {

    @Id
    private String id;
    private String policyId;
    private double estimatedDamageValue;
    private String description;
    private String status;
}
